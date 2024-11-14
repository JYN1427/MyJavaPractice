package com.example.SpringDemosProject.springSourceCode.InitializingBean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 18:49:03
 * @Version: 1.0.0
 */
@Component
public class TestObj implements InitializingBean {

    /**
     * 1 构造方法
     */
    public TestObj() {
        System.out.println("执行Bean类的类构造方法");
    }

    /**
     * 2 构造方法之后执行
     */
    @PostConstruct
    public void postConstruct() {
        System.out.println("执行被@PostConstruct修饰的方法");
    }

    /**
     * 3 Bean初始化完成之后执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行afterPropertiesSet...");
    }

    /**
     * 4 init-method用法
     *   配合@Bean(initMethod = ...)使用, 通过@Bean注解方法返回Bean的时候, 最后会去执行一下这个init-method
     */
    public void initTestObj() {
        System.out.println("执行init-method...");
    }


//    @Bean(initMethod = "initTestObj", name = "myTmpTestObj")
//    public TestObj getBeanTest() {
//        return new TestObj();
//    }
}
