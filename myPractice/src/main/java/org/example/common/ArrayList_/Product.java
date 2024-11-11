package org.example.common.ArrayList_;

import java.util.Objects;

public class Product implements Comparable{
    // 商品类
    private int id; // 商品编号
    private String name; // 名称
    private float price; // 价格
    public Product(int id, String name, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                '}';
//    }
    @Override
    public String toString() {
    return "商品编号：" + id + "，名称：" + name + "，价格：" + price;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public int compareTo(Object o) {
        // 接口中通过x.compareTo(y)来比较x和y的大小。
        // 若返回负数，意味着x比y小；返回零，意味着x等于y；返回正数，意味着x大于y
        if(o == this) {
            return 0;
        }
        if(o instanceof Product) {
            Product product = ((Product) o);
            int res = Float.compare(price, product.getPrice());
            return res != 0 ? res : name.compareTo(product.getName());
        } else {
            throw new RuntimeException("所比较类型不匹配");
        }

    }
}