package conm.zhuazhu.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tao on 2016/12/20.
 * 日期工具类
 */

public class DateUtils {
    /**
     * 获取两个日期之间相差的天数
     * @param time1
     * @param time2
     * @return
     */
    public static int gapDays(long time1,long time2){
        int day = (int) ((time1-time2)/(1000 * 60 * 60 * 24));
        return Math.abs(day);
    }
    /**
     * 获取两个日期之间相差的天数
     * @param calendar
     * @param date
     * @return
     */
    public static int gapDays(Calendar calendar,Date date){
        return gapDays(date,calendar);
    }
    /**
     * 获取两个日期之间相差的天数
     * @param date
     * @param calendar
     * @return
     */
    public static int gapDays(Date date,Calendar calendar){
        return gapDays(calendar.getTime() , date);
    }
    /**
     * 获取两个日期之间相差的天数
     * @param calendar1
     * @param calendar2
     * @return
     */
    public static int gapDays(Calendar calendar1,Calendar calendar2){
        return gapDays(calendar1.getTime(),calendar2.getTime());
    }
    /**
     * 获取两个日期之间相差的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int gapDays(Date date1,Date date2){
        return gapDays(date1.getTime(),date2.getTime());
    }
    /**
     * 当前日期加几年或者减几年
     * @param date
     * @param year 加或者减的年数
     * @return
     */
    public static Date calculateYear(Date date,int year){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calculateYear(calendar,year);
    }
    /**
     * 当前日期加几年或者减几年
     * @param calendar
     * @param year 加或者减的年数
     * @return
     */
    public static Date calculateYear(Calendar calendar,int year){
        Calendar cl = calendar;
        cl.add(Calendar.YEAR,year);
        return cl.getTime();
    }
    /**
     * 当前日期加几月或者减几月
     * @param date
     * @param month 加或者减的月数
     * @return
     */
    public static Date calculateMonth(Date date,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calculateMonth(calendar,month);
    }
    /**
     * 当前日期加几月或者减几月
     * @param calendar
     * @param month 加或者减的月数
     * @return
     */
    public static Date calculateMonth(Calendar calendar,int month){
        Calendar cl = calendar;
        cl.add(Calendar.MONTH,month);
        return cl.getTime();
    }
    /**
     * 当前日期加几天或者减几天
     * @param date
     * @param day 加或者减的天数
     * @return
     */
    public static Date calculateDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calculateDay(calendar,day);
    }
    /**
     * 当前日期加几天或者减几天
     * @param calendar
     * @param day 加或者减的天数
     * @return
     */
    public static Date calculateDay(Calendar calendar,int day){
        Calendar cl = calendar;
        cl.add(Calendar.DATE,day);
        return cl.getTime();
    }

    /**
     * 得到今天是今年的第几天
     * @return
     */
    public static int dayOfYear(){
        return Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
    }
    /**
     * 得到今天是今年的第几周
     * @return
     */
    public static int weekOfYear(){
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }
    /**
     * 得到今天是当月的第几周
     * @return
     */
    public static int weekOfMonth(){
        return Calendar.getInstance().get(Calendar.WEEK_OF_MONTH);
    }
    /**
     * 得到今天是星期几。
     *
     * @return
     */
    public static int dayOfWeek() {
        //当为周日时，返回0，当为周一至周六时，则返回对应的1-6。
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
        if(dayOfWeek==0){
            return 7;
        }
        return dayOfWeek;
    }

    /**
     * 获取今天是几号
     * @return
     */
    public static int day(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取日
     * @param date
     * @return
     */
    public static int day(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }
    /**
     * 获取日
     * @param
     * @return
     */
    public static int day(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.DATE);
    }
    /**
     * 获取日
     * @param calendar
     * @return
     */
    public static int day(Calendar calendar){
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取今天是几月
     * @return
     */
    public static int month(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH)+1;
    }
    /**
     * 获取月
     * @param date
     * @return
     */
    public static int month(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH)+1;
    }
    /**
     * 获取月
     * @param date
     * @return
     */
    public static int month(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.MONTH)+1;
    }
    /**
     * 获取月
     * @param calendar
     * @return
     */
    public static int month(Calendar calendar){
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 获取今天是多少年
     * @return
     */
    public static int year(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获取年
     * @param date
     * @return
     */
    public static int year(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获取年
     * @param date
     * @return
     */
    public static int year(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.YEAR);
    }
    /**
     * 获取年
     * @param calendar
     * @return
     */
    public static int year(Calendar calendar){
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 字符串转换为日期
     * @param date 日期字符串
     * @param pattern 字符串日期格式
     * @return
     */
    public static Date stringToDate(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * 字符串转换为日期
     * @param date 日期字符串
     * @param pattern 字符串日期格式
     * @return
     */
    public static Calendar stringToCalendar(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(df.parse(date));
            return calendar;
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * 日期转换为字符串
     * @param date 日期
     * @param pattern 字符串日期格式
     * @return
     */
    public static String string(Date date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    /**
     * 日期字符串从一种格式转换为另一种格式
     * @param date 日期
     * @param pattern_old 当前字符串的日期格式
     * @param pattern_new 转换之后的日期格式
     * @return
     */
    public static String string(String date,String pattern_old,String pattern_new){
        DateFormat df_old = new SimpleDateFormat(pattern_old);
        DateFormat df_new = new SimpleDateFormat(pattern_new);
        try {
            Date d = df_old.parse(date);
            return df_new.format(d);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将长整型日期转化为字符串
     * @param date 长整型日期
     * @param pattern 日期格式
     * @return
     */
    public static String string(long date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date(date));
    }

    /**
     * calendar转日期字符串
     * @param calendar
     * @param pattern 日期格式
     * @return
     */
    public static String string(Calendar calendar,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(calendar.getTime());
    }

    /**
     *  日期字符串转时间毫秒数
     * @param date
     * @param pattern 日期格式
     * @return
     */
    public static long stringToLong(String date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(date).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    /**
     * Date转Calendar
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    /**
     *  日期转时间毫秒数
     * @param calendar 日期
     * @param pattern 日期格式
     * @return
     */
    public static long dateToLong(Calendar calendar,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            String d = df.format(calendar.getTime());
            return df.parse(d).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }
    /**
     *  日期转时间毫秒数
     * @param date 日期
     * @param pattern 日期格式
     * @return
     */
    public static long dateToLong(Date date,String pattern){
        DateFormat df = new SimpleDateFormat(pattern);
        try {
            String d = df.format(date);
            return df.parse(d).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }
    /**
     * 日期转时间毫秒数
     * @param date 日期
     * @return
     */
    public static long dateToLong(Date date){
        return date.getTime();
    }

    /**
     * calendar转时间毫秒数
     * @param calendar
     * @return
     */
    public static long calendarToLong(Calendar calendar){
        return calendar.getTime().getTime();
    }
}
