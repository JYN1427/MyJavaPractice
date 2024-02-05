package org.example.common.system.property;

/**
 * 在进程间人properties无法传递
 *
 * @author jiayn01
 * @date 2023-10-20 10:32:00
 */
public class GetPropertyBetweenProcess2 {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(System.getProperty("kk"));
            Thread.sleep(200);
        }
    }
}
