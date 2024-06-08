package com.example.springdemo.learn;

import com.example.springdemo.aaaIOC.MyBean;
import com.example.springdemo.learn.bean.ChildService;
import com.example.springdemo.learn.bean.ParentService;
import com.example.springdemo.learn.bean.SubUser;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/14 22:26:15
 * @Version: 1.0.0
 */
public class BeanDefinitionRegistry {
    public static void main(String[] args) {

    }

    @Test
    public void testBeanDefinitionRegistry() {
        // 创建 BeanDefinitionRegistry
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

        // 创建一个 BeanDefinition
        BeanDefinition beanDefinition = new RootBeanDefinition(MyBean.class);

        // 注册 BeanDefinition
        registry.registerBeanDefinition("myBean", beanDefinition);

        // 从 BeanFactory 中获取 Bean
        MyBean myBean = registry.getBean("myBean", MyBean.class);

        // 使用 Bean
        myBean.printMessage();

    }


}
