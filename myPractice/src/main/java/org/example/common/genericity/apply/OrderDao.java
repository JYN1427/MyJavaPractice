package org.example.common.genericity.apply;


import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/10 22:03:35
 * @Version: 1.0.0
 */
public class OrderDao implements Dao<Order>{

    @Override
    public void add(Order order) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public Order query(String id) {
        return null;
    }

    @Override
    public List<Order> query4List(String id) {
        return null;
    }
}
