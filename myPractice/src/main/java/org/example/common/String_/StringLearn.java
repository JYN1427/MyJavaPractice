package org.example.common.String_;

import java.util.Arrays;

public class StringLearn {
    public static void main(String[] args) {
        // equals
        String s1 = "123";
        boolean a = s1.equals("123");
        System.out.println(a);

        // substring
        String sub = s1.substring(1); // 或者substring(1, s1.length())
        System.out.println(sub);

        // split
        String s2 = "1:2:3:4";
        String[] splited = s2.split(":");
        System.out.println(Arrays.toString(splited));

        // replace
        String s3 = "p111111111111p";
        String newString = s3.replace("1", "0");
        System.out.println(newString);

        // trim
        String s4 = "   k   ";
        String afterTrim = s4.trim();
        System.out.println(afterTrim);

        // 转char[]
        String s5 = "123456";
        char[] charList = s5.toCharArray();
        String[] stringList = s5.split("");
        System.out.println(Arrays.toString(charList));
        System.out.println(Arrays.toString(stringList));
    }
}
