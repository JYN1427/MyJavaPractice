package org.example.common.A_HighLevel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/07 14:13:40
 * @Version: 1.0.0
 */
public class FunctionExample {
    public List<String> myMap4StringList(List<String> stringList, Function<String, String> function) {
        List<String> newList = new ArrayList<>();
        for(String s : stringList) {
            newList.add(function.apply(s));
        }
        return newList;
    }

    @Test
    public void test() {
        List<String> stringList = Arrays.asList("123", "12", "3");
        // 方式1: Lambda
        List<String> newList = myMap4StringList(stringList, s -> s.length() + "");
        // newList.forEach(System.out::println);


        // 方式2: 传入的时候重写
        myMap4StringList(stringList, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.length() + "";
            }
        });
    }
}


