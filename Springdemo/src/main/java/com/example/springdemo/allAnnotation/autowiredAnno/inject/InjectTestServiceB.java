package com.example.springdemo.allAnnotation.autowiredAnno.inject;

import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/19 21:07:21
 * @Version: 1.0.0
 */
@Component
public class InjectTestServiceB {

    public InjectTestServiceB() {
        System.out.println("InjectTestServiceB构造器被执行了");
    }
}
