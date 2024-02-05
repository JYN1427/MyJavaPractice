package org.example.common.Map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HashMapLearn {
    public static void main(String[] args) {
        // 1. 新建
        Map<Integer, String> usersMap = new HashMap<>();
        usersMap.put(1, "jyn");
        usersMap.put(2, "szy");
        usersMap.put(3, "baby");

        // 2. 遍历
        // 2.1 for (Set entrySet()方法	返回 Map 集合中所有键-值对的 Set 集合，此 Set 集合中元素的数据类型为 Map.Entry)
        for(Map.Entry<Integer, String> entry: usersMap.entrySet()) {
            Integer mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + "：" + mapValue);
        }

        // 2.2 使用 for-each 循环遍历 key 或者 values
        int res = 0;
        String res2 = "";
        for(Integer key: usersMap.keySet()) {
            res += key;
        }
        System.out.println("key sum: " + res);

        for(String value: usersMap.values()) {
            res2 += value;
        }
        System.out.println("value sum: " + res2);


        // 2.3 迭代器遍历
        // Map不能直接.iterator()的

        // 2.3.1 整体遍历Entry
        Iterator<Map.Entry<Integer, String>> it0 = usersMap.entrySet().iterator();
        while(it0.hasNext()) {
            Map.Entry<Integer, String> entry = it0.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        // 2.3.2 局部便利Key
        Iterator it = usersMap.keySet().iterator();
        while(it.hasNext()) {
            Object k = it.next();
            Object v = usersMap.get(k);
            System.out.println("学号：" + k + "，姓名:" + v);
        }


        // 3 我自己写的：（就是不指明具体类型呗可以）
        Map<Object, Object> stuff = new HashMap<>();
        stuff.put(1, "3");
        stuff.put("4", usersMap);
        String n = (String) stuff.get(1);
        System.out.println(n);
        System.out.println(stuff);


        // 4 其他
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的学号：");
        int num = input.nextInt();
        if (usersMap.containsKey(String.valueOf(num))) { // 判断是否包含指定键
            usersMap.remove(String.valueOf(num)); // 如果包含就删除
        } else {
            System.out.println("该学生不存在！");
        }


        // JDK10 新特性
//        Map<String, String> newMap = new HashMap<>();
//        newMap.put("1", "one");
//        newMap.put("2", "two");
//
//        Set<Map.Entry<String, String>> entrySet = newMap.entrySet();
//        var entry newMap.entrySet(); // Set<Map.Entry<String, String>> 可以写成var


    }
}
