package com.example.SpringDemosProject.allAnnotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/12 21:43:13
 * @Version: 1.0.0
 */
@Component
public class ValueAnno {

    @Value("${spring.application.name}")
    private String appName;

    private static String name;

    public ValueAnno() {
        System.out.println("@Value成员在构造器阶段还没有赋值 - spring.application.name = " + appName);
    }

    @PostConstruct
    public void init() {
        name = this.appName;
        System.out.println("@Value成员在PostConstruct阶段有值了 - spring.application.name = " + appName);
        System.out.println("@PostConstruct - 赋值给静态变量name = " + name);
    }
}
