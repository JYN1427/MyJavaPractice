package org.example.common.otherAPI;

import org.junit.Test;

/**
 * @Author: Jia Yuning
 * @Description: Runtime类对应的是整个Java进程的内存使用的运行时环境, 是单例的
 * @Date: 2023/07/04 11:48:40
 * @Version: 1.0.0
 */
public class RuntimeLearn {
    @Test
    public void testRuntime() {
        Runtime runtime = Runtime.getRuntime(); // 单例模式 饿汉式
        double initMemory = runtime.totalMemory(); // 1 JVM初始化时堆内存总量: 默认是物理电脑内存的1/64
        double maxMemory = runtime.maxMemory(); // 2 JVM最大堆内存总理: 默认是物理电脑内存的1/4

        // 模拟堆内存占用
        String s = "";
        for(int i = 0; i < 1000; i++) {
            s += i;
        }

        double freeMemory = runtime.freeMemory(); // 3 空闲堆内存总量

        // 打印
        System.out.println(initMemory);
        System.out.println((initMemory / 1024 / 1024 / 1024) * 64 + "GB");
        System.out.println((maxMemory / 1024 / 1024 / 1024) * 4 + "GB");
        System.out.println(freeMemory / 1024 / 1024 + "MB");
    }
}
