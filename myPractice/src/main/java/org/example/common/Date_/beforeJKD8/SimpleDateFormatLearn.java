package org.example.common.Date_.beforeJKD8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// SimpleDateFormat还挺常用的。格式化/解析
public class SimpleDateFormatLearn {
    public static void main(String[] args) {

    }

    @Test
    // 默认格式
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String s1 = sdf.format(date); // 格式化得到String
        System.out.println(s1);

        Date afterParseDate = sdf.parse("23-6-7 下午12:11");
        System.out.println(afterParseDate);
    }

    @Test
    // 指定格式
    public void test1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(new Date());
        System.out.println(dateString);

        Date afterParseDate = sdf.parse("2023-06-07 16:26:53");
        System.out.println(afterParseDate);
    }
}
