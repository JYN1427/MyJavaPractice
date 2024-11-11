package org.example.common.Date_.dateutil;

import cn.hutool.core.date.DateUtil;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-27 14:23:11
 */
public class timestamp {
    public static void main(String[] args) {
        test();
    }

    /**
     * 获取时间戳形式
     */
    public static void test() {
        long time = DateUtil.date().getTime();
        System.out.println(time);
    }
}
