package com.example.springdemo.allAnnotation.autowiredAnno.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/14 21:20:32
 * @Version: 1.0.0
 */
@Component("serviceA")
public class ServiceA {
    @Lazy
    @Autowired
    private ServiceB serviceB;

    public ServiceA() {
        System.out.println("Service A 创建了");
    }

    public String getName() {
        return this.getClass().getName();
    }

    public ServiceB getServiceB() {
        return serviceB;
    }
}
