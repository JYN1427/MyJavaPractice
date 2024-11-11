package com.example.springdemo.allAnnotation.conditional.onBean;

import com.example.springdemo.allAnnotation.conditional.onBean.City;
import com.example.springdemo.allAnnotation.conditional.onBean.Country;
import com.example.springdemo.allAnnotation.conditional.onBean.LonelyCity;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/26 21:49:29
 * @Version: 1.0.0
 */
@Configuration
public class ConditionalOnBeanConfig {

    /**
     * onBean/onMissingBean - 可以传类型, 也可以传Bean的名字
     * 如果把Country注释掉, 就会只注入LonelyCity
     */
    @Bean("MyCountry")
    Country getCountry() {
        return new Country();
    }

    @Bean
    @ConditionalOnBean({Country.class})
    City getCity() {
        return new City();
    }

    @Bean
    @ConditionalOnMissingBean(name = "MyCountry")
    LonelyCity getLonelyCity() {
        return new LonelyCity();
    }

}
