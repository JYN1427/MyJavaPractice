package com.example.springdemo.copyProperties;

import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/06 09:53:45
 * @Version: 1.0.0
 */
@Component
public class TargetBean {
    private String name;

    private Integer value;

    private Boolean isGood;

    public Boolean getGood() {
        return isGood;
    }

    public void setGood(Boolean good) {
        isGood = good;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
