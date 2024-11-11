package org.example.common.genericity;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/07 18:54:41
 * @Version: 1.0.0
 */
public class Order<T> {
    // 你得用上这个T, 干嘛用的呢? 就是实例化一个t
    private T t;  // 注意静态方法中不可使用泛型
    private String OrderNumber;

    public Order() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", OrderNumber='" + OrderNumber + '\'' +
                '}';
    }
}
