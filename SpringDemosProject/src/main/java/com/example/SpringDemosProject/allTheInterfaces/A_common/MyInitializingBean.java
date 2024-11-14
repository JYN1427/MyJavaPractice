package com.example.SpringDemosProject.allTheInterfaces.A_common;

import com.example.SpringDemosProject.allTheInterfaces.others.Test;
import com.example.SpringDemosProject.allTheInterfaces.runner.inf_ApplicationRunner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/26 20:59:50
 * @Version: 1.0.0
 */
@Component
public class MyInitializingBean
        extends inf_ApplicationRunner
        implements InitializingBean,
        BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    {
        System.out.println(Const.PRE_STR + " 静态代码块 ");
    }

    public MyInitializingBean(){
        System.out.println(Const.PRE_STR + " 构造方法 ");
    }

    /**
     * @PostConstruct
     */
    @PostConstruct
    public void construct(){
        System.out.println(Const.PRE_STR + " 正在 MyInitializingBean 的 @PostConstruct 方法中执行");
    }

    /**
     * InitializingBean
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(Const.PRE_STR + "正在  MyInitializingBean 的 afterPropertiesSet 中执行");
    }

    /**
     * ApplicationRunner
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Const.PRE_STR + " 正在 MyInitializingBean(继承了: 实现了ApplicationRunner接口的类) 的 run 方法中执行");
    }



    /**
     * BeanNameAware
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println(Const.PRE_STR + " BeanNameAware: 当前Bean的名字为" + s);
    }

    /**
     * BeanFactoryAware
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        Test bean = beanFactory.getBean(Test.class);
        System.out.println(Const.PRE_STR + " BeanFactoryAware: 获取到一个Bean名为" + bean.getClass().getName());
    }


    /**
     * ApplicationContextAware
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String applicationName = applicationContext.getApplicationName();
        Test bean = applicationContext.getBean(Test.class);
        System.out.println(Const.PRE_STR + " ApplicationContextAware: 获取到当前applicationName为" + applicationName);
    }


}