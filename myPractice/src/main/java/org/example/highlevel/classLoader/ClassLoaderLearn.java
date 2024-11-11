package org.example.highlevel.classLoader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * @Author: Jia Yuning
 * @Description: 类加载器学习：类加载器的作用是负责类的加载并生成一个Class实例
 * @Date: 2023/07/14 22:35:14
 * @Version: 1.0.0
 */
public class ClassLoaderLearn {

    private final String s = "str";

    public static void main(String[] args) throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader.getClass());

        ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
        System.out.println(sysLoader.getClass());
    }

    /**
     * 通过Class.forName获得Class实例, 并调用newInstance创建对象
     *
     * @throws Exception
     */
    @Test
    public void testClassNewInstance() throws Exception{
        Class<?> cls = Class.forName("org.example.common.classLoader.ClassLoaderLearn");
        ClassLoaderLearn instance1 = (ClassLoaderLearn) cls.newInstance();
        System.out.println(instance1.s);

        ClassLoaderLearn instance2 = (ClassLoaderLearn) cls.newInstance();
        System.out.println(instance2 == instance1);
    }

    /**
     * 通过getParent()方法一直向上追溯双亲
     * 直到ExtClassLoader的parent是null, 即BootstrapClassLoader
     */
    @Test
    public void testGetClassLoader() {
        ClassLoader classLoader = ClassLoaderLearn.class.getClassLoader();
        StringBuffer split = new StringBuffer("|--");
        boolean needContinue = true;
        while (needContinue) {
            System.out.println(split.toString() + classLoader);
            if (classLoader == null) {
                needContinue = false;
            } else {
                classLoader = classLoader.getParent();
                split.insert(0, "\t");
            }
        }
    }

    /**
     * 使用类的加载器获取流, 并读取配置文件信息。即, 通过ClassLoader获取指定配置文件
     *
     * @throws IOException
     */
    @Test
    public void testGetResource() throws IOException {
        Properties properties = new Properties();
        // 默认路径为当前Module下的src下
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("io\\myInfo.properties");

        properties.load(stream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name + ": " + password);

    }

    /**
     * 当Java应用运行时，ApplicationClassLoader负责查找和加载CLASSPATH路径下的所有类和jar包中的类。
     * 这意味着你项目依赖的各种库文件（jar包）都被这个类加载器加载到JVM中，使得你的应用程序能够使用这些库中定义的类和资源。
     *
     * 通过URLClassLoader查看所有的classPath:
     */
    @Test
    public void testGetJavaClassPath() {
        URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL[] urLs = sysLoader.getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }
    }
}
