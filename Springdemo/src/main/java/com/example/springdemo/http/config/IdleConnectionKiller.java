package com.example.springdemo.http.config;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 14:40:09
 */
@Component
public class IdleConnectionKiller extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(IdleConnectionEvictor.class);

    @Resource(name = "httpClientConnectionManager")
    private HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionKiller() {
        // 注入的时候开始执行
        super();
        super.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
            logger.error("清理httpClient无效请求任务出错", ex);
        }
    }

    // 关闭清理无效连接的线程
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }

}