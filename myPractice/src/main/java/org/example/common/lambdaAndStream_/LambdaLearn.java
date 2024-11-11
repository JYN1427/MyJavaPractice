package org.example.common.lambdaAndStream_;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaLearn {
    public static void main(String[] args) {
        // 1
        // basic();

        // 2
        staticReference();

        // 3
    }

    // 1 有参+return
    public static void basic() {
        Test test = (name,age) -> {
            System.out.println(name+age+"岁了！");
            return age + 1;
        };
        int age = test.dosth("小新",18);
        System.out.println(age);
    }

    // 2 静态方法引用
    public static void staticReference() {
        List<Integer> myList = Arrays.asList(1, 2, 3, 0);
        // Collections.sort(myList, (o1, o2) -> MyUtil.myCompare(o1, o2));
        Collections.sort(myList, MyUtil::myCompare);
        myList.forEach(System.out::print);
    }
}

class MyUtil{
    public static int myCompare(Integer num1, Integer num2) {
        return num1.compareTo(num2);
    }
}