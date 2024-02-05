package com.example.springdemo.DesignMode.template.use;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-08 17:07:04
 */
@Component
public class CheckStrategyFactory implements SmartInitializingSingleton, ApplicationContextAware {

    private static ApplicationContext context;

    private Map<String, BasePlanCheckStrategy> strategyMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        if (context == null) {
            return;
        }

        String[] beanDefinitionNames = context.getBeanNamesForType(BasePlanCheckStrategy.class, false, true);
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = context.getBean(beanDefinitionName);
        }
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public BasePlanCheckStrategy getStrategyByKey(String strategyKey) throws Exception {
        BasePlanCheckStrategy strategy = strategyMap.get(strategyKey);

        if (Objects.isNull(strategy)) {
            throw new Exception("找不到对应Strategy");
        }

        return strategy;
    }
}
