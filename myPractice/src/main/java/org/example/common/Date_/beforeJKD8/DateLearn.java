package org.example.common.Date_.beforeJKD8;

import org.junit.Test;

import java.util.Date;

// Date的方法基本上都不用了
public class DateLearn {
    public static void main(String[] args) {


    }

    // java.util.Date
    @Test
    public void testDate() {
        Date date1 = new Date();
        System.out.println(date1);

        long milTime = date1.getTime();
        System.out.println(milTime); // 1686110397255L
    }

    // java.sql.Date date （是java.util.Date的子类）
    @Test
    public void testSQLDate() {
        java.sql.Date date = new java.sql.Date(1686110397255L);
        System.out.println(date.toString());
        System.out.println(date.getTime());
    }

    // 两者互转
    @Test
    public void testTrans() {
        Date date = new Date();

        // 多态下 父类转子类不能直接强转
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        // 子类转父类可以
        Date date2 = (Date) sqlDate;
    }

}
