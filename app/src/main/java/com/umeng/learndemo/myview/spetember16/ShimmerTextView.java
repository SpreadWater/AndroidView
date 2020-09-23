package com.umeng.learndemo.myview.spetember16;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/16
 * @Time 19:18
 * @description 利用Lieargradient实现闪光文字
 */
public class ShimmerTextView extends androidx.appcompat.widget.AppCompatTextView {
    private int mDx;//Lieargradient的移动距离
    private LinearGradient mLinearGradient;
    private Paint mPaint;

    public ShimmerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = getPaint();//初始化的时候就初始化mPaint
        int length = (int) mPaint.measureText(getText().toString());//text的长度
        createAnim(length);
        createLinearGradient(length);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(mDx, 0);
        mLinearGradient.setLocalMatrix(matrix);
        //使用matrix进行缩放
        mPaint.setShader(mLinearGradient);
        /*
            super.onDraw(canvas)是父类的绘制函数
            Textview会在Ondraw()函数重绘文字，
         */
        super.onDraw(canvas);
    }

    private void createAnim(int length) {
        ValueAnimator animator = ValueAnimator.ofInt(0, 2 * length);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.start();
    }

    private void createLinearGradient(int length) {
        mLinearGradient = new LinearGradient(-length, 0, 0, 0, new int[]{
                getCurrentTextColor(), 0xff00ff00, getCurrentTextColor()
        }, new float[]{
                0, 0.5f, 1
        }, Shader.TileMode.CLAMP);

    }
}
