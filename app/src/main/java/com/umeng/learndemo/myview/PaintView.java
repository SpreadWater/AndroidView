package com.umeng.learndemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/12
 * @Time 15:49
 * @description  9月12日Paint的demo学习笔记
 */
public class PaintView extends View {
    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int baseLineX=0;
        int baseLineY=200;

        //画基线
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX,baseLineY,3000,baseLineY,paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(40);
//        paint.setTextAlign(Paint.Align.CENTER);//用于设置原点的位置，也就是这个点相对于文字矩形的位置
        //因为绘制的时候是从这个点开始绘制的。
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("生活就像击剑，要么出击，要么出局！",baseLineX,baseLineY,paint);

        //-------------------->9月12日计算ascent和descent的值

        Paint.FontMetrics fm=paint.getFontMetrics();
        float ascent=baseLineY+fm.ascent;
        float descent=baseLineY+fm.descent;
        float top=baseLineY+fm.top;
        float bottom=baseLineY+fm.bottom;

        //画top
        paint.setColor(Color.BLUE);
        canvas.drawLine(baseLineX,top,3000,top,paint);

        //画ascent
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX,ascent,3000,ascent,paint);

        //画descent
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX,descent,3000,descent,paint);

        //画bottom
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX,bottom,3000,bottom,paint);

    }
}
