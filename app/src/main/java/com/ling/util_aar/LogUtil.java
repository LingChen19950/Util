package com.ling.util_aar;

import android.util.Log;

/**
 * 常用日志工具类
 */
public class LogUtil {

    private static final String TAG = "LingChen";

    public static void d(String string) {
        Log.d(TAG, " " + string);
    }

    public static void i(String string) {
        Log.i(TAG, " " + string);
    }

    public static void v(String string) {
        Log.v(TAG, " " + string);
    }

    public static void e(String string) {
        Log.e(TAG, " " + string);
    }

    public static void w(String string) {
        Log.w(TAG, " " + string);
    }

    public static void d(String TAG, String string) {
        Log.d(TAG, TAG + " " + string);
    }

    public static void i(String TAG, String string) {
        Log.i(TAG, TAG + " " + string);
    }

    public static void v(String TAG, String string) {
        Log.v(TAG, TAG + " " + string);
    }

    public static void e(String TAG, String string) {
        Log.e(TAG, TAG + " " + string);
    }

    public static void w(String TAG, String string) {
        Log.w(TAG, TAG + " " + string);
    }
}
