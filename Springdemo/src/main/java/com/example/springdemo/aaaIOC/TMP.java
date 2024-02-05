package com.example.springdemo.aaaIOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/28 15:26:12
 * @Version: 1.0.0
 */
public class TMP {
    public static void main(String[] args) {
        testContainerStartup();
    }

    /**
     * 看源码用的, 实际启动不了, 因为我配了
     */
    public static void testContainerStartup() {
        // 使用Spring配置文件的路径创建ApplicationContext
        String[] configLocations = {"xmlConfig/application-context.xml"}; // 替换为你的实际配置文件路径
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocations);

        // 现在你可以通过context获取并使用bean
        // 例如，假设你有一个名为myBean的bean
        MyBean myBean = context.getBean(MyBean.class);
        // 对myBean进行所需的操作和断言
        myBean.printMessage();
    }
}
