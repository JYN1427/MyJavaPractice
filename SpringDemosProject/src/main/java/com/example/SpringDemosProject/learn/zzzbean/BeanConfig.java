package com.example.SpringDemosProject.learn.zzzbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/28 22:30:50
 * @Version: 1.0.0
 */
@Configuration
public class BeanConfig {
    @Bean
    public ParentService parentService() {
        return new ParentService();
    }
}
