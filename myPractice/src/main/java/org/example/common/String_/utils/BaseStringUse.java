package org.example.common.String_.utils;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-13 11:03:07
 */
public class BaseStringUse {
    public static void main(String[] args) {
        String message = "1=%s, 2=%s, threes=%d";
        Long three = 3333L;
        String format = String.format(message, "one", "two", three);
        System.out.println(format);
    }
}
