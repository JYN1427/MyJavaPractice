package org.example.common.basic;

// 无穷大
public class InfinityLearn {
    private static final Float f1 = Float.POSITIVE_INFINITY; // 正无穷
    private static final Float f2 = Float.NEGATIVE_INFINITY; // 负无穷

    private static final Double d1 = Double.POSITIVE_INFINITY; // 正无穷
    private static final Double d2 = Double.NEGATIVE_INFINITY; // 负无穷

    public static void main(String[] args) {
        boolean x = Float.compare(0, f1) == -1;
        boolean y = Float.compare(0, f2) == 1;
        System.out.println(x);
        System.out.println(y);
    }
}
