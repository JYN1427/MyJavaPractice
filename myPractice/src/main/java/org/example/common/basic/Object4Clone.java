package org.example.common.basic;

// Object.clone()的测试类
public class Object4Clone implements Cloneable{
    private int num;
    public Object4Clone(int num) {
        this.num = num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
