package com.umeng.learndemo.myview.spetember14;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/14
 * @Time 15:46
 * @description 用于绘制贝济埃曲线的自定义view
 */
public class PathView extends View {
    private Paint paint;
    Path path = new Path();
    float mPreX;
    float mPreY;

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 控制点是上一个手指的位置
     * 起始点是上一条线段的终点
     * 终点是这条线段的中间位置
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
//                path.lineTo(event.getX(), event.getY());
                //计算终止点的位置坐标
                float endX=(mPreX+event.getX())/2;
                float endY=(mPreY+event.getY())/2;
                path.quadTo(mPreX,mPreY,endX,endY);
                //更新新的控制点，下一个起始点是上一个的终点
                mPreX=event.getX();
                mPreY=event.getY();
                postInvalidate();
                break;
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        path.moveTo(100, 300);
//        path.quadTo(200, 200, 300, 300);
//        path.quadTo(400, 400, 500, 300);
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, paint);
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }
}
