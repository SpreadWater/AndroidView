package com.umeng.learndemo.myview.spetember7;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date
 * @description
 */
class BasisView extends View {
    private Context mContext;

    //xml文件引用必须重写的构造方法
    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //------------------------>9月6日，Region中op操作学习demo

        //设置画笔的基础属性
//        Paint paint = new Paint();
//        paint.setColor(Color.RED);//设置画笔的颜色
//        paint.setStyle(Paint.Style.STROKE);//设置填充样式
//        paint.setStrokeWidth(2);
//        //构造连个矩形
//        Rect rect1=new Rect(100,100,400,200);
//        Rect rect2=new Rect(200,0,300,300);
//
//        canvas.drawRect(rect1,paint);
//        canvas.drawRect(rect2,paint);
//        //利用上面两个rect构造两个region
//        Region region=new Region(rect1);
//        Region region2=new Region(rect2);
//        //取两个区域的交集
//        region.op(region2, Region.Op.INTERSECT);
//
//        Paint paint_fill=new Paint();
//        paint_fill.setColor(Color.GREEN);
//        paint_fill.setStyle(Paint.Style.FILL);
//
//        drawRegion(canvas,region,paint_fill);

        //------------------------>9月6日Region学习union学习demo

        //构造一条椭圆路径
//        Path ovalPath=new Path();
//        RectF rectF=new RectF(50,50,200,500);
//        ovalPath.addOval(rectF,Path.Direction.CCW);
//        Region rgn=new Region();
//        rgn.setPath(ovalPath,new Region(50,50,200,200));
//        Region rgn=new Region(10,10,200,100);
//        rgn.union(new Rect(10,10,50,300));
//        drawRegion(canvas,rgn,paint);

        //------------------------>9月6日canvas学习demo

//         Paint paint_green=generatePaint(Color.GREEN, Paint.Style.STROKE,3);
//        Paint paint_red=generatePaint(Color.RED,Paint.Style.STROKE,3);
//        //构造一个矩形
//        Rect rect1=new Rect(0,0,400,200);
//        //在平移画布前，用绿色画笔画下边框
//        canvas.drawRect(rect1,paint_green);
//        //在平移画布后，用红色画笔画下边框
//        canvas.translate(100,100);
//        canvas.drawRect(rect1,paint_red);

        //------------------------>9月6日clip函数学习demo

//        canvas.drawColor(Color.RED);
//        canvas.clipRect(new Rect(100,100,200,200));
//        canvas.drawColor(Color.GREEN);

        //------------------------>9月6日save()and restore()函数学习demo
//            canvas.drawColor(Color.RED);
//            //保存当前画布的大小，即整屏
//            canvas.save();
//
//
//            canvas.clipRect(new Rect(100,100,800,800));
//            canvas.drawColor(Color.GREEN);
//            //恢复整平画布
//            canvas.restore();
//
//            canvas.drawColor(Color.BLUE);

        //------------------------>9月6日Path中CCW和CW，根据路径生成方向来布局文字

            //第一条路径逆向生成
//            Path CCWRectpath=new Path();
//            RectF rect1=new RectF(50,50,240,200);
//            CCWRectpath.addRect(rect1,Path.Direction.CCW);
//
//            //第二条路径顺向生成
//            Path CwRectpath=new Path();
//            RectF rect2=new RectF(290,50,480,200);
//            CwRectpath.addRect(rect2,Path.Direction.CW);
//
//            //先画出这两天路径
//            canvas.drawPath(CCWRectpath,paint);
//            canvas.drawPath(CwRectpath,paint);
//            //依据路径布局文字
//            String text="苦心人天不负，有志者事竟成";
//            paint.setColor(Color.GREEN);
//            paint.setTextSize(35);
//            canvas.drawTextOnPath(text,CCWRectpath,0,18,paint);//逆时针方向生成文字
//            canvas.drawTextOnPath(text,CwRectpath,0,18,paint);//顺时针方向生成文字


