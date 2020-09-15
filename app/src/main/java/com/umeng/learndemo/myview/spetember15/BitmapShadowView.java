package com.umeng.learndemo.myview.spetember15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
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
 * @Date 2020/9/15
 * @Time 16:27
 * @description
 */
public class BitmapShadowView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Bitmap mAlphaBitmap;

    public BitmapShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
        mAlphaBitmap = mBitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = 200;
        int height = width * mAlphaBitmap.getWidth() / mAlphaBitmap.getHeight();

        //绘制灰色阴影
        mPaint.setColor(Color.GRAY);
        //内外发光
        mPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mAlphaBitmap, null, new Rect(10, 10, width, height), mPaint);

        //绘制黑色阴影
//        canvas.translate(width, 0);//移动画布
//        mPaint.setColor(Color.BLACK);
//        canvas.drawBitmap(mAlphaBitmap, null, new Rect(10, 10, width, height), mPaint);

        //绘制原图，自己实现图片的阴影处理
        canvas.translate(-5,-5);//左移一段距离，方便阴影漏出来
        mPaint.setMaskFilter(null);
        canvas.drawBitmap(mBitmap,null,new Rect(0,0,width,height),mPaint);
    }
}
