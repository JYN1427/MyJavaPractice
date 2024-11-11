package com.example.springdemo.http.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.nio.charset.StandardCharsets;

/**
 * 普通的http连接池单例写法
 *
 * @author jiayn01
 * @date 2023-11-08 14:20:06
 */
public class HttpPool {
    //全局参数
    private static PoolingHttpClientConnectionManager connectionManager = null;

    //设置请求参数
    private static RequestConfig config;

    private static CloseableHttpClient client;

    //单例模式创建
    private static void init() {
        synchronized (HttpPool.class) {
            if (client == null) {
                connectionManager = new PoolingHttpClientConnectionManager();

                // http请求线程池，最大连接数
                int requestMaxNum = 5000;
                ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(StandardCharsets.UTF_8).build();
                SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(5000).build();
                connectionManager.setDefaultConnectionConfig(connConfig);
                connectionManager.setDefaultSocketConfig(socketConfig);

                // 连接池最大生成连接数
                connectionManager.setMaxTotal(requestMaxNum);

                // 默认设置route最大连接数
                connectionManager.setDefaultMaxPerRoute(requestMaxNum);

                //设置请求参数
                config = RequestConfig.custom().setConnectTimeout(5000)
                        .setConnectionRequestTimeout(500)
                        .setSocketTimeout(5000)
                        .build();

                // 创建builder
                HttpClientBuilder builder = HttpClients.custom();

                //管理器是共享的，它的生命周期将由调用者管理，并且不会关闭
                //否则可能出现Connection pool shut down异常
                builder.setConnectionManager(connectionManager).setConnectionManagerShared(true);

                // 长连接策略
                builder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());

                // 创建httpClient
                client = builder.setDefaultRequestConfig(config).setRetryHandler(new MyRetryHandle()).build();
            }
        }
    }

    /**
     * 从池子中获取连接
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient getClientFromHttpPool() {
        // 多线程下多个线程同时调用 容易导致重复创建httpClient对象的问题, 所以加上了同步锁
        if (client == null) {
            init();
        }
        return client;
    }

}

