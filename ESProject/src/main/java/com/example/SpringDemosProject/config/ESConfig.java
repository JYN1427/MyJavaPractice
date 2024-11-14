package com.example.SpringDemosProject.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-09-06 17:15:57
 */
public class ESConfig {

    @Value("${spring.elasticsearch.uris}")
    private String hostUrls;

    @Value("${spring.elasticsearch.rest.username}")
    private String userName;

    @Value("${spring.elasticsearch.rest.password}")
    private String pwd;

    //设置连接保活策略每5分钟自动发送数据保持http存活
    private final long KEEP_ALIVE_S = 5;

    //配置RestHighLevelClient依赖到spring容器中待用
    @Bean
    @Primary
    public RestHighLevelClient restHighLevelClient() throws MalformedURLException {
        final String[] hostArr = hostUrls.split(",");
        List<HttpHost> hosts = new ArrayList<>(hostUrls.length());
        for (String hostUrl : hostArr) {
            URL url = new URL(hostUrl);
            HttpHost httpHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
            hosts.add(httpHost);
        }

        RestClientBuilder restClientBuilder = RestClient.builder(hosts.toArray(new HttpHost[hosts.size()]));
        restClientBuilder.setRequestConfigCallback(requestConfigBuilder ->
                requestConfigBuilder.setConnectTimeout(10000)
                        .setSocketTimeout(60000));

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(userName, pwd));
        restClientBuilder.setHttpClientConfigCallback(httpClientBuilder ->
                httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
                        .setThreadFactory(new ThreadFactoryBuilder().setNameFormat("es-client-%d").build())
                        .setKeepAliveStrategy(((response, context) -> KEEP_ALIVE_S * 60 * 1000)));

        return new RestHighLevelClient(restClientBuilder);

    }


    @Bean
    @Primary
    public ElasticsearchRestTemplate elasticsearchRestTemplate(RestHighLevelClient restHighLevelClient){
        return new ElasticsearchRestTemplate(restHighLevelClient);
    }
}
