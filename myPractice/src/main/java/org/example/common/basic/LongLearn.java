package org.example.common.basic;

import org.junit.Test;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/04 14:38:30
 * @Version: 1.0.0
 */
public class LongLearn {
    @Test
    public void testLong() {
        long num1 = 514850816L;
        double num2 = 514850816D;
        System.out.println("" + num1 / 1024 / 1024 / 1024 * 64);
        System.out.println("" + num2 / 1024 / 1024 / 1024 * 64);
    }
}
