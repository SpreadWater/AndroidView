package com.umeng.learndemo.myview.spetember23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/23
 * @Time 14:23
 * @description
 */
public class SaveLayerUseExample extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public SaveLayerUseExample(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        int layerId=canvas.saveLayer(0,0,200,200,mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawColor(Color.GRAY);
//        canvas.skew(1.732f,0);
//        canvas.drawRect(0,0,150,160,mPaint);
        canvas.restoreToCount(layerId);
    }
}
