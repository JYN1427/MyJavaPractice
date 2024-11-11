package org.example.common.Date_.dateutil;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-22 16:16:04
 */
public class test {

    public static final int beginYear = 2019;

    public static final List<String> YEAR_LIST = Stream.iterate(0, i -> i + 1)
            .limit(DateUtil.year(DateUtil.date()) - beginYear + 1)
            .map(i -> String.valueOf(beginYear + i))
            .collect(Collectors.toList());

    @Test
    public void dateTest(){
//        Date day = DateUtil.beginOfDay(DateUtil.date());
//        System.out.println(day.toString());
//
//        System.out.println(DateUtil.year(new Date()));

        YEAR_LIST.forEach(System.out::println);
    }

    @Test
    public void StringPlusTest(){
        BigDecimal a = new BigDecimal("123.1223");
        System.out.println(a.toString());
    }
}
