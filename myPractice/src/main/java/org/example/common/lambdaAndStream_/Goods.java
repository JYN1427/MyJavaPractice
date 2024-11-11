package org.example.common.lambdaAndStream_;

public class Goods {
    public String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    // set不返回东西，所以记得要加void
    public void setPrice(double price) {
        this.price = price;
    }
}
