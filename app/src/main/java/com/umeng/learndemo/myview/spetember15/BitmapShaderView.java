package com.umeng.learndemo.myview.spetember15;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/15
 * @Time 16:50
 * @description 9月15日BitmapShader学习demo
 */
public class BitmapShaderView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
        mPaint=new Paint();
        mPaint.setShader(new BitmapShader(mBitmap,
                Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

    }
}
