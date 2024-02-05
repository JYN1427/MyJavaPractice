package org.example.common.switchcase;

/**
 * switch case 语法
 *
 * @author jiayn01
 * @date 2023-12-07 10:57:33
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println(testSwitch("yes"));
        System.out.println(testSwitch("kkk"));
    }

    public static String testSwitch(String type) {
        String res = null;
        switch (type) {
            case "yes":
            case "YES":
            case "Yes":
                res = "1";
                break;
            case "no":
            case "NO":
            case "No":
                res = "0";
                break;
            default:
                res = "default";
                break;
        }
        return res;
    }
}
