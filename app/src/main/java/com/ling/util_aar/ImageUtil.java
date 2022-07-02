package com.ling.util_aar;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 图片加载工具类
 * 使用前须AndroidManifest.xml加网络权限 和 build.gradle -> Glide
 * <uses-permission android:name="android.permission.INTERNET"/>
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 * implementation "com.github.bumptech.glide:glide:4.11.0"
 * 后续增加需要使用的工具
 */
public class ImageUtil {

    /**
     * 使用Glide加载网络图片
     *
     * @param context 上下文
     * @param url 链接
     * @param imageView 图片控件
     */
    public static void loadingWebImagesWithGlide(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);
    }

}
