package com.example.springdemo.uuid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-09 14:13:36
 */
public class UUIDUtil {

    /**
     *
     *
     * @return
     */
    public static String randomUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "").toLowerCase();
    }


    /**
     * 生成32位随机数
     *
     * @return
     */
    public static String getNewGuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    /**
     * 根据日期和ThreadLocalRandom.nextInt 生成序列号
     *
     * @return
     */
    public static String generateReqSeq(long timeMillis) {
        Date date  = new Date(timeMillis);
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date) + "_" + tlr.nextInt(1, 1000);
    }
}
