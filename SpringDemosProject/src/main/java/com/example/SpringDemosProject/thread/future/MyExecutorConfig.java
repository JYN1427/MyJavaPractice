package com.example.SpringDemosProject.thread.future;

import com.example.SpringDemosProject.thread.threadlocal.contact.MyTaskDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/17 21:57:41
 * @Version: 1.0.0
 */

@Configuration
public class MyExecutorConfig {

    /** 核心线程数（默认线程数） */
    private static final int corePoolSize = 20;
    /** 最大线程数 */
    private static final int maxPoolSize = 100;
    /** 允许线程空闲时间（单位：默认为秒） */
    private static final int keepAliveTime = 10;
    /** 缓冲队列大小 */
    private static final int queueCapacity = 200;
    /** 线程池名前缀 */
    private static final String threadNamePrefix = "Async-Service-";


    @Bean("mytaskExecutor")
    @Primary
    public ThreadPoolTaskExecutor mytaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);
        return executor;
    }

    @Bean("executorWithDecotator")
    public ThreadPoolTaskExecutor executorWithDecotator() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 通过Decorator实现子线程获取主线程的ThreadLocal
        executor.setTaskDecorator(new MyTaskDecorator());

        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        return executor;
    }

    public static void sleepTool(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
