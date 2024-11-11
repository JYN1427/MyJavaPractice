package org.example.common.thread.tmp;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-13 11:03:59
 */
public class MyTask implements Runnable{

    static final int time = 10;

    static final boolean isTrue = true;

    @Override
    public void run() {
        while (isTrue) {
            System.out.println("doing...");
        }
    }
}
