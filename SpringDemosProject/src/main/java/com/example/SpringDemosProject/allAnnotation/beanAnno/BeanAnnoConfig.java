package com.example.SpringDemosProject.allAnnotation.beanAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean注解不指定name的时候, bean的名称自动采用方法名称
 *
 * @author jiayn01
 * @date 2024-06-14 15:56:57
 */
@Configuration
public class BeanAnnoConfig {


    @Bean
    public MyTestAnnoBeanType myTestAnnoBean01() {
        return new MyTestAnnoBeanType("111");
    }

    @Bean
    public MyTestAnnoBeanType myTestAnnoBean02() {
        return new MyTestAnnoBeanType("222");
    }

}


