package org.example.common.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: Jia Yuning
 * @Description: 读取Properties文件
 * @Date: 2023/07/14 22:41:01
 * @Version: 1.0.0
 */
public class ReadProperties {

    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        Properties properties = new Properties();

        InputStream fileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("myInfo.properties");

        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name + ": " + password);
    }
}
