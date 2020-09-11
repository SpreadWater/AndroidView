package com.umeng.learndemo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date 9月7日
 * @description 蜘蛛网状图
 */
class SpideView extends View {

    private Paint radarPaint,valuePaint;
    private float radius;//网格最大半径
    private int count=6;//蜘蛛网格圈数
    //计算出每个夹角的度数
    private float angle = (float) (Math.PI*2/count);
    private int centerX;//中心x坐标
    private int centerY;//中心y坐标
    //数据
    private double[] data={2,5,1,6,4,5};
    //最大值
    private float maxValue=6;
    public SpideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    //根据view的长宽，获取整个布局的中心坐标,当控件的大小改变的时候就会回调到这个函数中，重新获取新的坐标
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius=Math.min(h,w)/2*0.9f;//选取view宽和长较小的一个值作为半径，
        //蜘蛛网的总大小占当前控件的90%
        //中心坐标
        centerX=w/2;
        centerY=h/2;
        postInvalidate();//重新绘制ondraw()
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制蜘蛛网格
        drawPolygon(canvas);
        //画网格中线
        drawLine(canvas);
        //画数据图
        drawRegion(canvas);
    }

    private void  init(){
        radarPaint=new Paint();
        radarPaint.setStyle(Paint.Style.STROKE);
        radarPaint.setColor(Color.GREEN);

        valuePaint=new Paint();
        valuePaint.setStyle(Paint.Style.FILL);
        valuePaint.setColor(Color.BLUE);
    }

    private void drawPolygon(Canvas canvas){
        Path path=new Path();
        float r=radius/(count);//r是蜘蛛丝之前的间距
        for (int i=1;i<=count;i++){
            float CuR=i*r;//    当前的半径
            path.reset();
            for (int j=0;j<count;j++){
                if (j==0){
                    path.moveTo(centerX+CuR,centerY);//蜘蛛网的第一个点的坐标
                }else{
                    //根据半径，计算出蜘蛛丝上面的每个点的坐标
                    float x=(float)(centerX+CuR*Math.cos(angle*j));
                    float y=(float)(centerY+CuR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            //画完一个六边形就闭合路径
            path.close();
            canvas.drawPath(path,radarPaint);
        }
    }
    //画网格中线
    private void drawLine(Canvas canvas){
        Path path=new Path();
        for (int i=0;i<count;i++){
            path.reset();
            path.moveTo(centerX,centerY);
            float x=(float)(centerX+radius*Math.cos(angle*i));
            float y=(float)(centerY+radius*Math.sin(angle*i));
            path.lineTo(x,y);
            canvas.drawPath(path,radarPaint);
        }
    }
    private void drawRegion(Canvas canvas){
        Path path=new Path();
        valuePaint.setAlpha(27);
        for (int i=0;i<count;i++){
            double percent=data[i]/maxValue;
            //通过数组找到每个点的坐标
            float x=(float)(centerX+radius*Math.cos(angle*i)*percent);
            float y=(float)(centerY+radius*Math.sin(angle*i)*percent);
            if (i==0){
                path.moveTo(x,centerY);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            canvas.drawCircle(x,y,10,valuePaint);
        }
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path,valuePaint);
    }
    //设置网格数
    public void setCount(int count) {
        this.count = count;
        this.maxValue=count;
    }
}

