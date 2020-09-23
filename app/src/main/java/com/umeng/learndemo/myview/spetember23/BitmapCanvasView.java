package com.umeng.learndemo.myview.spetember23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/23
 * @Time 14:05
 * @description
 */
public  class BitmapCanvasView extends View {
    private Bitmap mBitmap;
    private Paint mPaint;
    private Canvas mBmpCanvas;
    public BitmapCanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mBitmap=Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        mBmpCanvas=new Canvas(mBitmap);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setTextSize(50);
        mBmpCanvas.drawText("欢迎光临",0,100,mPaint);
        canvas.drawBitmap(mBitmap,0,0,mPaint);
    }
}
