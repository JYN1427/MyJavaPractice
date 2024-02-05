package org.example.common.genericity.apply;

import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/10 22:01:47
 * @Version: 1.0.0
 */
public class CustomerDao implements Dao<Customer>{
    @Override
    public void add(Customer customer) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public Customer query(String id) {
        return null;
    }

    @Override
    public List<Customer> query4List(String id) {
        return null;
    }
}
