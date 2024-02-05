package org.example.common.classLoader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Jia Yuning
 * @Description: 类加载器学习：类加载器的作用是负责类的加载并生成一个Class实例
 * @Date: 2023/07/14 22:35:14
 * @Version: 1.0.0
 */
public class ClassLoaderLearn {
    // 掌握: 使用类的加载器获取流, 并读取配置文件信息。即, 通过ClassLoader获取指定配置文件
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();
        // 默认路径为当前Module下的src下
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("io\\myInfo.properties");

        properties.load(stream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name + ": " + password);

    }
}
