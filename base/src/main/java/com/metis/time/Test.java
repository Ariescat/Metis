package com.metis.time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author Ariescat
 * @version 2020/3/18 14:43
 */
public class Test {

    public static void main(String[] args) {
        System.err.println(Instant.now());
        System.err.println(LocalDateTime.now());
        System.err.println("------------------------");

        // 获得1970-01-01T00:00:00Z.到现在的毫秒数
        System.err.println(Instant.now().toEpochMilli());
        System.err.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.err.println(System.currentTimeMillis());
        System.err.println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli()); // UTC
        System.err.println("------------------------");

        /**
         * 原来我们用的时间戳一直是UTC时间戳 !!!
         *
         * @see System#currentTimeMillis() 这里注释明确说明了 January 1, 1970 UTC !!!
         */
        int oneDay = 24 * 60 * 60 * 1000;
        int oneHour = 60 * 60 * 1000;
        int oneMinute = 60 * 1000;
        System.err.println(Instant.now().toEpochMilli() % oneDay);
        System.err.println(Instant.now().toEpochMilli() % oneDay / oneHour); // 小时
        System.err.println(Instant.now().toEpochMilli() % oneDay % oneHour / oneMinute); // 分钟

        System.err.println(System.currentTimeMillis() % oneDay);
        System.err.println(System.currentTimeMillis() % oneDay / oneHour); // 小时
        System.err.println(System.currentTimeMillis() % oneDay % oneHour / oneMinute); // 分钟

        System.err.println("------------------------");
        System.err.println(new Date(System.currentTimeMillis()));
    }
}
