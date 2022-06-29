package com.ling.util_aar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常用时间工具类
 */
public class TimeUtil {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间戳
     */
    public static Long getCurLongTime() {
        return System.currentTimeMillis();
    }

    /**
     * 按照时间格式返回当前时间
     *
     * @param format 时间格式
     * @return 按照时间格式返回当前时间
     */
    public static String getDataTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 时间戳转换成时间
     *
     * @param time 时间
     * @return 时间戳转换成时间
     */
    public static String getDataTime(Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        return simpleDateFormat.format(time);
    }

    /**
     * 按照时间格式转换时间戳
     *
     * @param format 时间格式
     * @return 按照时间格式返回当前时间
     */
    public static String getDataTime(String format, Long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(time);
    }

    /**
     * date类型进行格式化输出（返回类型：String）
     * @param date 时间
     * @return 转换成时间
     */
    public static String getDataTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return simpleDateFormat.format(date);
    }

    /**
     * 判断当前日期是否在[startDate, endDate]区间
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return true在有效期中，false不在有效期中
     */
    public static boolean isEffectiveDate(Date startDate, Date endDate){
        if(startDate == null || endDate == null){
            return false;
        }
        long currentTime = getCurLongTime();
        return currentTime >= startDate.getTime() && currentTime <= endDate.getTime();
    }

}
