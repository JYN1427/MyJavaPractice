package org.example.common.double_bigDecimal;

import java.math.BigDecimal;

/**
 * 金额计算推荐使用BigDecimal而不是Double类型，主要原因如下：
 * <p>
 * 精度问题：
 * double和float是Java中的浮点数类型，它们基于IEEE 754标准进行浮点数的二进制表示，这会导致精确的小数位数有限，并且某些十进制小数无法精确转换为二进制。
 * 例如，0.1（十进制）在二进制下不能精确表示，因此多次相加或乘除后可能会累积误差，这对于金融、货币等需要高精度计算的场景是不可接受的。
 * <p>
 * 舍入控制：
 * BigDecimal允许开发者指定精确的小数位数，并提供了多种舍入模式，确保金额计算能够按照财务规则正确处理四舍五入，
 * 而double则没有内置这样的机制。
 * <p>
 * 不变性：
 * BigDecimal是不可变对象，这意味着一旦创建了一个BigDecimal实例，它的值就不能改变。这种特性有助于避免在多线程环境下出现竞态条件和意外的数据变化。
 */
public class DoubleAndBigDecimal {
    public static void main(String[] args) {
        doubleLostDemo();
    }


    /**
     * 验证Double丢失精度、BigDecimal精度准确
     * double类型直接相加的结果并不是理想的0.3，而是带有微小误差的值（如0.30000000000000004）
     */
    public static void doubleLostDemo() {
        // 初始化两个double类型的金额
        double a = 0.1;
        double b = 0.2;

        // 直接将它们相加
        double resultDirectAdd = a + b;

        // 按照理想情况，0.1 + 0.2 应该等于 0.3
        System.out.println("直接相加的结果: " + resultDirectAdd); // 输出可能是：0.30000000000000004

        // 创建一个BigDecimal对象进行精确计算
        BigDecimal bdA = new BigDecimal("0.1");
        BigDecimal bdB = new BigDecimal("0.2");

        // 使用BigDecimal进行相加
        BigDecimal resultBDAdd = bdA.add(bdB);

        // 输出BigDecimal的精确结果
        System.out.println("使用BigDecimal相加的结果: " + resultBDAdd); // 输出：0.3

    }

}
