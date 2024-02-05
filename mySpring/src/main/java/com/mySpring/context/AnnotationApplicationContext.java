package com.mySpring.context;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jia Yuning
 * @Description: 模拟Spring IOC容器对Bean的管理
 * @Date: 2023/07/15 22:42:01
 * @Version: 1.0.0
 */
public class AnnotationApplicationContext implements ApplicationContext{
    private Map<Class, Object> beanFactory = new HashMap<>(); // 创建一个Map结构用于存放Bean对象

    private static String classesRootPath; // 存放编译之后的target/classes的路径

    // 返回Bean对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 包扫描规则, 通过反射对 被@Bean修饰的类 进行实例化
    public static void aa(String basePackageName) {
        // 1 把.替换成斜杠\
        // \\.实际上被转义为两次，\\在java中被转换为一个'\'字符，然后'\.'被传给正则。 \.表示对点字符进行转义，使.就表示字符'.',而不使用它在正则中的特殊意义
        // 同理, \\\\在java中是\\, \\在正则中是\
        String packageName = basePackageName.replaceAll("\\.", "\\\\");

        // 2 获取包的绝对路径: 注意是编译之后的class文件的路径, 不是源代码的路径
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName);
            while(urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8"); // D:/IdeaProjects/preactice/mySpring/target/classes/com\mySpring
                classesRootPath = filePath.substring(0, filePath.length() - packageName.length()); // D:/IdeaProjects/preactice/mySpring/target/classes
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3 循环
    }

    // 扫描过程, 进行实例化

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationApplicationContext("com.mySpring");
//        // context.getBean()
//        System.out.println("\\\\.");
        aa("com.mySpring");
    }
}
