package com.umeng.learndemo.myview.sptember16;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author SpreadWater
 * @Date 2020/9/16
 * @Time 8:33
 * @description  利用BitmapShader生成不规则头像
 */
public class AvatorView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;

    public AvatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
        mPaint=new Paint();
        mBitmapShader=new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix=new Matrix();
        float scale=(float)getWidth()/mBitmap.getWidth();
        //将图像缩放成一个正方形
        matrix.setScale(scale,scale);
        //将bitmapshader缩放到与控件宽高一致
        mBitmapShader.setLocalMatrix(matrix);
        mPaint.setShader(mBitmapShader);

        float half=getWidth()/2;
        //画圆的话显示的就是一个圆形头像，
        canvas.drawCircle(half,half,getWidth()/2,mPaint);
    }
}
