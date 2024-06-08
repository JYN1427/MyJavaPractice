package org.example.common.Date_.dateutil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-05-07 16:51:18
 */
public class PeriodLearn {
    public static void main(String[] args) {
        Date beginDate = DateUtil.parseDate("2018-01-10");
        Date endDate = DateUtil.parseDate("2018-05-01");
        String s = getFormatDayString(beginDate, endDate);
        System.out.println(s);
    }

    private static String getFormatDayString(Date beginDate, Date endDate) {
        StringBuffer sb = new StringBuffer("");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        LocalDate begin = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(endDate);
        LocalDate end = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        Period period = Period.between(begin, end);
        int year = period.getYears();
        int month = period.getMonths();
        int day = period.getDays();
        sb.append(year == 0 ? "" : (year + "年"));
        sb.append(month == 0 ? "" : (month + "月"));
        sb.append(day == 0 ? "0天" : (day + "天"));
        return sb.toString();
    }

//    private static String getBetweenDays(Date beginDate, Date endDate) {
//        Period between = Period.between(beginDate, endDate);
//        return between.getDays() + "";
//    }
}