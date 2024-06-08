package com.example.springdemo.allTheInterfaces;
import com.example.springdemo.allTheInterfaces.A_common.Const;
import com.example.springdemo.allTheInterfaces.A_common.MyFactoryBean;
import com.example.springdemo.allTheInterfaces.A_common.MyInitializingBean;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/26 21:04:48
 * @Version: 1.0.0
 */
@SpringBootTest
public class CommonTest {

    @Autowired
    private MyInitializingBean myInitializingBean;

    @Autowired
    private AnnotationConfigApplicationContext applicationContext;

    @Autowired
    private MyFactoryBean myFactoryBean;

    @BeforeEach
    public void init() {
        System.out.println(Const.PRE_STR + " 开始测试 ");
    }

    /**
     * 测试FactoryBean的使用
     *  FactoryBean本身的注入就跟普通的bean是一样的
     *  只是一旦直接调用它的getObject方法、或者通过applicationContext.getBean(FactoryBean的名字)会间接调用getObject
     */
    @Test
    public void testFactoryBean() throws Exception {
        // 1 拿到getObject返回的Bean, 而非工厂Bean
        // 1.1 使用applicationContext.getBean, 每次获取的是单例bean(前提是实现FactoryBean接口的isSingleton方法时return为true)
        Object o11 = applicationContext.getBean("NingGe");
        System.out.println(o11);
        Thread.sleep(500);
        Object o11X = applicationContext.getBean("NingGe");
        System.out.println(o11X);

        // 1.2 使用getObject, 每次获取的是新对象
        Thread.sleep(500);
        Object o12 = myFactoryBean.getObject();
        System.out.println(o12);
        Thread.sleep(500);
        Object o12X = myFactoryBean.getObject();
        System.out.println(o12X);

        // 2 拿到真正实现了FactoryBean的工厂Bean, 需要加上前缀&
        Object o21 = applicationContext.getBean("&NingGe");
        Object o22 = applicationContext.getBean(MyFactoryBean.class);
        System.out.println(o21);
        System.out.println(o22);
    }

}