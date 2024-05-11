package com.megvii.lbg.synchronizer.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientOptions;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这里添加类的注释【强制】
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-05-11 09:57
 */
@Configuration
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.uris}")
    private String server;

    @Bean
    public ElasticsearchClient initRestClient() {
        // URL and API key
        String serverUrl = server;
//        String apiKey = "VnVhQ2ZHY0JDZGJrU...";

        // Create the low-level client
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
//                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        return new ElasticsearchClient(transport);
    }

    @Bean
    RestClientTransport restClientTransport(RestClient restClient, ObjectProvider<RestClientOptions> restClientOptions) {
        return new RestClientTransport(restClient, new JacksonJsonpMapper(), restClientOptions.getIfAvailable());
    }
}
