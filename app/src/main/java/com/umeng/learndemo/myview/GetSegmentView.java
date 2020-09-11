package com.umeng.learndemo.myview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date
 * @description
 */
public class GetSegmentView extends View {
    private Paint mpaint;
    private Path mCirclePath;
    private Path mDstPath;
    private PathMeasure mPathMeasure;
    private Float mCurAnimValue;
    public GetSegmentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);//禁止硬件加速
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float length=mPathMeasure.getLength();
        float stop=length*mCurAnimValue;
        float start=(float)(stop-((0.5-Math.abs(mCurAnimValue-0.5))*length));//当进度是0.5的时候，路径的起点始终是0开始，
        // 当进度是0.5-1时，路径的起点逐渐靠近接终点。
        mDstPath.reset();
        mPathMeasure.getSegment(start,stop,mDstPath,true);
        canvas.drawPath(mDstPath,mpaint);
    }

    private  void init(){
        mpaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(Color.BLACK);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(4);
        mCirclePath=new Path();
        mCirclePath.addCircle(100,100,50,Path.Direction.CW);
        mPathMeasure=new PathMeasure(mCirclePath,true);
        mDstPath=new Path();
        ValueAnimator animator=ValueAnimator.ofFloat(0,1);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue=(Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }
}
