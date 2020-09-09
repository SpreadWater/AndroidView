package com.umeng.learndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class CameraStretchDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        //---------9月8日图片弹簧伸缩demo

//        ImageView imageView=(ImageView)findViewById(R.id.img);
////        ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,1.2f,1.0f,1.2f, Animation.RELATIVE_TO_SELF,0.5f,
////                Animation.RELATIVE_TO_SELF,0.5f);
////        scaleAnimation.setDuration(6000);
////        scaleAnimation.setFillAfter(true);
////        scaleAnimation.setInterpolator(new BounceInterpolator());
////        imageView.startAnimation(scaleAnimation);

        //------------9月8日加载框效果
//        ImageView imageView=(ImageView)findViewById(R.id.loading);
//        RotateAnimation rotateAnim=new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,
//                Animation.RELATIVE_TO_SELF,0.5f);
//        rotateAnim.setRepeatCount(Animation.INFINITE);//一直重复
//        rotateAnim.setDuration(2000);
//        rotateAnim.setInterpolator(new LinearInterpolator());//匀速旋转
//        imageView.startAnimation(rotateAnim);

        //------------9月8日扫描动画，点击时，imageview间隔做动画
//        final  Animation animation1= AnimationUtils.loadAnimation(CameraStretchDemo.this,R.anim.scale_alpha_anim);
////        final  Animation animation2= AnimationUtils.loadAnimation(CameraStretchDemo.this,R.anim.scale_alpha_anim);
////        final  Animation animation3= AnimationUtils.loadAnimation(CameraStretchDemo.this,R.anim.scale_alpha_anim);
////        final  Animation animation4= AnimationUtils.loadAnimation(CameraStretchDemo.this,R.anim.scale_alpha_anim);
////
////
////        final ImageView circle1=(ImageView)findViewById(R.id.cicle1);
////        final ImageView circle2=(ImageView)findViewById(R.id.cicle2);
////        final ImageView circle3=(ImageView)findViewById(R.id.cicle3);
////        final ImageView circle4=(ImageView)findViewById(R.id.cicle4);
////
////        findViewById(R.id.start_can).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                circle1.startAnimation(animation1);
////                animation2.setStartOffset(600);
////                circle2.startAnimation(animation2);
////                animation3.setStartOffset(1200);
////                circle3.startAnimation(animation3);
////                animation4.setStartOffset(1800);
////                circle4.startAnimation(animation4);
////            }
////        });

        //------------------->9月9日逐帧动画
            ImageView image=(ImageView)findViewById(R.id.frame_image);
            final AnimationDrawable anim=new AnimationDrawable();
            for (int i=1;i<=14;i++){
                int id=getResources().getIdentifier("list_icon_gif_playing"+i,"drawable",getPackageName());
                Drawable drawable=getResources().getDrawable(id);
                anim.addFrame(drawable,60);
            }
            anim.setOneShot(false);
            image.setBackground(anim);
            anim.start();
    }
}
