package com.example.springdemo.demos;

import com.example.springdemo.aop.TimeCost;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/06/29 21:03:51
 * @Version: 1.0.0
 */
@Component
public class Demo extends BaseDemo{
    public static void main(String[] args) {
    }

    @TimeCost("test sth")
    public void test() throws InterruptedException {
        Thread.sleep(100);
    }

}
