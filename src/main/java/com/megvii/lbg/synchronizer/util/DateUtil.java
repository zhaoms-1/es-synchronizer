package com.megvii.lbg.synchronizer.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
