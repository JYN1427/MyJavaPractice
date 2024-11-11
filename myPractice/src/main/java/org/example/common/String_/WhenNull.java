package org.example.common.String_;

import org.junit.Test;

import java.util.Optional;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/06/04 21:51:39
 * @Version: 1.0.0
 */
public class WhenNull {

    /**
     * 当我们获取一个对象的属性后对他进行字符串拼接是行不通的
     * 因为如果该属性是null，就会变成"null"参与字符串拼接, 这显然不是我们要的
     */
    @Test
    public void testWhenNull() {
        TestModel testModel = new TestModel();
        String s = testModel.getName();
        Object obj = testModel.getObject();

        // 1 验证加号拼接: 行不通
        String s1 = s + " x";
        String s2 = obj + " x";
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("----");

        // 2 验证StringBuffer拼接: 行不通
        StringBuffer sb1 = new StringBuffer("x ");
        sb1.append(s);
        StringBuffer sb2 = new StringBuffer("x ");
        sb2.append(obj);
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

        System.out.println("----");

        // 3 解决方案: 使用Optional.ofNullable(s).orElse("") : 无敌行得通
        String s3 = Optional.ofNullable(s).orElse("") + " x";
        System.out.println(s3);
        StringBuffer sb3 = new StringBuffer("x ");
        sb3.append(Optional.ofNullable(s).orElse(""));
        System.out.println(sb3.toString());
    }
}

class TestModel {
    String name;
    Object object;
    public String getName() {
        return name;
    }
    public Object getObject() {
        return object;
    }

}
