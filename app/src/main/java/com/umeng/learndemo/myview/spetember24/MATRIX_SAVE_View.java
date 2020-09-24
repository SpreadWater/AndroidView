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
 * @Time 10:44
 * @description
 */
public class MATRIX_SAVE_View extends View {
    private Paint mPaint;

    public MATRIX_SAVE_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint=new Paint();
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
