package com.ling.util_aar;

import java.util.List;

/**
 * 常用列表工具类
 */
public class ListUtil {

    /**
     * 判断列表是否为空
     *
     * @param list 需要判断的列表
     * @return 列表是否为空
     */
    public static boolean isEmpty(List<Object> list) {
        if (null == list) {
            return true;
        }
        return list.isEmpty();
    }

}
