package com.umeng.learndemo.myview.spetember16;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/16
 * @Time 8:44
 * @description LinearGradientView的一个demo。颜色线性渐变
 */
public class LinearGradientView extends View {
    private Paint mPaint;

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //单色渐变
//        mPaint.setShader(new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,
//                0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));

        //多色渐变
        int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff};
        float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
        LinearGradient multiGradient = new LinearGradient(0, getHeight() / 2, getWidth(), getHeight() / 2,
                colors, pos, Shader.TileMode.CLAMP);
        mPaint.setShader(multiGradient);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
