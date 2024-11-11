package org.example.common.optional_;

import org.junit.Test;

import java.util.Optional;

public class OptionalLearn {
    public static void main(String[] args) {
//        testCreateOptional();
//        testJudge();
//        testOrElse();
//        testFilterAndMap();
    }

    // 1 创建Optional对象
    @Test
    public void testCreateOptional() {
        // (1) 创建空Optional
        Optional<String> myEmptyOp = Optional.empty();

        // (2) 根据不是null的对象创建Optional
        String notNullString = "123";
        Optional<String> notEmptyOp = Optional.of(notNullString);

        // (3) 推荐: 无所谓是不是null, 创建空Optional
        String maybeString = null;
        Optional<String> maybeOp = Optional.ofNullable(maybeString);
    }

    // 2 判断Optional对象: isEmpty()、isPresent()、和ifPresent()
    @Test
    public void testJudge() {
        Optional<String> myEmptyOp = Optional.ofNullable(null);
        Optional<String> notEmptyOp = Optional.ofNullable("123");
        // System.out.println(myEmptyOp.isEmpty());  // isEmpty是Java11才有
        System.out.println(myEmptyOp.isPresent()); // false
        System.out.println(notEmptyOp.isPresent()); // false

        // ifPresent传lambda的时候必须带上value入参, 这里是Optional<String>, 所以传一个str
        notEmptyOp.ifPresent((str) -> {
            System.out.println("存在字符" + str);
        });
        notEmptyOp.ifPresent(System.out::println);
    }

    // 3 获取Optional对象的值
    // orElse方法和orElseGet, 在获取值的同时 设置在isEmpty()的时候干什么
    // 要么直接传一个值, 要么传一个函数
    @Test
    public void testOrElse() {
        String name = "123";

        System.out.println("orElse");
        // orElse()无论是否为empty都会调用函数内容
        String name2 = Optional.ofNullable(name).orElse(getDefaultValue());
        String name22 = Optional.ofNullable(name).orElse("");

        System.out.println("orElseGet");
        // orElseGt()只有为empty才执行函数内容
        String name3 = Optional.ofNullable(name).orElseGet(OptionalLearn::getDefaultValue);
    }

    // 4 过滤和映射
    @Test
    public void testFilterAndMap() {
        // filter()
        String s = "ABC";
        Optional<String> myOp = Optional.ofNullable(s);
        Optional<String> afterFilter = myOp.filter(str -> str.length() > 10);
        System.out.println(afterFilter.isPresent()); // false

        // map()
        Optional<String> afterMap = myOp.map(String::toLowerCase);
        String afterMapString = afterMap.orElse("");
        System.out.println(afterMapString); // abc
    }

    public static String getDefaultValue(){
        System.out.println("调用getDefaultValue");
        return "default";
    }



}
