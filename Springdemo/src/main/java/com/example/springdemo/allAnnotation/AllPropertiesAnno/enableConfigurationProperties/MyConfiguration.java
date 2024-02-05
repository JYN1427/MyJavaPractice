package com.example.springdemo.allAnnotation.AllPropertiesAnno.enableConfigurationProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/01/03 22:16:32
 * @Version: 1.0.0
 */
@Configuration
@EnableConfigurationProperties({MyPropertiesClass.class})
public class MyConfiguration {
}
