package com.megvii.lbg.synchronizer.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.megvii.lbg.synchronizer.mapper.OperationLogHistoryMapper;
import com.megvii.lbg.synchronizer.model.entity.OperationLogHistoryDO;
import com.megvii.lbg.synchronizer.model.OperationLogIndex;
import com.megvii.lbg.synchronizer.service.OperationLogEsServer;
import com.megvii.lbg.synchronizer.util.DateUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 这里添加类的注释【强制】
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-05-09 19:27
 */
@SpringBootTest
public class ContentsIndexRepositoryTest {

    @Resource
    private OperationLogEsServer operationLogEsServer;
    @Resource
    private OperationLogHistoryMapper operationLogHistoryMapper;

    @Resource
    private ElasticsearchClient elasticsearchClient;

    @Test
    public void dbTest() {
        List<OperationLogHistoryDO> operationLogHistoryDOS = new ArrayList<>();

        int pageNo = 1;
        int pageSize = 1;

        while (true) {
            QueryWrapper<OperationLogHistoryDO> queryWrapper = new QueryWrapper<>();
            queryWrapper.last(" LIMIT " + (pageNo - 1) * pageSize + "," + pageSize);
            operationLogHistoryDOS = operationLogHistoryMapper.selectList(queryWrapper);
            if (CollectionUtils.isEmpty(operationLogHistoryDOS)) {
                break;
            }
            System.out.println("当前导入第[" + pageNo + "]页数据");
            List<OperationLogIndex> collect = operationLogHistoryDOS.stream().map(i -> {
                return OperationLogIndex.builder().
                        id(i.getId())
                        .appCode(i.getAppCode())
                        .appName(i.getAppName())
                        .lang(i.getLang())
                        .identityProviderName(i.getIdentityProviderName())
                        .username(i.getUsername())
                        .realName(i.getRealName())
                        .pageName(i.getPageName())
                        .btnName(i.getBtnName())
                        .terminal(i.getTerminal())
                        .content(i.getContent())
                        .createTime(i.getCreateTime())
                        .archiveTime(i.getArchiveTime()).build();

            }).collect(Collectors.toList());
            try {
                operationLogEsServer.indexingDocuments(collect);
            } catch (Exception e) {
                System.out.println("第[" + pageNo + "]页数据异常");
                e.printStackTrace();
            }
            pageNo++;
            break;
        }
    }

    @Test
    void deleteIndex() throws IOException {
        elasticsearchClient.indices().delete(i -> i.index("operation_log_new"));
    }


}
