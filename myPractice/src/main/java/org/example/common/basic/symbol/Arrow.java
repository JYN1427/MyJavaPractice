package org.example.common.basic.symbol;

/**
 * 二进制在左右箭头的二进制运算
 *
 * @author jiayn01
 * @date 2024-01-15 10:23:55
 */
public class Arrow {
    
    public static final int TOTAL_SIZE = 32;
    
    public static void main(String[] args) {
        leftArrow(8);
        leftArrow(-8);

        rightArrow(8);
        rightArrow(-8);
    }


    /**
     *  << : 左移一位, 右侧补0
     *
     * @param i
     */
    public static void leftArrow(int i) {
        System.out.println("i的二进制: " + toFixedBinStr(i));
        int i1 = i<< 1;
        System.out.println("i<<1 =   " + toFixedBinStr(i1));

        System.out.println("\n");
    }


    /**
     *  >> : 右移一位, 左侧 正数补0、负数补1
     *  >>> : 右移一位, 左侧一律补0
     *
     * @param i
     */
    public static void rightArrow(int i) {
        System.out.println("i的二进制: " + toFixedBinStr(i));
        int i1 = i >> 1;
        System.out.println("i>>1 =   " + toFixedBinStr(i1));
        int i2 = i >>> 1;
        System.out.println("i>>>1 =  " + toFixedBinStr(i2));

        System.out.println("\n");
    }


    /**
     * toBinaryString不会增加前导0, 手动添加一下
     */
    public static String toFixedBinStr(int num) {
        String s = Integer.toBinaryString(num);

        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < TOTAL_SIZE - s.length(); i++) {
            builder.append("0");
        }
        
        builder.append(s);
        return builder.toString();
    }
}
