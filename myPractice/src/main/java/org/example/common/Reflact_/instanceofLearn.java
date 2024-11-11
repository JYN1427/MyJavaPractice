package org.example.common.Reflact_;

public class instanceofLearn {
    public static void main(String[] args) {
        decide(new Father());
        System.out.println("-------");
        decide(new Son());
    }

    public static void decide(Father x) {
        if (x instanceof Son) {
            System.out.println("instanceof Son");
        }
        if (x instanceof Father) {
            System.out.println("instanceof Father");
        }


        if (x.getClass() == Son.class) {
            System.out.println("==Son.class");
        } else if (x.getClass() == Father.class) {
            System.out.println("==Father.class");
        }
    }
}


class Father{}

class Son extends Father{}