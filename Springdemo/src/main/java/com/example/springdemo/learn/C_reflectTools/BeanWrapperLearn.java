package com.example.springdemo.learn.C_reflectTools;

import com.example.springdemo.learn.zzzbean.SubUser;
import com.example.springdemo.learn.zzzbean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * spring对反射原生api进行了封装，让其使用起来更简单
 * 可以更好的结合spring的其他api
 *
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/02 21:39:09
 * @Version: 1.0.0
 */
@Slf4j
public class BeanWrapperLearn {

    @Test
    public void test() {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(User.class);
        beanWrapper.setPropertyValue("name", "Jia Yuning");
        log.info("bean -> {}", beanWrapper.getWrappedInstance());

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", "Jia BABA");
        propertyValues.add("subUser", new SubUser("Jia aa"));
        beanWrapper.setPropertyValues(propertyValues);
        log.info("bean -> {}", beanWrapper.getWrappedInstance());
    }

}
