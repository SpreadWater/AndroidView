package com.umeng.learndemo.myview;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.umeng.learndemo.utils.Utils;

/**
 * @author SpreadWater
 * @Date 2020/9/13
 * @Time 11:23
 * @description 一款仿简书搜索框的自定义view
 */
public class SearchView extends View {

    public static final int SCROLL_HEAD_TOP=1;   //滑动到头部图片的上方
    public static final int SCROLL_HEAD_BOTTOM=2; //滑动到头部图片的下方

    private float currentOutLeftWidth=0.70f;   //弹出时初始的矩形宽度
    private float currentOutCircleWidth=0.75f; //弹出时初始的搜索图片宽度

    private float currentInLeftWidth=0.0f;    //缩回时初始的矩形宽度
    private float currentInCircleWidth=0.4f;  //缩回时初始的搜索图片宽度

    float radius=Utils.dpToPixel(7);
    float sin45r= (float) (Math.sqrt(2)*0.5*radius);  //圆的半径乘以sin45°

    private String searchtext="搜索简书的内容和朋友";//弹出时显示的hint
    private String search="搜索";//缩回的时候显示的文字

    private Paint paint1,paint2,paint3,paint4;

    private ValueAnimator mOutAnimator; //弹出时的动画
    private ValueAnimator mCircleOut;

    private ValueAnimator mInAnimator;  //缩回时的动画
    private ValueAnimator mCircleIn;

    //需要用到的dp转换成对应的px
    private float fivedp= Utils.dpToPixel(5);//5dp
    private float twentydp=Utils.dpToPixel(20);//20dp
    private float thirtyfivedp=Utils.dpToPixel(35);//35dp

    private SearchViewState searchViewState;


    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint1=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(Color.parseColor("#ffffff"));

        //用于绘制圆角矩形的边框的画笔
        paint2=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(Color.parseColor("#959595"));
        paint2.setStrokeWidth(Utils.dpToPixel(1));
        paint2.setStyle(Paint.Style.STROKE);

        //用于绘制搜索的文字
        paint3=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3.setColor(Color.parseColor("#959595"));
        paint3.setTextSize(Utils.dpToPixel(16));

        //用于绘制圆角矩形的画笔
        paint4=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4.setColor(Color.parseColor("#fcfcfc"));

        searchViewState=SearchViewState.INIT;
        setupAnimations();
    }

    private void setupAnimations() {
        //动画开始
        mOutAnimator=ValueAnimator.ofFloat(0.70f,0.0f);
        mOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentOutLeftWidth= (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });

        mCircleOut=ValueAnimator.ofFloat(0.75f,0.25f);
        mCircleOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentOutCircleWidth= (float) valueAnimator.getAnimatedValue();
                invalidate();

            }
        });

        mInAnimator=ValueAnimator.ofFloat(0.0f,0.7f);
        mInAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentInLeftWidth= (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });

        mCircleIn=ValueAnimator.ofFloat(0.4f,0.75f);
        mCircleIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentInCircleWidth= (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (searchViewState)
        {
            case INIT:
                drawInit(canvas);
                break;
            case OUT:
                drawOutAnimation(canvas);
                break;
            case IN:
                drawInAnimation(canvas);
                break;
        }
    }
    /*
        用于外界调用开始动画，
        监听滑动时间，通过判断滑动的状态和当前的搜索框状态调用动画
     */
    public void startAnimation(int state){
        //滑动到上方收回
        if(state==SCROLL_HEAD_TOP){
            //滑动到这个图片的上方时
            if(searchViewState==SearchViewState.OUT){
                //并且当前的搜索框状态时弹出的
                searchViewState=SearchViewState.IN;
                startAnimationIn();
            }
        }else{
            //滑动到头部图片的下方时弹出
            if(state==SCROLL_HEAD_BOTTOM){
                //判断这个搜索框的状态是收回和初态的时候
                if(searchViewState==SearchViewState.INIT||searchViewState==SearchViewState.IN){
                    searchViewState=SearchViewState.OUT;
                    startAnimationOut();
                }
            }
        }
    }


    public void startAnimationOut(){
        final AnimatorSet set = new AnimatorSet();
        set.playTogether(mOutAnimator,mCircleOut);
        set.setStartDelay(100);
        set.start();
    }

    public void startAnimationIn(){
        final AnimatorSet set = new AnimatorSet();
        set.playTogether(mInAnimator,mCircleIn);
        set.setStartDelay(100);
        set.start();
    }




    //绘制收回时的样式，结合动画
    private void drawInAnimation(Canvas canvas) {
        //绘制圆角矩形
        canvas.drawRoundRect(getWidth()*currentInLeftWidth,fivedp,getWidth(),thirtyfivedp,45,45,paint1);

        canvas.drawCircle(getWidth()*currentInCircleWidth,twentydp,radius,paint2);
        canvas.drawLine(getWidth()*currentInCircleWidth+sin45r,twentydp+radius,getWidth()*currentInCircleWidth+sin45r+sin45r,twentydp+radius+sin45r,paint2);

        canvas.drawText(search,getWidth()*currentInCircleWidth+twentydp,twentydp+radius,paint3);

    }

    //绘制一开始保持在里面的初始态(状态写死）
    private void drawInit(Canvas canvas) {
        //画一个圆角矩形
        canvas.drawRoundRect(getWidth()*0.70f,fivedp,getWidth(),thirtyfivedp,45,45,paint1);
        //画搜索的圆圈
        canvas.drawCircle(getWidth()*0.75f,twentydp,radius,paint2);
        //画搜索下方的线
        canvas.drawLine(getWidth()*0.75f+sin45r,twentydp+radius,getWidth()*0.75f+sin45r+sin45r,twentydp+radius+sin45r,paint2);
        //绘制缩回时的文字
        canvas.drawText(search,getWidth()*0.75f+twentydp,twentydp+radius,paint3);
    }
    //绘制弹出时候的样式,结合动画
    private void drawOutAnimation(Canvas canvas) {

        //画圆角矩形,画圆角矩形边框
        canvas.drawRoundRect(getWidth()*currentOutLeftWidth,fivedp,getWidth(),thirtyfivedp,45,45,paint4);
        canvas.drawRoundRect(getWidth()*currentOutLeftWidth,fivedp,getWidth(),thirtyfivedp,45,45,paint2);

        //画圆圈，画直线
        canvas.drawCircle(getWidth()*currentOutCircleWidth,twentydp,radius,paint2);
        canvas.drawLine(getWidth()*currentOutCircleWidth+sin45r,twentydp+radius,getWidth()*currentOutCircleWidth+sin45r+sin45r,twentydp+radius+sin45r,paint2);

        //画文字
        canvas.drawText(searchtext,getWidth()*currentOutCircleWidth+twentydp,twentydp+radius,paint3);
    }

    //一个枚举类表示搜索的状态
    private enum SearchViewState
    {
        INIT,OUT,IN;
    }
}
