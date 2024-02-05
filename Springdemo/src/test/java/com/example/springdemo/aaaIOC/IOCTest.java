package com.example.springdemo.aaaIOC;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/28 15:38:44
 * @Version: 1.0.0
 */
@SpringBootTest
public class IOCTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        MyBean myBean = applicationContext.getBean(MyBean.class);
        myBean.printMessage();
    }
}
