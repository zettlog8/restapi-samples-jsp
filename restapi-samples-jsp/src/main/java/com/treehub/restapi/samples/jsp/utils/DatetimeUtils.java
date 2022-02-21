package com.treehub.restapi.samples.jsp.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DatetimeUtils {
    public static String getNow() {
        return getNow(null);
    }
    
    public static String getNow(String pattern) {
        pattern = StringUtils.defaultString(pattern, "yyyyMMddHHmmssSSSSSS");
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter();
        return now().format(formatter);
    }
    
    public static Timestamp getTimestampNow() {
        return Timestamp.valueOf(now());
    }
    
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
    
    public static String convDateFormat(Date sDate, String pattern) {
        pattern = StringUtils.defaultString(pattern, "yyyy/MM/dd");
        SimpleDateFormat transFormat = new SimpleDateFormat(pattern);
        return transFormat.format(sDate);
    }
    
    public static Date convStringToDate(String sDate, String pattern) {
        pattern = StringUtils.defaultString(pattern, "yyyy/MM/dd");
        SimpleDateFormat transFormat = new SimpleDateFormat(pattern);
        Date result = null;
        try {
            result = transFormat.parse(sDate);
        } catch(Exception e) {
            
        }
        return result;
    }
    
    public static boolean checkDuplication(Date targetDate, int checkTerm, int addType ) {
        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(addType,checkTerm);
        Date minusTenMinsFromNow = currentTimeNow.getTime();
    
        return !(DateUtils.truncatedCompareTo(targetDate, minusTenMinsFromNow, Calendar.MILLISECOND) < 0);
    }
}