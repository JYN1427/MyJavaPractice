package com.example.springdemo.allAnnotation.autowiredAnno.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/19 21:07:21
 * @Version: 1.0.0
 */
@Component("serviceC")
public class ServiceC {
    @Lazy
    @Autowired
    private ServiceB serviceB;

    public ServiceC() {
        System.out.println("Service C 创建了");
    }

    public String getName() {
        return this.getClass().getName();
    }

    public ServiceB getServiceB() {
        return serviceB;
    }
}
