package com.example.springdemo.allAnnotation.beanAnno;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * Bean注解不指定name的时候, bean的名称自动采用方法名称
 *
 * @author jiayn01
 * @date 2024-06-14 15:58:38
 */
@SpringBootTest
class BeanAnnoConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        Object myTestAnnoBean01 = applicationContext.getBean("myTestAnnoBean01");
        System.out.println(myTestAnnoBean01);  // MyTestAnnoBeanType{name='111'}

        Object myTestAnnoBean02 = applicationContext.getBean("myTestAnnoBean02");
        System.out.println(myTestAnnoBean02);  // MyTestAnnoBeanType{name='222'}
    }

}