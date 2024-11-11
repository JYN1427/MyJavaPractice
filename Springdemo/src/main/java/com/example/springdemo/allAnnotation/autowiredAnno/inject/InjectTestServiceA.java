package com.example.springdemo.allAnnotation.autowiredAnno.inject;

import com.example.springdemo.allAnnotation.autowiredAnno.circulation.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
