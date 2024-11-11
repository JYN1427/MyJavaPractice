package org.example.common.Abstuct_;

public abstract class Shape {
    public int width;
    public int height;

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 抽象方法没有方法体！
    // （方法别忘了写返回值类型）
    public abstract double area();
}
