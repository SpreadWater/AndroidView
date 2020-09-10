package com.umeng.learndemo.interpolator;

import android.animation.TimeInterpolator;

/**
 * @author zhangsan
 * @date
 * @description
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
