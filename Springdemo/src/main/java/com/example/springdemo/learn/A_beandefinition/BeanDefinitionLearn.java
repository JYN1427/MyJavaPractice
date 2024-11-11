package com.example.springdemo.learn.A_beandefinition;

import com.example.springdemo.learn.zzzbean.ChildService;
import com.example.springdemo.learn.zzzbean.ParentService;
import com.example.springdemo.learn.zzzbean.SubUser;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/14 22:26:15
 * @Version: 1.0.0
 */
public class BeanDefinitionLearn {
    public static void main(String[] args) {

    }

    @Test
    public void testBeanDefinition() {
        // 创建一个常用的GenericBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClassName("com.example.springdemo.learn.bean.User");
        genericBeanDefinition.setLazyInit(false);

        // 创建MutablePropertyValues并set进GenericBeanDefinition
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", "Sam");
        propertyValues.add("subUser", new SubUser("sub Sam"));
        genericBeanDefinition.setPropertyValues(propertyValues);
        // 打印查看效果
        System.out.println(genericBeanDefinition);

        // 将属性拷贝到RootBeanDefinition
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.overrideFrom(genericBeanDefinition);
        System.out.println(rootBeanDefinition);
    }

    /**
     * 从Spring2.5开始，ChildBeanDefinition已经不再使用，取而代之的是GenericBeanDefinition
     */
    @Test
    public void testChildBeanDefinition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 父
        GenericBeanDefinition parentBeanDefinition = new GenericBeanDefinition();
        parentBeanDefinition.setBeanClass(ParentService.class);
        parentBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        parentBeanDefinition.setAttribute("name", "jiayn01"); // 设置属性
        parentBeanDefinition.setAbstract(true);
        parentBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue(110); // 设置构造器传参
        parentBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("jiayn02");

        // 子
        GenericBeanDefinition childBeanDefinition = new GenericBeanDefinition();
        childBeanDefinition.setParentName("parent");
        childBeanDefinition.setBeanClass(ChildService.class);

        context.registerBeanDefinition("parent", parentBeanDefinition);
        context.registerBeanDefinition("child", childBeanDefinition);

        context.refresh();

        // 获取BeanDefinition
        // 从mergedBeanDefinitions取出了child，mergedBeanDefinitions存放的是合并后的BeanDefinition；
        // 打上断点，观察下mergedBeanDefinitions，会发现parentBeanDefinition和 childBeanDefinition在mergedBeanDefinitions都变为了RootBeanDefinition
        BeanDefinition child = context.getBeanFactory().getMergedBeanDefinition("child");
        for (String s : child.attributeNames()) {
            System.out.println(s + ":" + child.getAttribute(s));
        }
        System.out.println("scope:" + child.getScope());

        System.out.println("-------------------");

        // 获取成熟的Bean实例
        ChildService service = context.getBean(ChildService.class);
        System.out.println(service.getName());
        System.out.println(service.getId());
    }

}
