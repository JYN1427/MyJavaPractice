package org.example.common.Date_.beforeJKD8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarLearn {
    public static void main(String[] args) {
        // 1 获取实例
        // Calendar是一个抽象类, 一般用的话是用getInstance()静态方法返回它的子类GregorianCalendar
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // GregorianCalendar

        // 2 常用方法: get\set\add\getTime\setTime
        // get好多的静态字段, 比如这月的第几天.....
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        // set
        calendar.set(Calendar.HOUR_OF_DAY, 10);

        // add
        calendar.add(Calendar.DAY_OF_MONTH, -1);

        // getTime
        Date date = calendar.getTime();

        // setTime
        calendar.setTime(date);
    }

    @Test
    public void test() throws ParseException {
        /*
        * 练习:
        * 使用Calendar获取当前时间，把这个时间设置为你的生日，再获取你的百天(出生后300天)日期。
        * */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ss");
        Date myBirthDay = simpleDateFormat.parse("1998-08-19");
        System.out.println("myBirthDay: " + myBirthDay);

        Calendar instance = Calendar.getInstance();
        instance.setTime(myBirthDay);
        instance.add(Calendar.DAY_OF_YEAR, 300);
        Date afterDate = instance.getTime();
        System.out.println("afterDate: " + afterDate);
    }
}
