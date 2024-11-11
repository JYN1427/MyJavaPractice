package org.example.common.exception_.basic;

import java.io.IOException;

// 子类继承父类时throws
public class WhenExtends {
    public static void main(String[] args) {

    }
}

abstract class Father {
    public abstract void method1() throws IOException;

    public abstract void method2() throws RuntimeException;
}

class Son extends Father{
    @Override
    public void method1() throws IOException {

    }

    @Override
    public void method2() throws NullPointerException {
        // 子类抛得异常可以和父类一样、也可以是子异常
    }
}