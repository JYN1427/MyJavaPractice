package org.example.common.Date_.afterJDK8;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

// LocalDate、LocalTime、LocalDateTime 三种
// now()方法 当前时间
// of() 指定时间
// 各种get.../plus.../minus.../with...
public class LocalDateTimeLearn {
    public static void main(String[] args) {

    }

    @Test
    public void testLocalDate() {

    }

    @Test
    public void testLocalTime() {

    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 6, 7, 21, 0, 0);
        System.out.println(localDateTime1);

        int day = localDateTime1.getDayOfMonth();
        System.out.println(day);
        LocalDateTime localDateTime2 = localDateTime1.minusDays(1);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime2.withDayOfYear(365);
        System.out.println(localDateTime3);
    }

    @Test
    public void test() throws ParseException {
        /*
         * 练习:
         * 获取当前时间，把这个时间设置为你的生日，再获取你的百天(出生后300天)日期。
         * */
        LocalDate localDate = LocalDate.of(1998, 8, 19);
        LocalDate afterDate = localDate.plusDays(300);
        System.out.println(afterDate);

    }
}
