package org.example.common.Abstuct_;

public class Square extends Shape{
    public Square(int width, int height) {
        super(width, height);
    }

    @Override
    public double area() {
        double res = this.width * this.height;
        return res;
    }
}
