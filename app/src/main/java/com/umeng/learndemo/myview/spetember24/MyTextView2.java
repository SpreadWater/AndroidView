package com.umeng.learndemo.myview.spetember24;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/24
 * @Time 11:16
 * @description 封装控件的一个demo
 */
public class MyTextView2 extends androidx.appcompat.widget.AppCompatTextView {
    public MyTextView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyTextView2);
        float headerHeight=typedArray.getDimension(R.styleable.MyTextView2_headerHeight,-1);
        int age=typedArray.getInt(R.styleable.MyTextView2_age,-1);
        typedArray.recycle();
        this.setText("headerHeight: "+headerHeight+" age:"+age);
    }
}
