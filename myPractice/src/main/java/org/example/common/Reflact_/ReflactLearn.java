package org.example.common.Reflact_;

import org.example.common.Object4Test.Person;
import org.junit.Test;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/14 22:14:37
 * @Version: 1.0.0
 */
public class ReflactLearn {
    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1 静态
        Class clzz1 = Person.class;
        Person person = (Person) clzz1.newInstance();

        // 2 动态
        Person p = new Person("Sam", 1, 'M');
        Class clzz2 = p.getClass();

        // 3 forName
        String className = "Object4Test.Person";
        Class clzz3 = Class.forName(className);

        // 4 ClassLoader
        Class clzz4 = ClassLoader.getSystemClassLoader().loadClass(className);


        if(clzz1 == clzz2 && clzz2 == clzz3 &&clzz3 == clzz4) {
            System.out.println("True");
        }
    }
}
