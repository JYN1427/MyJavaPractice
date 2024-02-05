package org.example.common.system.property;

/**
 * System的Properties在线程间可以传递
 *
 * @author jiayn01
 * @date 2023-10-20 10:28:00
 */
public class GetPropertyBetweenThreads {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("key1", "value1");
        Thread.sleep(100);
        new Thread(() -> {
            String value = System.getProperty("key");
            System.out.println(value != null ? value : "没有获取到");
        }).start();
    }
}
