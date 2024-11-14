package com.example.SpringDemosProject.learn.A_beandefinition;

import com.example.SpringDemosProject.aaaIOC.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/14 22:26:15
 * @Version: 1.0.0
 */
@Slf4j
public class BeanDefinitionRegistry {
    public static void main(String[] args) {
        log.info("Hellow");
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
