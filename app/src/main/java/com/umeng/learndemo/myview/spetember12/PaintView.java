package com.umeng.learndemo.myview.spetember12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/12
 * @Time 15:49
 * @description 9月12日Paint的demo学习笔记
 */
public class PaintView extends View {
    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int baseLineX = 0;
//        int baseLineY = 200;
//
//        //画基线
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);
//
//        //写文字
//        paint.setColor(Color.GREEN);
//        paint.setTextSize(40);
////        paint.setTextAlign(Paint.Align.CENTER);//用于设置原点的位置，也就是这个点相对于文字矩形的位置
//        //因为绘制的时候是从这个点开始绘制的。
//        paint.setTextAlign(Paint.Align.LEFT);
//        canvas.drawText("生活就像击剑，要么出击，要么出局！", baseLineX, baseLineY, paint);


        //-------------------->9月12日计算ascent和descent的值

//        Paint.FontMetrics fm=paint.getFontMetrics();
//        float ascent=baseLineY+fm.ascent;
//        float descent=baseLineY+fm.descent;
//        float top=baseLineY+fm.top;
//        float bottom=baseLineY+fm.bottom;
//
//        //画top
//        paint.setColor(Color.BLUE);
//        canvas.drawLine(baseLineX,top,3000,top,paint);
//
//        //画ascent
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(baseLineX,ascent,3000,ascent,paint);
//
//        //画descent
//        paint.setColor(Color.GREEN);
//        canvas.drawLine(baseLineX,descent,3000,descent,paint);
//
//        //画bottom
//        paint.setColor(Color.RED);
//        canvas.drawLine(baseLineX,bottom,3000,bottom,paint);

        //---------------------------->9月13日paint学习demo，计算字符串所占区域的高度宽度
//        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
//        int top = baseLineY + fm.top;
//        int bottom = baseLineY + fm.bottom;
//        //所占区域的高度
//        int height = bottom - top;
//        //所占区域的宽度
//        int width = (int) paint.measureText("生活就像击剑，要么出击，要么出局！");

        //------------------------>9月13日，获取字符串的最小矩阵

//        String text = "harvic\'s blog";
//        Paint paint1 = new Paint();
//        paint1.setTextSize(120);
//        Rect minRect = new Rect();
//        paint1.getTextBounds(text, 0, text.length(), minRect);
//        //最小矩阵，实际top线的位置
//        int minTop=bounds.top+baseLineY;
//        //最小矩阵，实际bottom线的位置
//        int minBottom=bounds.bottom+baseLineY;
//        Log.e("zt", "onDraw: " + minRect.toShortString());


        //----------------------------------->9月13日，根据左上角的位置，top线的位置，计算出baseline的位置
        String  text="harvic\'s blog";
        int top=200;//top线的位置
        int baselineX=0;

        //设置paint
        Paint paint=new Paint();
        paint.setTextSize(120);//以px为单位
        paint.setTextAlign(Paint.Align.LEFT);//用于基线坐标原点在文字的左边

        //画top线
        paint.setColor(Color.BLUE);
        canvas.drawLine(baselineX,top,3000,top,paint);

        //计算出baseline的位置
        Paint.FontMetricsInt fm=paint.getFontMetricsInt();
        int baseLineY=top-fm.top;

        //画基线
        paint.setColor(Color.RED);
        canvas.drawLine(baselineX,baseLineY,3000,baseLineY,paint);

        //写文字
        paint.setColor(Color.GREEN);
        canvas.drawText(text,baselineX,baseLineY,paint);
    }

    /**
     * 获取指定字符串所对应的的最小矩阵,以(0,0)点所在位置为基线
     *
     * @param text   要测量最小矩形的字符串
     * @param start  要测量起始字符在字符串中的索引
     * @param end    所要测量的字符的长度
     * @param bounds 接受测量结果
     */
    public void getTextBounds(String text, int start, int end, Rect bounds) {
    }
}
