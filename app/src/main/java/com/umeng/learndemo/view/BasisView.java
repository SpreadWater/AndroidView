package com.umeng.learndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date
 * @description
 */
class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的基础属性
        Paint paint=new Paint();
        paint.setColor(Color.RED);//设置画笔的颜色
        paint.setStyle(Paint.Style.STROKE);//设置填充样式
        paint.setStrokeWidth(5);//在Style不起作用时，设置画笔的宽度,
        // 在Style不起作用的时候，设置描边的宽度

        //直线，点与Style是没有关系的

        //画图
        //直接构造
//       canvas.drawRect(10,10,100,100,paint);
//        //使用RectF构造
//        paint.setStyle(Paint.Style.FILL);
//        RectF rectF=new RectF(210f,10f,300f,100f);
//        canvas.drawRect(rectF,paint);
        Path path=new Path();
        path.moveTo(10,10);//设定起始点
//        path.lineTo(10,100);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(300,100);//画第二条直线
//        path.close();//闭环
//        canvas.drawPath(path,paint);
        RectF rectF=new RectF(100,10,200,100);
        path.arcTo(rectF,0,90,true);
        canvas.drawPath(path,paint);
    }
}
