package org.example.common.String_;

/**
 * toCharArray()及其妙用
 * MySQL的varchar长度就跟toCharArray似的
 *
 * @author jiayn01
 * @date 2023-09-25 15:52:08
 */
public class CharLearn {
    public static void main(String[] args) {
        // 有点类似于bitMap那种感觉, 下标的数其实就是一个字符的编码
        // 65535是编码范围
        int[] goodDict = new int[65535];

        String goodWords = "赵钱孙李周吴郑王";

        // 好的字符
        for (char chr : goodWords.toCharArray()) {
            goodDict[chr] = 1;
        }

        String word2Test = "张三李四王五";
        int num = 0;
        for (char chr : word2Test.toCharArray()) {
            if (goodDict[chr] == 1) {
                num += 1;
            }
        }
        System.out.println("目标姓氏有" + num);
    }
}
