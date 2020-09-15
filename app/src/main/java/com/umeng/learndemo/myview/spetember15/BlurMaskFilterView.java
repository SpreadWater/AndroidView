package com.umeng.learndemo.myview.spetember15;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/15
 * @Time 16:18
 * @description 9月15日发光效果BlurMaskFilter学习demo
 */
public class BlurMaskFilterView extends View {
    private Paint mpaint;
    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mpaint=new Paint();
        mpaint.setColor(Color.BLACK);
        /*
            设置发光类型是内发光
         */
        mpaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,200,100,mpaint);
    }
}
