package com.example.SpringDemosProject.allAnnotation.autowiredAnno.circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/14 21:20:41
 * @Version: 1.0.0
 */
@Component("serviceB")
public class ServiceB {
    @Autowired
    private ServiceA serviceA;

    @Autowired
    private ServiceC serviceC;

    public ServiceB() {
        System.out.println("Service B 创建了");
    }

    public String getName() {
        return this.getClass().getName();
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public ServiceC getServiceC() {
        return serviceC;
    }
}
