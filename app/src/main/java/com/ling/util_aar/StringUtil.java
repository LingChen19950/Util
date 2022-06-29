package com.ling.util_aar;

/**
 * 常用字符串工具类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param string 需要判断的字符串
     * @return 字符串是否为空
     */
    public static boolean isEmpty(String string) {
        if (null == string) {
            return true;
        }
        return string.isEmpty();
    }

    /**
     * 判断字符串是否为空
     *
     * @param string 需要判断的字符串
     * @param isTrim 是否需要去掉空格判断
     * @return 字符串是否为空
     */
    public static boolean isEmpty(String string, boolean isTrim) {
        if (null == string) {
            return true;
        }
        if (isTrim) {
            return string.trim().isEmpty();
        }
        return string.isEmpty();
    }

    /**
     * String转long
     *
     * @param string 字符串
     * @return 转换异常返回 -1
     */
    public static long toLong(String string) {
        if (isEmpty(string)) {
            return -1L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            LogUtil.e("toLong NumberFormatException");
        }
        return -1L;
    }

    /**
     * String转double
     *
     * @param string 字符串
     * @return 转换异常返回 -1
     */
    public static double toDouble(String string) {
        if (isEmpty(string)) {
            return -1D;
        }
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            LogUtil.e("toDouble NumberFormatException");
        }
        return -1D;
    }

    /**
     * 字符串转布尔
     *
     * @param string 字符串
     * @return 转换异常返回 false
     */
    public static boolean toBoolean(String string) {
        if (isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    /**
     * String转int
     *
     * @param string 字符串
     * @return 转换异常返回 -1
     */
    public static int toNumber(String string) {
        if (isEmpty(string)) {
            return -1;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            LogUtil.e("toNumber NumberFormatException");
        }
        return -1;
    }


}
