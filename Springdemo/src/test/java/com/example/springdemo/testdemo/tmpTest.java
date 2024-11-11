package com.example.springdemo.testdemo;

import com.example.springdemo.demos.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: Jia Yuning
 * @Description: 测试自定义注解执行的切面
 * @Date: 2023/06/27 11:13:58
 * @Version: 1.0.0
 */

@SpringBootTest
public class tmpTest {
    @Autowired
    private Demo demo;

    @Test
    public void test1() {
        try {
            demo.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
