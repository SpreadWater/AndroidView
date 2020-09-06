package com.umeng.learndemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
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

        //------------------------>9月6日，Region中op操作学习demo

//        //设置画笔的基础属性
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);//设置画笔的颜色
//        paint.setStyle(Paint.Style.STROKE);//设置填充样式
//        paint.setStrokeWidth(2);
//        //构造连个矩形
//        Rect rect1=new Rect(100,100,400,200);
//        Rect rect2=new Rect(200,0,300,300);
//
//        canvas.drawRect(rect1,paint);
//        canvas.drawRect(rect2,paint);
//        //利用上面两个rect构造两个region
//        Region region=new Region(rect1);
//        Region region2=new Region(rect2);
//        //取两个区域的交集
//        region.op(region2, Region.Op.INTERSECT);
//
//        Paint paint_fill=new Paint();
//        paint_fill.setColor(Color.GREEN);
//        paint_fill.setStyle(Paint.Style.FILL);
//
//        drawRegion(canvas,region,paint_fill);

        //------------------------>9月6日Region学习union学习demo

        //构造一条椭圆路径
//        Path ovalPath=new Path();
//        RectF rectF=new RectF(50,50,200,500);
//        ovalPath.addOval(rectF,Path.Direction.CCW);
//        Region rgn=new Region();
//        rgn.setPath(ovalPath,new Region(50,50,200,200));
//        Region rgn=new Region(10,10,200,100);
//        rgn.union(new Rect(10,10,50,300));
//        drawRegion(canvas,rgn,paint);

        //------------------------>9月6日canvas学习demo

//         Paint paint_green=generatePaint(Color.GREEN, Paint.Style.STROKE,3);
//        Paint paint_red=generatePaint(Color.RED,Paint.Style.STROKE,3);
//        //构造一个矩形
//        Rect rect1=new Rect(0,0,400,200);
//        //在平移画布前，用绿色画笔画下边框
//        canvas.drawRect(rect1,paint_green);
//        //在平移画布后，用红色画笔画下边框
//        canvas.translate(100,100);
//        canvas.drawRect(rect1,paint_red);

        //------------------------>9月6日clip函数学习demo

//        canvas.drawColor(Color.RED);
//        canvas.clipRect(new Rect(100,100,200,200));
//        canvas.drawColor(Color.GREEN);

        //------------------------>9月6日save()and restore()函数学习demo
            canvas.drawColor(Color.RED);
            //保存当前画布的大小，即整屏
            canvas.save();


            canvas.clipRect(new Rect(100,100,800,800));
            canvas.drawColor(Color.GREEN);
            //恢复整平画布
            canvas.restore();

            canvas.drawColor(Color.BLUE);
    }
    //方便Region学习的画出区域
    private void drawRegion(Canvas canvas,Region region,Paint paint){
        RegionIterator iter=new RegionIterator(region);
        Rect r=new Rect();
        while(iter.next(r)){
            canvas.drawRect(r,paint);
        }
    }
    private  Paint generatePaint(int color,Paint.Style style,int width){
        Paint paint=new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
