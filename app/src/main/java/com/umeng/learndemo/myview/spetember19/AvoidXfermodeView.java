package com.umeng.learndemo.myview.spetember19;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/19
 * @Time 20:47
 * @description
 */
public class AvoidXfermodeView extends View {
    private Paint mPaint;
    private Bitmap mBmp;
    public AvoidXfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mBmp= BitmapFactory.decodeResource(getResources(), R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getWidth()/2;
        int height=width*mBmp.getHeight()/mBmp.getWidth();
        //新建图层
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),null
        ,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mBmp,null,new Rect(0,0,width,height),mPaint);
    }
}
