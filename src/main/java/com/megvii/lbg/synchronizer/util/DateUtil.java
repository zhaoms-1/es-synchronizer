package com.megvii.lbg.synchronizer.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 这里添加类的注释【强制】
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-05-11 13:47
 */
public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;


    public static String iso_format(LocalDateTime dateTime) {
        return dateTime.format(ISO_FORMATTER);
    }

    public static LocalDateTime iso_format(String dateTime) {
        return LocalDateTime.parse(dateTime, ISO_FORMATTER);
    }
}
