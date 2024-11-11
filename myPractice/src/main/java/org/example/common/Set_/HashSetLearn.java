package org.example.common.Set_;

import java.util.*;

public class HashSetLearn {
    public static void main(String[] args) {
        // 1. HashSet
        Set<String> seen = new HashSet<>();
        String s1 = new String("one");
        String s2 = new String("two");
        seen.add(s1);
        seen.add(s2);
        Iterator<String> it = seen.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(seen.contains("one"));


        // 2. TreeSet
        // TreeSet 类同时实现了 Set 接口和 SortedSet 接口。SortedSet 接口是 Set 接口的子接口，可以实现对集合进行自然排序
        TreeSet<Double> scores = new TreeSet<>();
        Double score1 = new Double(100.0);
        Double score2 = new Double(80.0);
        Double score3 = new Double(40.5);
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);

        System.out.println("輸入搜索的成績：");
        Scanner input = new Scanner(System.in);
        double searchScore = input.nextDouble();
        if (scores.contains(searchScore)) {
            System.out.println("成绩为"+searchScore+"的学生存在");
        } else {
            System.out.println("成绩为"+searchScore+"的学生不存在");
        }

        /*
        SortedSet<E> headSet<E toElement〉	返回一个新的集合，新集合包含原集合中 toElement 对象之前的所有对象。不包含 toElement 对象
        SortedSet<E> tailSet(E fromElement)	返回一个新的集合，新集合包含原集合中 fromElement 对象之后的所有对象。包含 fromElement 对象
        */

        // 不及格的
        Double s60 = new Double(60.0);
        SortedSet<Double> nogood = scores.headSet(s60);
        System.out.println("不及格成绩：");
        for(int i=0; i < nogood.toArray().length; i++){
            System.out.println(nogood.toArray()[i]);
        }

        SortedSet<Double> yesgood = scores.tailSet(s60);
        System.out.println("及格成绩：");
        for(int i=0; i < yesgood.toArray().length; i++){
            System.out.println(yesgood.toArray()[i]);
        }

    }
}
