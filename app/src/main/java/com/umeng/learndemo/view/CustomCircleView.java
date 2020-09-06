package com.umeng.learndemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author zhangsan
 * @date
 * @description canvas示例1，裁剪构造圆形头像
 */
class CustomCircleView extends View {
    private Bitmap mbitmap;
    private Paint  mpaint;
    private Path  mpath;
    public CustomCircleView(Context context) {
        super(context);
    }

    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void  init(){
        //在裁剪的时候禁止硬件加速功能
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
        mpaint=new Paint();
        mpath=new Path();
        //获取图片的宽
        int width=mbitmap.getWidth();
        int height=mbitmap.getHeight();
        mpath.addCircle(width/2,height/2,width/4,Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘图时，将画布裁剪成圆形后再绘制
        canvas.save();
        canvas.clipPath(mpath);
        canvas.drawBitmap(mbitmap,0,0,mpaint);
        canvas.restore();
    }
}
