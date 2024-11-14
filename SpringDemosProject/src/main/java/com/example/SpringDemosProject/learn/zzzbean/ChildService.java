package com.example.SpringDemosProject.learn.zzzbean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/14 22:39:00
 * @Version: 1.0.0
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ChildService {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}