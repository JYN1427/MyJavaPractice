package org.example.common.Date_.afterJDK8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

// JDK8之前的SimpleDateFormat是针对Date进行格式化和解析的
// JDK8的DateTimeFormatter是针对LocalDate/LocalTime/LocalDateTime进行格式化和解析的
public class DateTimeFormatterLearn {
    /*
     常用:
    * (1) ofPattern(String pattern)静态方法，返回一个指定字符串格式的DateTimeFormatter
    * (2) format(TemporalAccessor t)格式化一个日期、时间，返回字符串
    *      parse和from连用
    * (3) parse(CharSequence text)将指定格式的字符序列解析为一个日期、时间
    * */
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // format
        String s = dateTimeFormatter.format(localDateTime);
        System.out.println(s);

        // parse和from连用
        String time = "2023-06-07 21:58:45";
        TemporalAccessor parse = dateTimeFormatter.parse(time); // TemporalAccessor是接口
        LocalDateTime localDateTime1 = LocalDateTime.from(parse); // from
        System.out.println(localDateTime1);
    }
}
