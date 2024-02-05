package com.example.springdemo.allAnnotation.AllPropertiesAnno.enableConfigurationProperties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/01/03 22:14:41
 * @Version: 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "my.properties")
public class MyPropertiesClass {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
