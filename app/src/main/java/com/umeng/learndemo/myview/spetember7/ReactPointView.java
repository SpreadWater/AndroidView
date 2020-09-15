package com.umeng.learndemo.myview.spetember7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date
 * @description 点击变色的按钮
 */
class ReactPointView extends View {
    private int mX,mY;
    private Paint mpaint;
    private Rect mRect;

    public ReactPointView(Context context) {
        super(context);
        init();
    }

    public ReactPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        mpaint=new Paint();
        mpaint.setStyle(Paint.Style.STROKE);
        mRect=new Rect(100,10,300,100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX=(int)event.getX();
        mY=(int)event.getY();
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            //按下的时候让屏幕重新绘制
            invalidate();
            return  true;
        }else if (event.getAction()==MotionEvent.ACTION_UP){
            mX=-1;
            mY=-1;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            if (mRect.contains(mX,mY)){
                    mpaint.setColor(Color.RED);
            }else{
                mpaint.setColor(Color.GREEN);
            }
            canvas.drawRect(mRect,mpaint);
    }
}
