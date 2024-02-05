package org.example.common.Object4Test;

// 测试静态
public class Obj4Static {
    private static double num = 1.23D;
    private static int x;

    public static double getNum() {
        return num;
    }

    public static void setNum(double num) {
        Obj4Static.num = num;
    }
}
