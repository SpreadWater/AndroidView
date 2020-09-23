package com.umeng.learndemo.myview.spetember16;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/16
 * @Time 19:45
 * @description
 */
public class RadialGradientView extends View {
    private Paint mPaint;
    private RadialGradient mRadialGradient;
    private int mRadius;
    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRadialGradient==null){
            mRadius=getWidth()/2;
            mRadialGradient=new RadialGradient(getWidth()/2,getHeight()/2,mRadius,
                    0xffff0000,0xff00ff00, Shader.TileMode.REPEAT);
            mPaint.setShader(mRadialGradient);
        }
        canvas.drawCircle(getWidth()/2,getHeight()/2,mRadius,mPaint);
    }
}
