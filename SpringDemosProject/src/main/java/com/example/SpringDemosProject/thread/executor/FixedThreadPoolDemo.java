package com.example.SpringDemosProject.thread.executor;

import com.example.SpringDemosProject.thread.MyTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool的核心线程数是10，最大线程数是10，非核心线程存活时间为0，最大线程数和核心线程数相等，也没办法创建其他非核心线程了。
 * 队列是LinkedBlockingQueue无界队列，先简单说是可以无限存储数据。队列是一个数据结构，有着FIFO，就是先进先出
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++) {
            fixedThreadPool.execute(new MyTask(i));
        }
    }
}
