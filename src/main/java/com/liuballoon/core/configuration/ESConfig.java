/**
 * @Author liuballoon
 * @Github https://github.com/liuballoon
 * @Create 2022/6/11 12:27
 */
package com.liuballoon.core.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

/**
 * 配置 Elasticsearch
 */
@Configuration
public class ESConfig {

    @Bean
    public RestHighLevelClient ESClient() {
        ClientConfiguration clientConfig = ClientConfiguration.builder()
                .connectedTo("39.104.53.160:9200")
                .build();
        return RestClients.create(clientConfig).rest();
    }
}
