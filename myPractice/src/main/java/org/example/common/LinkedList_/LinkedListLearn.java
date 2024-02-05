package org.example.common.LinkedList_;

import java.util.LinkedList;

public class LinkedListLearn {
    public static void main(String[] args) {
        LinkedList<String> pList = new LinkedList<>();
        String p1 = new String("螺丝");
        String p2 = new String("螺母");
        String p3 = new String("改锥");
        pList.add(p1);
        pList.addFirst(p2);
        pList.addLast(p3);
        System.out.println(pList);

        /*
            E getFirst()	返回此集合的第一个元素
            E getLast() 	返回此集合的最后一个元素
            E removeFirst()	删除此集合中的第一个元素
            E removeLast()	删除此集合中的最后一个元素
        */
    }
}
