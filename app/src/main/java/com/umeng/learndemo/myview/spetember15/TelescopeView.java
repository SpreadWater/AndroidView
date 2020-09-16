package com.umeng.learndemo.myview.spetember15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/15
 * @Time 17:04
 * @description 利用BitmapShader实现望远镜效果
 */
public class TelescopeView extends View {
    private Paint mPaint;
    private Bitmap mBitmap, mBitmapBG;
    private int mDx, mDy;

    public TelescopeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);

    }

    //在手指按下和移动的时候获得手指所在的位置

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDx = (int) event.getX();
                mDy = (int) event.getY();
                postInvalidate();
                return true;//只有返回true的时候后面才能继续的监听到剩下的指令动作
            case MotionEvent.ACTION_MOVE:
                mDx = (int) event.getX();
                mDy = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mDx = -1;
                mDy = -1;
                break;
        }
        postInvalidate();//重新绘图
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBitmapBG == null) {
            //创建一个空白的位图，位图的大小和控件的大小一样
            mBitmapBG = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvasbg = new Canvas(mBitmapBG);
            //对背景图进行拉伸，画到这个空白的位图上
            canvasbg.drawBitmap(mBitmap, null, new Rect(0, 0, getWidth(), getHeight()), mPaint);

        }
        if (mDx != -1 && mDy != -1) {
            //将新建的mBitmapBG作为BitmapShader设置给Paint
            mPaint.setShader(new BitmapShader(mBitmapBG, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            //画一个圆圈，把圆圈部分的图形显示出来
            canvas.drawCircle(mDx, mDy, 150, mPaint);
        }
    }
}
