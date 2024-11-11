package org.example.common.String_;

public class StringPool {
    public static void main(String[] args) {
        String s1 = "AB";
        String s2 = "AB";
        String s3 = new String("AB"); // 采用new 创建的字符串对象不进入字符串池

        // 常量池，他俩指向同一个对象
        System.out.println(s1 == s2); // True
        System.out.println(s1.equals(s2)); // True

        // 采用new 创建的字符串对象不进入字符串池
        System.out.println(s1 == s3); // False
        // 调用intern()的时候，会检查字符串池中是否含有该字符串。
        // 由于之前定义的"AB"已经进入字符串池中，所以会得到相同的引用。
        System.out.println(s3.intern() == s1); // True
        System.out.println(s1.equals(s3)); // True


        String str1 = "a";
        String str2 = "b";
        String s4 = str1 + str2;
        String s5 = str1 + "b";
        // 字符串拼接的时候，如果有变量（如str1、str2）则不会进入字符串池中。
        System.out.println(s4.intern() == s3); // False
        System.out.println(s5.intern() == s3); // False


        //字符串拼接的时候，都是静态字符串的结果会添加到字符串池
        String x = "abc";
        String y = "a" + "b" + "c";
        System.out.println(x == y); // True
    }
}
