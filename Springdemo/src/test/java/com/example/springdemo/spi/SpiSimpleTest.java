package com.example.springdemo.spi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/24 22:21:41
 * @Version: 1.0.0
 */

@SpringBootTest
public class SpiSimpleTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void test1() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("spring bean名称>>>>>>" + name);
        }
        System.out.println("------Bean 总计:" + applicationContext.getBeanDefinitionCount());
    }
}
