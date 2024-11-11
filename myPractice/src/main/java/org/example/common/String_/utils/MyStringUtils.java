package org.example.common.String_.utils;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;
import java.util.regex.Pattern;

/**
 * String工具类
 *
 * @author jiayn01
 * @date 2023-10-25 09:38:46
 */
public class MyStringUtils {
    public static void main(String[] args) {
        List<String> exp0 = null;
        List<String> exp1 = new ArrayList<>();
        List<String> exp2 = Arrays.asList("1");
        List<String> exp3 = Arrays.asList("1", "2", "3", "4");
        List<String> exp4 = Arrays.asList("1", "3", "5");
        List<String> exp5 = Arrays.asList("1", "2", "3", "5", "6", "8", "9", "100");

        printList(findSubListBegin(exp2));
    }

    /**
     * 以多个分隔符来分割字符串
     *
     * @param str 源字符串
     * @param delimiters 分隔符
     * @return 分割后数组
     */
    public static String[] splitMulti(String str, String... delimiters) {
        if (delimiters == null || delimiters.length == 0) {
            throw new IllegalArgumentException("Delimiters cannot be null or empty.");
        }

        String regex = "";
        for (String delimiter : delimiters) {
            regex += Pattern.quote(delimiter) + "|";
        }
        regex = regex.substring(0, regex.length() - 1);
        return str.split(regex);
    }

    /**
     * 输出非连续子序列的起始元素
     *
     * @param list 原字符串list, 如[1, 2, 3, 5, 6, 8, 9]
     * @return 非连续子序列的起始元素, 如[1, 5, 8]
     */
    public static List<String> findSubListBegin(List<String> list) {
        if (CollectionUtil.isEmpty(list)) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        // 新建栈
        LinkedList<String> stack = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            String top = stack.peek();
            String now = list.get(i);

            // 元素一律入栈
            stack.push(now);

            // 记录非连续元素起点
            if (top != null && Integer.parseInt(top) != Integer.parseInt(now) + 1) {
                result.add(0, top);
            }
        }

        if (!stack.isEmpty()) {
            result.add(0, stack.pop());
        }

        return result;
    }

    public static void printList(List<?> list) {
        list.forEach(item -> System.out.print(item + " "));
    }
}
