package org.example.common.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tset {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("1", "one");
        myMap.put("2", "t");
        myMap.put("3", "s");

        List<String> list = new ArrayList<>(myMap.keySet());
        list.forEach(System.out::println);
    }

}
