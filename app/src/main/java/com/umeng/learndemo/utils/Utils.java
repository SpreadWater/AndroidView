package com.umeng.learndemo.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author SpreadWater
 * @Date 2020/9/13
 * @Time 11:25
 * @description  工具类封装
 */
public class Utils {
    //dp转px的工具
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}
