package com.example.springdemo.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/24 22:52:01
 * @Version: 1.0.0
 */

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 创建一个线程池对象
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 提交多个任务到线程池中
        for (int i = 1; i <= 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
