package com.ling.util_aar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    /**
     * 检查是否可以上网，比如连接百度
     *
     * @param context 上下文
     * @return false网络不可用，true可用
     */
    public static boolean isNetworkConnect(Context context) {
        if (null == context) {
            LogUtil.e("isNetworkConnect context is null");
            return false;
        }
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            LogUtil.e("isNetworkConnect connectivity is null");
            return false;
        }
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info == null) {
            LogUtil.e("isNetworkConnect info is null");
            return false;
        }
        for (NetworkInfo networkInfo : info) {
            if (networkInfo.isAvailable() && networkInfo.isConnected()) {
                return true;
            }
        }
        LogUtil.e("isNetworkConnect no available || unConnected");
        return false;
    }

    /**
     * 检查网络可用(huawei mate40 pro 测试失败，关闭wifi和数据还是true，待进一步测试)
     *
     * @param context 上下文
     * @return false网络不可用，true可用
     */
    public static boolean isNetworkAvailable(Context context) {
        if (null == context) {
            LogUtil.e("isNetworkAvailable context is null");
            return false;
        }
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            LogUtil.e("isNetworkAvailable connectivity is null");
            return false;
        }
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info == null) {
            LogUtil.e("isNetworkAvailable info is null");
            return false;
        }
        for (NetworkInfo networkInfo : info) {
            if (networkInfo.isAvailable()) {
                return true;
            }
        }
        LogUtil.e("isNetworkAvailable no available");
        return false;
    }

    /**
     * 检查网络连接状态，网络连接已连接时，不一定能上的了互联网，比如连接到一个无网络的路由器上
     * 所以判断网络一般使用isNetworkAvailable()方法
     *
     * @param context 上下文
     * @return  false网络未连接，true网络已连接
     */
    public static boolean checkNetConnectState(Context context){
        if (null == context) {
            LogUtil.e("checkNetConnectState context is null");
            return false;
        }
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity == null) {
            LogUtil.e("checkNetConnectState connectivity is null");
            return false;
        }
        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info == null) {
            LogUtil.e("checkNetConnectState info is null");
            return false;
        }
        for (NetworkInfo networkInfo : info) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        LogUtil.e("checkNetConnectState unConnected");
        return false;
    }

    /**
     * 推断MOBILE网络是否可用
     * 需要注意的是wifi和手机同时连接时，会被判断成手机未连接,type优先使用wifi
     *
     * @param context 上下文
     * @return false手机网络不可用，true手机网络可用
     */
    public static boolean isMobileConnect(Context context) {
        if (null == context) {
            LogUtil.e("isMobileConnect context is null");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == connectivityManager) {
            LogUtil.e("isMobileConnect connectivityManager is null");
            return false;
        }
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
    }

    /**
     * 推断WIFI是否已连接
     * @param context 上下文
     * @return false未连接，true已连接
     */
    public static boolean isWifiConnect(Context context) {
        if (null == context) {
            LogUtil.e("isWifiConnect context is null");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null == connectivityManager) {
            LogUtil.e("isWifiConnect connectivityManager is null");
            return false;
        }
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
    }

}
