package com.example.SpringDemosProject.allAnnotation.autowiredAnno.inject;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/06/19 22:08:20
 * @Version: 1.0.0
 */
@Getter
@Component
public class InjectTestBean {

    private InjectTestServiceA injectTestServiceA;

    private final InjectTestServiceB injectTestServiceB;

    // @Autowired
    public InjectTestBean(InjectTestServiceB injectTestServiceB) {
        System.out.println("InjectTestBean的有参构造器被执行了");
        this.injectTestServiceB = injectTestServiceB;
    }


    /**
     * set注入必须加@Autowired
     */
     @Autowired
    public void setInjectTestServiceA(InjectTestServiceA injectTestServiceA) {
        System.out.println("InjectTestBean的setInjectTestServiceA被执行了");
        this.injectTestServiceA = injectTestServiceA;
    }



}
