package com.example.springdemo.allAnnotation.autowiredAnno.inject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/06/19 22:12:51
 * @Version: 1.0.0
 */
@SpringBootTest
class InjectTestBeanTest {

    @Autowired
    private InjectTestBean injectTestBean;

    @Test
    public void testInject() {
        InjectTestServiceA injectTestServiceA = injectTestBean.getInjectTestServiceA();
        System.out.println(injectTestServiceA);

        InjectTestServiceB injectTestServiceB = injectTestBean.getInjectTestServiceB();
        System.out.println(injectTestServiceB);
    }

}