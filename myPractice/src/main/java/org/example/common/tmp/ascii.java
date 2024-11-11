package org.example.common.tmp;

public class ascii {
    public static void main(String[] args) {
        int a_num = 97;
        char a_char = 'a';

        System.out.println(a_num);              // 97
        System.out.println(a_char+1);           // 98
        System.out.println((char)a_num);        // 'a'
        System.out.println((char)(a_char+1));   // 'b'
    }
}
