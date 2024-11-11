package org.example.common.otherAPI;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/04 14:44:43
 * @Version: 1.0.0
 */
public class MathLearn {
    @Test
    public void test1() {
        //Math.abs(x) // 对x求绝对值
        //Math.sqrt(x) // 对x求平方根
        //Math.pow(x, y) // 求x的y次方
        //
        //Math.ceil(x) // 对x向上取整
        //Math.floor(x) // 对x向下取整
        //Math.round(x) // 对x四舍五入
        //
        //Math.max(a, b) // 求最大
        //Math.min(a, b) // 求最小
        //
        //Math.random() // 该方法用于生成一个大于0.0小于1.0的随机值
    }

    @Test
    // 对精度要求高
    public void testBigDecimal() {
        BigDecimal b1 = new BigDecimal("123123.123123123123");
        // 保留10位, 四舍五入
        BigDecimal res = b1.divide(new BigDecimal("5.555555"), 10, BigDecimal.ROUND_UP);
        System.out.println(res);
    }

    @Test
    public void testBigInteger() {
        BigInteger b1 = new BigInteger("123123123123123123123123123123123123");
        BigInteger b2 = new BigInteger("123123123123123123123123123123123123");
        BigInteger res = b1.add(b2);
    }


}
