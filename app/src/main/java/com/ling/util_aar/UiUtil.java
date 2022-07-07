package com.ling.util_aar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;


/**
 * 常用UI工具类
 */
public class UiUtil {

    /**
     * 设置状态栏为透明，状态栏文字颜色默认黑色
     *
     * @param activity 活动
     */
    public static void setTranslucentStatus(Activity activity) {
        setTranslucentStatus(activity, true);
    }

    /**
     * 设置状态栏为透明
     *
     * @param activity 活动
     * @param isDark 图标和字体是：true黑色,false白色
     */
    public static void setTranslucentStatus(Activity activity, boolean isDark) {
        if (null == activity) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            // AppCompatActivity多加一步，隐藏ActionBar
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            if (null != appCompatActivity.getSupportActionBar()) {
                appCompatActivity.getSupportActionBar().hide();
            }
        }
        Window window = activity.getWindow();
        // 先清掉Flag
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 表明 Window 负责系统 bar 的 background 绘制，绘制透明背景的系统 bar（状态栏和导航栏）
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // 让应用占据状态栏位置
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        // 透明
        window.setStatusBarColor(Color.TRANSPARENT);

        if (isDark) {
            // 设置状态栏文字图标颜色为黑色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            // 设置状态栏文字图标颜色为默认白色
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

    /**
     * 修改状态栏背景颜色，支持4.4以上版本
     *
     * @param activity 活动
     * @param colorId 色值ID，例如 R.color.black
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        if (null == activity) {
            return;
        }
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(colorId));
    }

}
