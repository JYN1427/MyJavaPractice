package org.example.common.Date_.afterJDK8;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

// Instant瞬时时间: 比如短时间内大量高并发生成订单号, 时间只到毫秒级肯定区分不开
public class InstantLearn {
    public static void main(String[] args) {
        // 静态now创建当前
        Instant instant = Instant.now();
        System.out.println(instant); // 中时区

        // atOffset加偏移
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 加个东八区的偏移量

        // 静态of解析Long数字
        Instant instant1 = Instant.ofEpochMilli(2412312312L);
        System.out.println(instant1);

        // to转换为Long数字
        Long myTime = instant.toEpochMilli();
        System.out.println(myTime);
    }
}
