package org.example.common.String_;

public class ASCII {
    public static void main(String[] args) {
        // 字符相减为ascii相减
        char A = 'A';
        char B = 'B';
        System.out.println(B-A); // 1

        // tmp.ascii -> char
        int num = 97;
        char a = (char)num;
        System.out.println(a); // a

        // char -> tmp.ascii
        char C = 'C';
        int num2 = (int)C;
        System.out.println(num2); // 67


        // tmp.ascii -> String
        String myChar = Character.toString((char)97);
        System.out.println(myChar); // a



    }
}
