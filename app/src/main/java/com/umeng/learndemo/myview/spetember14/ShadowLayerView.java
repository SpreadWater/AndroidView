package com.umeng.learndemo.myview.spetember14;

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
 * @Date 2020/9/14
 * @Time 17:06
 * @description 设置文字和图片的阴影
 */
public class ShadowLayerView extends View {
    private Paint mpaint=new Paint();
    private Bitmap mBitmap;
    private Boolean mSetShadow;
    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //禁止硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mpaint.setColor(Color.BLACK);
        mpaint.setTextSize(25);
//        mpaint.setShadowLayer(1,10,10,Color.GRAY);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mSetShadow) {
            //如果设置了shadow
            mpaint.setShadowLayer(1,10,10,Color.GRAY);
        }else{
            mpaint.clearShadowLayer();
        }
        canvas.drawColor(Color.WHITE);
        canvas.drawText("红岩网校",100,100,mpaint);
        canvas.drawCircle(300,100,50,mpaint);
        canvas.drawBitmap(mBitmap,null,new Rect(500,50,
                500+mBitmap.getWidth(),50+mBitmap.getHeight()),mpaint);

    }
    //用于外面调用来调节是否设置阴影
    public void setmSetShadow(Boolean mSetShadow) {
        this.mSetShadow = mSetShadow;
        postInvalidate();
    }
}
