package com.umeng.learndemo;

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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
    //9月8日动画学习demo
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView tv=(TextView)findViewById(R.id.tv);
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
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.translateanim);
                animation.setInterpolator(new CycleInterpolator(1));
                tv.startAnimation(animation);
            }
        });
    }
}