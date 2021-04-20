package com.study.core.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:51
 * @Description
 */
public class DateUtil {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_SECOND_FORMAT = "yyyyMMddHHmmss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_FORMAT_2 = "HH:mm";

    public static final String MODE_DAY = "day";

    /**
     * 采用 ThreadLocal 避免 SimpleDateFormat 非线程安全的问题
     *
     * <p>Key —— 时间格式 Value —— 解析特定时间格式的 SimpleDateFormat
     */
    private static ThreadLocal<ConcurrentHashMap<String, SimpleDateFormat>>
            simpleDateFormatThreadLocal = new ThreadLocal<>();

    /**
     * 获取解析特定时间格式的 SimpleDateFormat
     *
     * @param pattern 时间格式
     */
    private static SimpleDateFormat getDateFormat(String pattern) {
        ConcurrentHashMap<String, SimpleDateFormat> strDateFormatMap =
                simpleDateFormatThreadLocal.get();
        if (strDateFormatMap == null) {
            strDateFormatMap = new ConcurrentHashMap<>();
        }
        SimpleDateFormat simpleDateFormat = strDateFormatMap.get(pattern);
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(pattern);
            strDateFormatMap.put(pattern, simpleDateFormat);
            simpleDateFormatThreadLocal.set(strDateFormatMap);
        }
        return simpleDateFormat;
    }

    /**
     * 时间格式化
     *
     * @param date：要格式化的时间
     * @param pattern：要格式化的类型
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }

        return getDateFormat(pattern).format(date);
    }

    public static String[] getBeginAndEndTime(Date date, String mode) {
        //        SimpleDateFormat format = getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = getDateFormat(mode);
        Date[] dates = getBeginAndEndDate(date, mode);

        return new String[] {format.format(dates[0]), format.format(dates[1])};
    }

    public static Date[] getBeginAndEndDate(Date date, String mode) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date begin = new Date();
        Date end = new Date();

        if (mode == null || mode.equalsIgnoreCase("日") || mode.equalsIgnoreCase(MODE_DAY)) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            begin = calendar.getTime();
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            end = calendar.getTime();
        } else if (mode.equalsIgnoreCase("周") || mode.equalsIgnoreCase("week")) {
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Monday
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            begin = calendar.getTime();
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            end = calendar.getTime();
        } else if (mode.equalsIgnoreCase("月")
                || mode.equalsIgnoreCase("month")
                || mode.equalsIgnoreCase("0")) {
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            begin = calendar.getTime();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            end = calendar.getTime();
        } else if (mode.equalsIgnoreCase("季") || mode.equalsIgnoreCase("season")) {
            int month = calendar.get(Calendar.MONTH) + 1;
            if (month % 3 == 0) { // 季度结束月 (3,6,9)
                calendar.set(Calendar.MONTH, month - 3);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                begin = calendar.getTime();
                calendar.set(Calendar.MONTH, month - 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                end = calendar.getTime();
            } else if (month % 3 == 1) { // 季度起始月 (1,4,7)
                calendar.set(Calendar.MONTH, month - 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                begin = calendar.getTime();
                calendar.set(Calendar.MONTH, month + 1);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                end = calendar.getTime();
            } else if (month % 3 == 2) { // 季度中间月 (2,5,8)
                calendar.set(Calendar.MONTH, month - 2);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                begin = calendar.getTime();
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                end = calendar.getTime();
            }
        } else if (mode.equalsIgnoreCase("半年") || mode.equalsIgnoreCase("halfyear")) {
            int month = calendar.get(Calendar.MONTH) + 1;
            if (month < 6) {
                // 上半年
                calendar.set(Calendar.MONTH, 0);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                begin = calendar.getTime();
                calendar.set(Calendar.MONTH, 4);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                end = calendar.getTime();
            } else {
                // 下半年
                calendar.set(Calendar.MONTH, 5);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                begin = calendar.getTime();
                calendar.set(Calendar.MONTH, 11);
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                calendar.set(Calendar.HOUR_OF_DAY, 23);
                calendar.set(Calendar.MINUTE, 59);
                calendar.set(Calendar.SECOND, 59);
                calendar.set(Calendar.MILLISECOND, 999);
                end = calendar.getTime();
            }
            end = calendar.getTime();
        } else if (mode.equalsIgnoreCase("年") || mode.equalsIgnoreCase("year")) {
            calendar.set(Calendar.DAY_OF_YEAR, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            begin = calendar.getTime();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            end = calendar.getTime();
        }

        return new Date[] {begin, end};
    }

    /**
     * 获取一天的开始时间
     *
     * @param oriDate 日期
     * @return
     */
    public static Date getDayBegin(Date oriDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(oriDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取今日开始时间
     *
     * @return
     */
    public static Date getDayBegin() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 日期增加或减少几小时
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addHour(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.HOUR_OF_DAY, amount);
        return cal.getTime();
    }

    /**
     * 日期增加或减少几秒钟
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addSeconds(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.SECOND, amount);
        return cal.getTime();
    }

    /**
     * 日期增加或减少几分钟
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addMinute(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    /**
     * 设置秒数
     *
     * @param oriDate
     * @param amount
     * @return
     */
    public static Date setSecond(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.set(Calendar.SECOND, amount);
        return cal.getTime();
    }

    /**
     * 日期增加或减少几天
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addDay(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();
    }

    /**
     * 日期增加或减少几月
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addMonth(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }

    /**
     * 日期增加或减少几年
     *
     * @param oriDate 日期
     * @param amount 数量
     * @return
     */
    public static Date addYear(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }

    /**
     * 格式化成24小时制的形式
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        //        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df = getDateFormat(DATE_TIME_FORMAT);
        return df.format(date);
    }

    /**
     * 格式化成指定的形式
     *
     * @param date 日期
     * @param pattern 日期格式化规则
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        //        SimpleDateFormat df = new SimpleDateFormat(pattern);
        SimpleDateFormat df = getDateFormat(pattern);
        return df.format(date);
    }

    /**
     * String转换date
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date, String pattern) throws ParseException {
        //        SimpleDateFormat df = new SimpleDateFormat(pattern);
        SimpleDateFormat df = getDateFormat(pattern);
        return df.parse(date);
    }

    /**
     * 日期大小比较
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            throw new RuntimeException("两个日期型都为null，不能比较");
        } else if (date1 == null) {
            return -1;
        } else if (date2 == null) {
            return 1;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        return calendar1.compareTo(calendar2);
    }

    /**
     * 时间大小比较
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compare(Date date1, Date date2) {
        if (date1 == null && date2 == null) {
            throw new RuntimeException("两个日期型都为null，不能比较");
        } else if (date1 == null) {
            return -1;
        } else if (date2 == null) {
            return 1;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.compareTo(calendar2);
    }

    /**
     * 两个日期相减，返回两个时间的差值(小时为单位)，保留两位小数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static double subHh(Date date1, Date date2) {
        long mill = Math.abs(date1.getTime() - date2.getTime());
        //        double ss=(mill)/(1000); //共计秒数
        //        int MM = (int)ss/60; //共计分钟数
        //        int hh=(int)ss/3600; //共计小时数
        //        int dd=(int)hh/24; //共计天数
        return (double) (Math.round((double) mill / (1000 * 60 * 60) * 100) / 100.0);
    }

    /**
     * 两个日期相减，返回两个时间的差值(小时为单位)，保留1位小数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static double subHh1(Date date1, Date date2) {
        long mill = Math.abs(date1.getTime() - date2.getTime());
        //        double ss=(mill)/(1000); //共计秒数
        //        int MM = (int)ss/60; //共计分钟数
        //        int hh=(int)ss/3600; //共计小时数
        //        int dd=(int)hh/24; //共计天数
        return (double) (Math.round((double) mill / (1000 * 60 * 60) * 10) / 10.0);
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long subDay(Date date1, Date date2) {
        long betweenDays = (date2.getTime() - date1.getTime()) / (1000L * 3600L * 24L);
        return betweenDays;
    }

    /**
     * 获取两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static long subDay(String date1, String date2, String format) {
        //        SimpleDateFormat sdf = new SimpleDateFormat(format);
        SimpleDateFormat sdf = getDateFormat(format);
        try {
            Date _date1 = sdf.parse(date1);
            Date _date2 = sdf.parse(date2);
            long betweenDays = (_date1.getTime() - _date2.getTime()) / (1000L * 3600L * 24L);
            return betweenDays;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取相同日期的两个时间相差的分钟
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int subMinute(Date date1, Date date2) {
        return Math.round((date1.getTime() - date2.getTime()) / 1000 / 60);
    }

    /**
     * 获取相同日期的两个时间相差的秒钟
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int subSecond(Date date1, Date date2) {
        return Math.round((date1.getTime() - date2.getTime()) / 1000);
    }

    /**
     * 得到date所在分钟
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 得到date所在的小时
     *
     * @param date
     * @return
     */
    public static int getHours(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 得到date所在的天
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 修改
     *
     * @param oriDate
     * @param amount
     * @return
     */
    public static Date setDay(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.set(Calendar.DAY_OF_YEAR, amount);
        return cal.getTime();
    }

    public static Date setHour(Date oriDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(oriDate);
        cal.set(Calendar.HOUR_OF_DAY, amount);
        return cal.getTime();
    }

    /**
     * 得到date所在的月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到date所在的月份
     *
     * @param cal
     * @return
     */
    public static int getMonth(Calendar cal) {
        return cal.get(Calendar.MONTH) + 1;
    }
    /**
     * 得到date所在的年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 根据月份获取月份所在季度，如果为0，表示月份异常（不在1-12范围内）
     *
     * @param month
     * @return
     */
    public static int getQuarter(int month) {
        if (month >= 1 && month <= 3) {
            return 1;
        } else if (month > 3 && month < 7) {
            return 2;
        } else if (month > 6 && month < 10) {
            return 3;
        } else if (month > 9 && month < 13) {
            return 4;
        } else {
            return 0;
        }
    }

    //    /**
    //     * 格式化日期
    //     *
    //     * @param argDate   需要格式化的日期
    //     * @param argFormat 格式
    //     * @return
    //     */
    //    public static String formatDate(Date argDate, String argFormat) {
    //        if (argDate == null) {
    //            return "";
    //        }
    //
    //        SimpleDateFormat sdfFrom = null;
    //        // 结果
    //        String strResult = null;
    //
    //        try {
    //            sdfFrom = new SimpleDateFormat(argFormat);
    //            strResult = sdfFrom.format(argDate).toString();
    //        } catch (Exception e) {
    //            strResult = "";
    //        } finally {
    //            sdfFrom = null;
    //        }
    //
    //        // 返回格式化后的结果
    //        return strResult;
    //    }

    /**
     * 判断日期是周几
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.DAY_OF_WEEK) - 1;
        return i == 0 ? 7 : i;
    }

    public static int getDayOfWeek(Calendar c) {
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }


    /**
     * 把时间段转成具体日期的时段
     *
     * @param date
     * @param time
     * @return
     */
    public static Date tranformTimeToDate(Date date, Time time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        Integer minute = calendar.get(Calendar.MINUTE);
        Integer second = calendar.get(Calendar.SECOND);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * @description: 获取当前时间
     * @param: []
     * @return: java.util.Calendar
     * @author: JiangWangfa
     * @date: 2018/9/10 13:16
     */
    public static Calendar getCurrentDate() {
        TimeZone curTimeZone = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar;
    }

    public static Calendar str2Calendar(String str) throws ParseException {
        Date date = parseDate(str, DATE_TIME_FORMAT);
        Calendar currentDate = getCurrentDate();
        currentDate.setTime(date);
        return currentDate;
    }

    /**
     * @description: 时间取整（round分钟区间）
     * @param: [time, round]
     * @return: java.lang.String
     * @author: JWF
     * @date: 2019-6-7 13:46
     */
    public static String roundTime(String time, int round) {
        if (time == null) {
            return time;
        }

        Date date = null;
        try {
            date = parseDate(time, DATE_TIME_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return roundTime(date, round);
    }

    public static String roundTime(Date time, int round) {
        if (time == null) {
            return format(time);
        }

        Calendar cal = getCurrentDate();
        cal.setTime(time);

        cal.set(Calendar.SECOND, 0);
        int minute = cal.get(Calendar.MINUTE);
        int y = minute % round;
        if (y == 0) {
            return format(cal.getTime());
        }
        int add;
        int multiple = 2;
        if (y > (round / multiple)) {
            add = round - y;
        } else {
            add = -y;
        }

        cal.add(Calendar.MINUTE, add);
        return format(cal.getTime());
    }

    public static Date roundDate(Date time, int round) {
        if (time == null) {
            return time;
        }

        Calendar cal = getCurrentDate();
        cal.setTime(time);

        cal.set(Calendar.SECOND, 0);
        int minute = cal.get(Calendar.MINUTE);
        int y = minute % round;
        if (y == 0) {
            return cal.getTime();
        }
        int add;
        int multiple = 2;
        if (y > (round / multiple)) {
            add = round - y;
        } else {
            add = -y;
        }

        cal.add(Calendar.MINUTE, add);
        return cal.getTime();
    }

    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return isWeekend(calendar);
    }

    public static boolean isWeekday(Date date) {
        return ! isWeekend(date);
    }

    public static boolean isWeekend(Calendar calendar) {
        // Calendar.get返回的第一个是周日，然后是周一，因此这里要特殊处理一下周日的情况
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        // 周六或周日是周末
        return dayOfWeek == 6 || dayOfWeek == 7;
    }
}
