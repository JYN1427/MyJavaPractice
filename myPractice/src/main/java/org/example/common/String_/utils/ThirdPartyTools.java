package org.example.common.String_.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 第三方工具类测试
 *
 * @author jiayn01
 * @date 2023-10-31 10:40:43
 */
public class ThirdPartyTools {
    public static void main(String[] args) {
        testIsBlank();

        System.out.print("-----------");

        testIsEmpty();
    }

    /**
     * StringUtils.defaultIfEmpty
     */
    public static void testDefaultIfEmpty() {
        String s1 = null;
        String s2 = "";
        String s3 = "123";
        System.out.println(StringUtils.defaultIfEmpty(s1, "0"));
        System.out.println(StringUtils.defaultIfEmpty(s2, "0"));
        System.out.println(StringUtils.defaultIfEmpty(s3, "0"));
    }

    public static void testIsBlank() {
        String s1 = null;   // true
        String s2 = "";     // true
        String s3 = " ";    // true
        String s4 = "123";  // false
        System.out.println(StringUtils.isBlank(s1));
        System.out.println(StringUtils.isBlank(s2));
        System.out.println(StringUtils.isBlank(s3));
        System.out.println(StringUtils.isBlank(s4));
    }

    /**
     * 就是"  " 这种不一样
     */
    public static void testIsEmpty() {
        String s1 = null;   // true
        String s2 = "";     // true
        String s3 = " ";    // false ~
        String s4 = "123";  // false
        System.out.println(StringUtils.isEmpty(s1));
        System.out.println(StringUtils.isEmpty(s2));
        System.out.println(StringUtils.isEmpty(s3));
        System.out.println(StringUtils.isBlank(s4));
    }
}
