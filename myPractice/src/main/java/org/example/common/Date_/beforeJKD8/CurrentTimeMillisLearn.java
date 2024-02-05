package org.example.common.Date_.beforeJKD8;

// currentTimeMillis() 常用于计算时间差
public class CurrentTimeMillisLearn {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
