package org.example.conditional;

import org.example.option.JynModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/01/11 20:20:08
 * @Version: 1.0.0
 */
@Configuration
public class OnClassConfig {

    @Bean
    @ConditionalOnClass(JynModel.class)
    public Service1 getS1() {
        return new Service1();
    }

    @Bean
    @ConditionalOnMissingClass("org.example.option.SzyModel")
    public Service2 getS2() {
        return new Service2();
    }
}
