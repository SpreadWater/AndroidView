package com.umeng.learndemo.myview.spetember7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.R;

/**
 * @author zhangsan
 * @date
 * @description
 */
class ClipRgnView extends View {
    private Bitmap mbitmap;
    private int clipWidth=0;
    private int width;
    private int height;
    private static final int CLIP_HELIGHT=30;
    private Path mpath;
    public ClipRgnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private  void init(){
        //裁剪的时候禁止硬件加速功能
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mbitmap= BitmapFactory.decodeResource(getResources(), R.drawable.ic_avatar);
        width=mbitmap.getWidth();
        height=mbitmap.getHeight();
        mpath=new Path();
    }

    @Override//在ondraw中计算裁剪区域并绘图
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mpath.reset();
        int i=0;
        while(i*CLIP_HELIGHT<=height){//计算clip的区域
            if (i%2==0){
                mpath.addRect(new RectF(0,i*CLIP_HELIGHT,clipWidth,(i+1)*CLIP_HELIGHT),Path.Direction.CCW);
            }else{
                mpath.addRect(new RectF(width-clipWidth,i*CLIP_HELIGHT,width,(i+1)*CLIP_HELIGHT),Path.Direction.CCW);
            }
            i++;
        }
        canvas.clipPath(mpath);
        canvas.drawBitmap(mbitmap,0,0,new Paint());
        if (clipWidth>width){
            return;
        }
        clipWidth+=5;
        invalidate();//重复ondraw()
    }
}
