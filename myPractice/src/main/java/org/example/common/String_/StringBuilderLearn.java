package org.example.common.String_;

public class StringBuilderLearn {
    public static void main(String[] args) {
        basicUse();
    }


    public static void basicUse() {
        StringBuilder s = new StringBuilder("pp");

        // 1 append
        s.append("11").append("22").append("33");
        System.out.println(s);

        // 2 insert
        s.insert(2, "java");
        System.out.println(s);

        // 3 delete
        s.delete(2, 6);
        System.out.println(s);

        // 4 reverse
        s.reverse();
        System.out.println(s);
    }



}
