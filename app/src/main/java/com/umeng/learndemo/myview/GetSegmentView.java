package com.umeng.learndemo.myview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author zhangsan
 * @date
 * @description //path和getposTan绘制的旋转箭头图片.
 */
public class GetSegmentView extends View {
    private Paint mpaint;
    private Path mCirclePath;
    private Path mDstPath;
    private PathMeasure mPathMeasure;
    private Float mCurAnimValue;
    private Bitmap mbitmap;
    private float[]pos=new float[2];
    private float[]tan=new float[2];
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
        mPathMeasure.getSegment(0,stop,mDstPath,true);

        //------------------->9月12日getPosTan学习之旋转箭头的绘制。

//        mPathMeasure.getPosTan(stop,pos,tan);
//        float degrees=(float)(Math.atan2(tan[1],tan[0])*180.0/Math.PI);//计算箭头旋转的角度
//        Matrix matrix=new Matrix();
//        matrix.postRotate(degrees,mbitmap.getWidth()/2,mbitmap.getHeight()/2);//图片旋转的角度
//        matrix.postTranslate(pos[0]-mbitmap.getWidth()/2,pos[1]-mbitmap.getHeight()/2);//图片移动的位置,还需要少移动一个图片的位置才可以
//        canvas.drawBitmap(mbitmap,matrix,mpaint);


        //------------------->9月12日getMatrix学习之旋转箭头的绘制。
        Matrix matrix=new Matrix();
        mPathMeasure.getMatrix(stop,matrix,PathMeasure.POSITION_MATRIX_FLAG|PathMeasure.TANGENT_MATRIX_FLAG);
        matrix.preTranslate(-mbitmap.getWidth()/2,-mbitmap.getHeight()/2);
        canvas.drawBitmap(mbitmap,matrix,mpaint);
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
        mbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.arraw);
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
