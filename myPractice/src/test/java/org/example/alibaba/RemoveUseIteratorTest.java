package org.example.alibaba;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 再循环中删除集合的元素
 *
 * @author jiayn01
 * @date 2023-09-11 13:16:06
 */
public class RemoveUseIteratorTest {

    public List<String> list = new ArrayList<>();

    @BeforeEach
    void init() {
        System.out.println("初始化");
        Stream.iterate(0, i->i+1)
                .limit(5)
                .forEach(item -> list.add(String.valueOf(item)));
    }

    /**
     * 方式1 转换为iterator
     */
    @Test
    void test1() {
        Iterator<String> stringIterator = list.iterator();
        while (stringIterator.hasNext()) {
            String item = stringIterator.next();
            if (item.equals("0")) {
                stringIterator.remove();
            }
        }
        System.out.println(list.toString());
    }

    /**
     * 方式2
     */
    @Test
    public void test2() {
        list.removeIf(item -> item.equals("0"));
        System.out.println(list.toString());
    }

}
