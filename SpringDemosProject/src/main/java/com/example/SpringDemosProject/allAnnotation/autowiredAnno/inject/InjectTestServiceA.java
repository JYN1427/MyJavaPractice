package com.example.SpringDemosProject.allAnnotation.autowiredAnno.inject;

import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/19 21:07:21
 * @Version: 1.0.0
 */
@Component
public class InjectTestServiceA {

    public InjectTestServiceA() {
        System.out.println("InjectTestServiceA构造器被执行了");
    }
}
