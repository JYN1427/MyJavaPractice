package org.example.spi.service.impl;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/24 22:07:00
 * @Version: 1.0.0
 */
public class MyServiceSecImpl{
    public MyServiceSecImpl() {
        System.out.println("aaaaaaaaaaaaaaaaa");
    }

    @Bean
    public SomeBean getSomeBean() {
        return new SomeBean("new SomeBean宁宁啊啊");
    }

}


class SomeBean {
    private String name;

    public SomeBean(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
