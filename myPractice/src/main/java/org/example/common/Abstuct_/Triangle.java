package org.example.common.Abstuct_;

public class Triangle extends Shape{
    public Triangle(int width, int height) {
        super(width, height);
    }

    @Override
    public double area() {
        return 0.5 * this.height * this.width;
    }
}
