package com.ling.util_aar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * toastUtil，使用前需先初始化 init(getApplicationContext())
 * 后续使用可不传context，直接显示Toast，解决以下问题
 * 参考 http://t.zoukankan.com/Reverse-xiaoyu-p-11468905.html
 * 1)需要弹出一个新的Toast时，上一个Toast还没有显示完
 * 2)可能重复弹出相同的信息
 * 3)Toast具体有哪些用法不是很熟悉，用到时导出去找
 * 4)app退出去了，Toast还在弹
 */
public class ToastUtil {

    /**
     * 上下文
     * 这里的话，是持有应用的引用，所以应该不会造成内存泄漏
     */
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private static Toast mToast;

    /**
     * 初始化方法
     *
     * @param context 持有应用的引用 getApplicationContext()
     */
    public static void init(Context context) {
        ToastUtil.context = context;
    }

    /**
     * 显示短Toast
     *
     * @param msg 要显示的消息内容(CharSequence接口，表示有序的字符集合，String/BufferString/StringBuilder)
     */
    public static void showShortToast(CharSequence msg) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (null == mToast) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * 显示长Toast
     *
     * @param msg 要显示的消息内容(CharSequence接口，表示有序的字符集合，String/BufferString/StringBuilder)
     */
    public static void showLongToast(CharSequence msg) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (null == mToast) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param msg 要显示的消息内容(CharSequence接口，表示有序的字符集合，String/BufferString/StringBuilder)
     * @param duration 单位:毫秒
     */
    public static void show(CharSequence msg, int duration) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }


    /**
     * 显示短Toast
     *
     * @param resId 资源ID:getResources().getString(R.string.xxxxxx);
     */
    public static void showShortToast(int resId) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (null == mToast) {
            mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }

    /**
     * 显示长Toast
     *
     * @param resId 资源ID:getResources().getString(R.string.xxxxxx);
     */
    public static void showLongToast(int resId) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (null == mToast) {
            mToast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param resId 资源ID:getResources().getString(R.string.xxxxxx);
     * @param duration 单位:毫秒
     */
    public static void show(int resId, int duration) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, resId, duration);
        } else {
            mToast.setText(resId);
        }
        mToast.show();
    }

    /**
     * 自定义Toast的View
     * @param msg 消息
     * @param duration 单位:毫秒
     * @param view 显示自己的View
     */
    public static void customToastView(CharSequence msg, int duration, View view) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        if(view != null){
            mToast.setView(view);
        }
        mToast.show();
    }

    /**
     * 自定义Toast的位置
     * @param msg 消息内容
     * @param duration 单位:毫秒
     * @param gravity 位置
     * @param xOffset x坐标
     * @param yOffset y坐标
     */
    public static void customToastGravity(
            CharSequence msg, int duration,int gravity, int xOffset, int yOffset) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    /**
     * 自定义带图片和文字的Toast，最终的效果就是上面是图片，下面是文字
     * @param msg 消息内容
     * @param iconResId 图片的资源id,如:R.drawable.icon
     * @param duration 单位:毫秒
     * @param gravity 位置
     * @param xOffset x坐标
     * @param yOffset y坐标
     */
    public static void showToastWithImageAndText(
            CharSequence msg, int iconResId, int duration, int gravity, int xOffset, int yOffset) {
        if (null == context) {
            LogUtil.e("context is null");
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.setGravity(gravity, xOffset, yOffset);
        LinearLayout toastView = (LinearLayout) mToast.getView();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(iconResId);
        toastView.addView(imageView, 0);
        mToast.show();
    }

    /**
     * 取消Toast
     */
    public void cancelToast() {
        if(mToast == null){
            return;
        }
        mToast.cancel();
    }

}