        //------------------------>9月6日path的填充模式测试

//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
//        paint.setStyle(Paint.Style.FILL);
//
//        Path path=new Path();
//        path.addRect(100,100,300,300,Path.Direction.CW);
//        path.addCircle(300,300,100,Path.Direction.CW);
//        path.setFillType(Path.FillType.WINDING);//两个图形相交时，取相交的部分
//        path.setFillType(Path.FillType.EVEN_ODD);//取path所在，并不相交的部分
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);//取path所在，并不相交的相反的部分
//        path.setFillType(Path.FillType.INVERSE_WINDING);//取相交的相反的部分
//        canvas.drawPath(path,paint);

        //------------------------>9月7日文字方面的学习demo

        Paint paint=new Paint();
        paint.setColor(Color.RED);//设置画笔的颜色
//        paint.setStrokeWidth(5);//设置画笔的宽度
//        paint.setAntiAlias(true);//设置是否使用抗锯齿功能。如果使用，则会使绘图速度变慢
        paint.setTextSize(50);//设置文字的大小

//        paint.setStyle(Paint.Style.FILL);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setTextAlign(Paint.Align.LEFT);
//        paint.setTextAlign(Paint.Align.RIGHT);
//        paint.setTextAlign(Paint.Align.CENTER);
//        paint.setFakeBoldText(true);//设置成粗体
//        paint.setUnderlineText(true);//设置文字的下划线效果
//        paint.setStrikeThruText(true);//设置带有删除线的效果

//        //正常样式
////        canvas.drawText("床前明月光",20,100,paint);
////
////        //向右倾斜
////        paint.setTextSkewX(-0.25f);
////        canvas.drawText("床前明月光",20,200,paint);
////
////        //向左倾斜
////        paint.setTextSkewX(0.25f);
////        canvas.drawText("床前明月光",20,300,paint);

//        //正常样式
//        canvas.drawText("床前明月光",20,100,paint);
//        //水平拉伸两倍
//        paint.setTextScaleX(2);
//        canvas.drawText("床前明月光",20,200,paint);

//        //文字的截取
//        canvas.drawText("床前明月光",2,4,20,300,paint);

        //逐个指定文字位置（目前已经不可用）
//        float []pos=new float[]{80,100,80,200,80,300,80,400};//每个文字的位置
//        canvas.drawPosText("床前明月光",pos,paint);

        //沿路径绘制

        //先创建两条相同的圆形路径，并画出两条路径原形
//        Path circlepath=new Path();
//        circlepath.addCircle(220,300,150,Path.Direction.CCW);//逆向绘制
//        canvas.drawPath(circlepath,paint);
//
//        Path circlepath2=new Path();
//        circlepath2.addCircle(600,300,150,Path.Direction.CCW);//顺向绘制
//        canvas.drawPath(circlepath2,paint);
//
//        //绘制原始文字和偏移文字
//        String text="床前明月光";
//        paint.setColor(Color.GREEN);
//        //hOffset（与路径起始点的水平偏移）,vOffset(与路径中心的垂直偏移量)参数全部设置为0，查看最初的模式是什么样子的
//        canvas.drawTextOnPath(text,circlepath,0,0,paint);
//        //第二条路径
//        canvas.drawTextOnPath(text,circlepath2,80,30,paint);


        //设置字体的样式
//        Typeface typeface=Typeface.defaultFromStyle(Typeface.ITALIC);//黑粗斜体
//        paint.setTypeface(typeface);
//        String familyname="宋体";
//        Typeface typeface=Typeface.create(familyname,Typeface.NORMAL);
//        paint.setTypeface(typeface);
//        canvas.drawText("床前明月光",10,100,paint);

        //自定义文字体样式
        AssetManager assetManager=mContext.getAssets();
        //根据路径得到Typeface
        Typeface typeface=Typeface.createFromAsset(assetManager,"fonts/jian_luobo.ttf");
        paint.setTypeface(typeface);
        canvas.drawText("床前明月光，疑是地上霜",10,100,paint);

        //------------------------>9月7日控件的使用demo


    }
    //方便Region学习的画出区域
    private void drawRegion(Canvas canvas,Region region,Paint paint){
        RegionIterator iter=new RegionIterator(region);
        Rect r=new Rect();
        while(iter.next(r)){
            canvas.drawRect(r,paint);
        }
    }
    private  Paint generatePaint(int color,Paint.Style style,int width){
        Paint paint=new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
