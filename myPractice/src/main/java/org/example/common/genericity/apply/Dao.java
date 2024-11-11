package org.example.common.genericity.apply;

import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/10 21:46:15
 * @Version: 1.0.0
 */
interface Dao<T> {
    // 增
    abstract void add(T t);


    // 删
    abstract void delete(String id);


    // 改
    abstract void update(T t);


    // 查
    abstract T query(String id);
    abstract List<T> query4List(String id);
}
