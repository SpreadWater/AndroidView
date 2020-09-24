package com.umeng.learndemo.myview.spetember24;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/24
 * @Time 10:53
 * @description
 */
public  class ALPHA_COLOR_FLAG_VIEW extends View {
    private Paint mPaint;
    public ALPHA_COLOR_FLAG_VIEW(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mPaint=new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
//        canvas.saveLayer(0,0,300,300,mPaint)
    }
}
