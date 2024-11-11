package com.example.springdemo.thread;

/**
 * 自定义一个任务用于测试
 *
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/01/16 22:38:08
 * @Version: 1.0.0
 */
public class MyTask implements Runnable {
    int i = 0;


    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "程序员做第" + i + "个项目");
        try {
            // 睡6秒
            Thread.sleep(6000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
