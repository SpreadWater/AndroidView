package com.umeng.learndemo.myview.spetember24;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/9/24
 * @Time 10:59
 * @description
 */
public class RestoreToCountView extends View {
    private Paint mPaint;
    private String TAG = "zt";

    public RestoreToCountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id1 = canvas.save();
        canvas.clipRect(0, 0, 800, 800);
        canvas.drawColor(Color.RED);
        Log.d(TAG, "count:" + canvas.getSaveCount() + "  id1:" + id1);

        int id2 = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(100, 100, 700, 700);
        canvas.drawColor(Color.GREEN);
        Log.d(TAG, "count:" + canvas.getSaveCount() + "  id2:" + id2);

        int id3 = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(200, 200, 600, 600);
        canvas.drawColor(Color.YELLOW);
        Log.d(TAG, "count:" + canvas.getSaveCount() + "  id3:" + id3);

        int id4 = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(300, 300, 500, 500);
        canvas.drawColor(Color.BLUE);
        Log.d(TAG, "count:" + canvas.getSaveCount() + "  id4:" + id4);

        canvas.restoreToCount(id3);
        canvas.drawColor(Color.GRAY);
        Log.d(TAG, "count: " + canvas.getSaveCount());


    }
}

