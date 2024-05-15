package com.megvii.lbg.synchronizer.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.mapping.TypeMapping;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import jakarta.annotation.PostConstruct;
import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import com.megvii.lbg.synchronizer.model.OperationLogIndex;
import com.megvii.lbg.synchronizer.service.OperationLogEsServer;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;



@Slf4j
@Service
public class OperationLogEsServerImpl implements OperationLogEsServer {

    private final String OPERATION_LOG_ES_INDEX = "operation_log_new";
    @Resource
    private ElasticsearchClient elasticsearchClient;


    @PostConstruct
    void init() throws IOException {
        BooleanResponse exists = elasticsearchClient.indices()
                .exists(c -> c.index(OPERATION_LOG_ES_INDEX));
        if (exists.value()) {
            return;
        }
        String mapping = getEsMapping("OperationLog.json");
        JsonParser parser1 = Json.createParser(new StringReader(mapping));
        CreateIndexResponse createIndexResponse = elasticsearchClient.indices().create(
                new CreateIndexRequest.Builder()
                        .index(OPERATION_LOG_ES_INDEX)
                        .mappings(TypeMapping._DESERIALIZER.deserialize(parser1, new JacksonJsonpMapper()))
                        .build()
        );
    }

    @Override
    public void indexingDocument(OperationLogIndex operationLogIndex) {
        try {
            elasticsearchClient.index(i ->
                    i.index(OPERATION_LOG_ES_INDEX)
                            .id(operationLogIndex.getId().toString())
                            .document(operationLogIndex)
            );
        } catch (Exception e) {
            log.info("添加操作日志es异常：", e);
        }
    }

    @Override
    public void indexingDocuments(List<OperationLogIndex> operationLogIndexList) {
        operationLogIndexList.forEach(this::indexingDocument);
    }

    @Override
    public List<OperationLogIndex> queryByContent(String contentLike) {
        try {
            SearchResponse<OperationLogIndex> response = elasticsearchClient.search(s -> s
                            .index(OPERATION_LOG_ES_INDEX)
                            .query(q -> q
                                    .match(t -> t
                                            .field("content")
                                            .query(contentLike)
                                    )
                            ),
                    OperationLogIndex.class
            );
            log.info("查下结果：{}", response.hits());
        } catch (Exception e) {
            log.info("查下操作日志es异常：", e);
        }
        return Collections.emptyList();
    }

    @Override
    public void deleteAll() {
        try {
            elasticsearchClient.delete(i -> i.index(OPERATION_LOG_ES_INDEX));
        } catch (Exception e) {
            log.error("删除操作日志失败：", e);
        }
    }

    private String getEsMapping(String fileName) {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/es-mappings/" + fileName);
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            resourceAsStream.close();
            return sb.toString();
//            String jsonString = CharStreams.toString(new InputStreamReader(resourceAsStream, Charsets.UTF_8));
        } catch (Exception e) {
            throw new IllegalArgumentException("读取es配置异常：", e);
        }
    }

}
