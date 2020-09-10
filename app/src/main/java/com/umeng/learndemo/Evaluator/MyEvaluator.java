package com.umeng.learndemo.Evaluator;

import android.animation.TypeEvaluator;

/**
 * @author zhangsan
 * @date
 * @description 自定义自己的Evaluator
 */
public class MyEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int starInt=(int)startValue;//将字符转成对应的ASCII码
        int endInt=(int)endValue;
        int curInt=(int)(starInt+fraction*(endInt-starInt));//获取当前字符对应的ASCII码
        char result=(char)curInt;
        return result;
    }
}
