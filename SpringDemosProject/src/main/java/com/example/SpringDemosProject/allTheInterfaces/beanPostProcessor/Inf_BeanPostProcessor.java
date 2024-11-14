package com.example.SpringDemosProject.allTheInterfaces.beanPostProcessor;

import com.example.SpringDemosProject.allTheInterfaces.A_common.Const;
import com.example.SpringDemosProject.allTheInterfaces.A_common.MyInitializingBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/26 20:59:12
 * @Version: 1.0.0
 */
@Component
public class Inf_BeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyInitializingBean) {
            System.out.println(Const.PRE_STR + " 在 MyBeanPostProcessor 的 postProcessAfterInitialization 中");
        }
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyInitializingBean) {
            System.out.println(Const.PRE_STR + " 在 MyBeanPostProcessor 的 postProcessBeforeInitialization 中");
        }
        return bean;
    }
}