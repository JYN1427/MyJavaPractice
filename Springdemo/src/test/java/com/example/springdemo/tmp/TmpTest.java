package com.example.springdemo.tmp;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.internal.BigDecimals;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-08 10:33:46
 */
public class TmpTest {

    @Test
    public void tmpTest(){
        List<String> yearList = Arrays.asList("2019", "2020", "2021", "2022", "2023", "2024");
        List<String> history = Arrays.asList("2019", "2020", "2023");

        List<String> different = yearList.stream().filter(item -> !history.contains(item)).collect(Collectors.toList());

        List<String> startYearsList = findSubListBegin(history);
        startYearsList.forEach(System.out::println);
        System.out.println("------------");
        findSubListBegin(different).forEach(System.out::println);
    }

    /**
     * 输出非连续子序列的起始元素
     *
     * @param list 原字符串list, 如[1, 2, 3, 5, 6, 8, 9]
     * @return 非连续子序列的起始元素, 如[1, 5, 8]
     */
    public List<String> findSubListBegin(List<String> list) {
        if(list.size() == 1) {
            return list.subList(0, 1);
        }

        List<String> result = new ArrayList<>();

        // 新建栈
        LinkedList<String> stack = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            String top = stack.peek();
            String now = list.get(i);
            stack.push(now);
            if (top != null && Integer.parseInt(top) != Integer.parseInt(now) + 1) {
                result.add(0, top);
            }
        }

        if (!stack.isEmpty()) {
            result.add(0, stack.pop());
        }

        return result;
    }

    @Test
    public void stringTest(){
        List list = Arrays.asList("2019");
        List list2 = list.subList(0, 1);
        list2.forEach(System.out::println);
    }


    /**
     * NullPointerException
     */
    @Test
    public void nullTest1(){
        try {
            String s1 = null;
            BigDecimal b1 = new BigDecimal(s1);
            System.out.println(b1);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        }
    }

    /**
     * NumberFormatException
     */
    @Test
    public void nullTest2(){
        try {
            BigDecimal b1 = new BigDecimal("");
            BigDecimal b2 = new BigDecimal(0.5);
            BigDecimal b3 = b2.add(b1);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("数字样式异常");
            e.printStackTrace();
        }
    }



    @Test
    public void tmpTestx(){
        String s = null;
        String[] split = s.split(",");
        for (String s1 : split) {
            System.out.println(s1);
        }
    }


}
