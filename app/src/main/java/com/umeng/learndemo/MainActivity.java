package com.umeng.learndemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.umeng.learndemo.Evaluator.FallingBallEvaluator;
import com.umeng.learndemo.Evaluator.MyEvaluator;
import com.umeng.learndemo.interpolator.MyInterpolator;

//9月8日动画学习demo
public class MainActivity extends AppCompatActivity {
        private TextView tv1;
        private TextView tv2;
//    private ImageView ballimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
//        ballimg=(ImageView)findViewById(R.id.ball_img);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final TextView tv=(TextView)findViewById(R.id.tv);
                //--------->9月8日动画学习demo伸缩变化的类
//                ScaleAnimation animation= new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,
//                        Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                animation.setDuration(700);
                //--------->9月8日动画学习demo透明度类
//                AlphaAnimation animation=new AlphaAnimation(1.0f,0.1f);
//                animation.setDuration(3000);
//                animation.setFillBefore(true);
                //--------->9月8日动画学习demo旋转类
//                RotateAnimation animation=new RotateAnimation(0,-650,
//                        AlphaAnimation.RELATIVE_TO_SELF,0.5f,AlphaAnimation.RELATIVE_TO_SELF,0.5f);
//                animation.setDuration(3000);
//                animation.setFillAfter(true);
                //--------->9月8日动画学习demo移动类
//                TranslateAnimation animation=new TranslateAnimation(Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80,
////                        Animation.ABSOLUTE,0,Animation.ABSOLUTE,-80);
////                animation.setDuration(2000);
////                animation.setFillBefore(true);
                //--------->9月8日动画学习demo组合类
//                Animation aplha_Anim=new AlphaAnimation(1.0f,0.1f);
////                Animation scale_Anim=new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f
////                ,Animation.RELATIVE_TO_SELF,0.5f);
////                Animation roate_Anim=new RotateAnimation(0,720,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
////                AnimationSet setAnim=new AnimationSet(true);//公用一个插值器
////                setAnim.addAnimation(aplha_Anim);
////                setAnim.addAnimation(scale_Anim);
////                setAnim.addAnimation(roate_Anim);
////                setAnim.setDuration(3000);
////                setAnim.setFillAfter(true);

                ////--------->9月8日动画学习demo实现动画的监听事件
//                final RotateAnimation rotateAnim=new RotateAnimation(0,-650,Animation.RELATIVE_TO_SELF,0.5f,
//                        Animation.RELATIVE_TO_SELF,0.5f);
//                rotateAnim.setDuration(3000);
//                rotateAnim.setFillAfter(true);
//
//                ScaleAnimation scaleAnim=new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,
//                        Animation.RELATIVE_TO_SELF,0.5f);
//                scaleAnim.setDuration(700);
//                scaleAnim.setAnimationListener(new Animation.AnimationListener() {
//                    @Override
//                    public void onAnimationStart(Animation animation) {
//
//                    }
//
//                    @Override
//                    public void onAnimationEnd(Animation animation) {
//                            tv.startAnimation(rotateAnim);
//                    }
//
//                    @Override
//                    public void onAnimationRepeat(Animation animation) {
//
//                    }
//                });
//                AlphaAnimation animation=new AlphaAnimation(1.0f,0.1f);
//                animation.setDuration(3000);
//                animation.setFillBefore(true);
//                animation.setInterpolator(new LinearInterpolator());
//                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.translateanim);
//                animation.setInterpolator(new CycleInterpolator(1));
//                tv.startAnimation(animation);

                //--------------------->9月9日属性动画demo
                doAnimation();
            }
        });
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "clicked me ", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
        private void doAnimation () {
            //-------------------->9月9日Evalutaor，Interpolator学习demo

//        ValueAnimator animator=ValueAnimator.ofInt(0,400);
//        animator.setDuration(1000);

//        ValueAnimator animator=ValueAnimator.ofInt(0xffffff00,0xff0000ff);//颜色值过渡的Evaluator
//        animator.setEvaluator(new ArgbEvaluator());

//        ValueAnimator animator=ValueAnimator.ofObject(new MyEvaluator(),new Character('A'),new Character('Z'));
//        animator.setDuration(10000);
//        animator.setInterpolator(new AccelerateInterpolator());
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
////                int curValue = (Integer) animation.getAnimatedValue();//获取ValueAnimatro在当前运动点的值，或者是颜色的变化过度值
////                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
//                //控件通过layout函数来设置（left,top,right,bottom）位置，形成动画.实际的移动控件.
//                char text=(Character)animation.getAnimatedValue();
//                tv.setText(String.valueOf(text));
//            }
//        });
//        animator.setRepeatMode(ValueAnimator.REVERSE);
////        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setInterpolator(new MyInterpolator());
//        animator.setEvaluator(new MyEvaluator());
//        animator.start();

            //--------------------------->9月10日ValueAnimator,ofObject()学习笔记
//            ValueAnimator animator=ValueAnimator.ofObject(new FallingBallEvaluator(),
//                    new Point(0,0),new Point(500,500));
//            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    Point mCurpoint=new Point();
//                    mCurpoint= (Point) animation.getAnimatedValue();
//                    ballimg.layout(mCurpoint.x,mCurpoint.y,mCurpoint.x+ballimg.getWidth(),mCurpoint.y+ballimg.getHeight());
//                }
//            });
//            animator.setDuration(2000);
//            animator.setInterpolator(new AccelerateInterpolator());
//            animator.start();

            //-------------------------->9月10日ObjectAnimator学习demo笔记
//        ObjectAnimator animator=ObjectAnimator.ofFloat(tv,"scaleY",0,3,1);
//        animator.setDuration(2000);
//        animator.start();

            //--------------------------->9月10日ObjectAnimator ofObject学习demo
//            ObjectAnimator animator=ObjectAnimator.ofObject(ballimg,"fallingPos",new FallingBallEvaluator(),
//                    new Point(0,0),new Point(500,500));
//            animator.setDuration(2000);
//            animator.start();

            //--------------------------->9月10日ObjectAnimator ,AnimatorSet.学习demo
            ObjectAnimator tv1BgAnimator=ObjectAnimator.ofInt(tv1,"BackgroundColor"
                    ,0xffff00ff,0xffffff00,0xffff00ff);
            ObjectAnimator tv1TranslateY=ObjectAnimator.ofFloat(tv1,"translationY",0,300,0);
            ObjectAnimator tv2TranslateY=ObjectAnimator.ofFloat(tv2,"translationY",0,400,0);
            AnimatorSet animatorSet=new AnimatorSet();
//            animatorSet.playTogether(tv1BgAnimator,tv1TranslateY,tv2TranslateY);
            animatorSet.play(tv1TranslateY).with(tv2TranslateY).after(tv1BgAnimator);//after表示在after里面的动画播放完成后再进行play/play，with
            //before表示在before里面的动画播放之前进行play/play with动画.

            //添加AnimatorSet的监听器是用来监听AnimatorSet的，不监听里面添加的动画
            animatorSet.setDuration(3000);
            animatorSet.start();
        }
}
