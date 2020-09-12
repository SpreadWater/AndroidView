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
 * @author SpreadWater
 * @Date 2020/9/12
 * @Time 10:48
 * @description //仿支付宝支付成功的动画
 */
public class AliPayView extends View {
    private Path mCirclePath;
    private Path mDistPath;
    private Paint mpaint;
    private PathMeasure mPathMrasure;
    private float mRadius=50;//圆的半径
    private float mCentX=100;
    private float mCentY=100;
    private float mCurAnimValue;
    private boolean mnext=false;
    public AliPayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private  void init(){
        mpaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mpaint.setColor(Color.BLACK);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeWidth(4);
        mDistPath=new Path();
        mCirclePath=new Path();
        mCirclePath.addCircle(mCentX,mCentY,mRadius, Path.Direction.CW);

        //画勾的路径
        mCirclePath.moveTo(mCentX-mRadius/2,mCentY);
        mCirclePath.lineTo(mCentX,mCentY+mRadius/2);
        mCirclePath.lineTo(mCentX+mRadius/2,mCentY-mRadius/3);

        //计算时不计算自动闭合的部分
        mPathMrasure=new PathMeasure(mCirclePath,false);

        //0-1一条路径，1-2一条路径
        ValueAnimator animator=new ValueAnimator().ofFloat(0,2);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                    mCurAnimValue=(Float)animation.getAnimatedValue();
                    invalidate();
            }
        });
        animator.setDuration(4000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if (mCurAnimValue<1){
            float stop=mPathMrasure.getLength()*mCurAnimValue;
            //保证了绘图的连续性
            mPathMrasure.getSegment(0,stop,mDistPath,true);
        }else{
            if (!mnext){
                mnext=true;
                //获取第一条路径的全部完整的路径。
                mPathMrasure.getSegment(0,mPathMrasure.getLength(),mDistPath,true);
                mPathMrasure.nextContour();//获取下一条路径的片段
            }
            float stop=mPathMrasure.getLength()*(mCurAnimValue-1);
            mPathMrasure.getSegment(0,stop,mDistPath,true);
        }
        canvas.drawPath(mDistPath,mpaint);
    }
}
