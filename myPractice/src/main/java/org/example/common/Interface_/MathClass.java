package org.example.common.Interface_;

// 接口也弥补了单继承的局限性
public class MathClass implements IMathSon{
    private int n1;
    private int n2;

    public MathClass(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public int sum() {
        return n1 + n2 + (int)pi;
    }

    @Override
    public int maxNum(int a, int b) {
        return Math.max(a, b);
    }

    @Override
    public void cal() {
    }
}
