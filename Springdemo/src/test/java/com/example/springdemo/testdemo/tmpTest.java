package com.example.springdemo.testdemo;

import com.example.springdemo.demos.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/06/27 11:13:58
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
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
