package com.umeng.learndemo.myview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/14
 * @Time 16:43
 * @description 一个波浪的自定义view
 */
public class AnimWaveView extends View {
    private Paint mPaint;
    private Path mPath;
    private int mItemWaveLength=1200;//波长
    private int dx;
    public AnimWaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        startAnim();
        mPath=new Path();
        mPaint=new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        int originY=300;
        int halfWaveLen=mItemWaveLength/2;//波动的长度
        mPath.moveTo(-mItemWaveLength+dx,originY);//起点
        for (int i=-mItemWaveLength;i<=getWidth()+mItemWaveLength;i+=mItemWaveLength){
            mPath.rQuadTo(halfWaveLen/2,-100,halfWaveLen,0);//相比上一个点下移，右移
            mPath.rQuadTo(halfWaveLen/2,100,halfWaveLen,0);//相比上一个点上移，右移
        }
        //将下方也填充进去
        mPath.lineTo(getWidth(),getHeight());
        mPath.lineTo(0,getHeight());
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
    private  void  startAnim(){
        ValueAnimator animator=ValueAnimator.ofInt(0,mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx=(int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
