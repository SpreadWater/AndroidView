package com.umeng.learndemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.umeng.learndemo.R;

/**
 * @author zhangsan
 * @date
 * @description AnimastorSet动画demo
 */
public class PathMenuActivity extends AppCompatActivity {
    private Button mItemButton1;
    private Button mItemButton2;
    private Button mItemButton3;
    private Button mItemButton4;
    private Button mItemButton5;
    private Button menu;
    private boolean mIsMenuOpen=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_menu);
        init();
        Event();
    }
    private void Event(){
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsMenuOpen){
                    mIsMenuOpen=true;
                    openMenu();
                }else{
                    Toast.makeText(PathMenuActivity.this, "你单击了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen=false;
                    closeMenu();
                }
            }
        });
    }
    private void init(){
        mItemButton1=(Button)findViewById(R.id.item1);
        mItemButton2=(Button)findViewById(R.id.item2);
        mItemButton3=(Button)findViewById(R.id.item3);
        mItemButton4=(Button)findViewById(R.id.item4);
        mItemButton5=(Button)findViewById(R.id.item5);
        menu=(Button)findViewById(R.id.menu);
    }
    //该函数用于实现将每个按钮从初始位置移动到对应位置
    private void doAnimateOpen(View view,int index,int total,int radius){
        if (view.getVisibility()!=View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }
        double degree=Math.toRadians(90)/(total-1)*index;//计算出每个按钮移动的角度
        int translationX=-(int)(radius*Math.sin(degree));
        int translationY=-(int)(radius*Math.cos(degree));
        AnimatorSet set=new AnimatorSet();
        //包含平移，缩放，透明度的动画
        set.playTogether(ObjectAnimator.ofFloat(view,"translationX",0,translationX),
                ObjectAnimator.ofFloat(view,"translationY",0,translationY),
                ObjectAnimator.ofFloat(view,"scaleX",0f,1f),
                ObjectAnimator.ofFloat(view,"scaleY",0f,1f),
                ObjectAnimator.ofFloat(view,"alpha",0f,1));
        set.setDuration(500).start();
    }
    //该函数用于实现关闭每个按钮动画，也就是回到之前的对应位置
    private void doAnimateClose(final View view,int index,int total,int radius){
        if (view.getVisibility()!=View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }
        double degree=Math.toRadians(90)/(total-1)*index;
        int translationX=-(int)(radius*Math.sin(degree));
        int translationY=-(int)(radius*Math.cos(degree));
        AnimatorSet set=new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view,"translationX",translationX,0),
                ObjectAnimator.ofFloat(view,"translationY",translationY,0),
                ObjectAnimator.ofFloat(view,"scaleX",1f,0.1f),
                ObjectAnimator.ofFloat(view,"scaleY",1f,0.1f),
                ObjectAnimator.ofFloat(view,"alpha",1f,0f));
        set.setDuration(500).start();
    }
    private void openMenu(){
        doAnimateOpen(mItemButton1,0,5,300);
        doAnimateOpen(mItemButton2,1,5,300);
        doAnimateOpen(mItemButton3,2,5,300);
        doAnimateOpen(mItemButton4,3,5,300);
        doAnimateOpen(mItemButton5,4,5,300);
    }
    private void  closeMenu(){
        doAnimateClose(mItemButton1,0,5,300);
        doAnimateClose(mItemButton2,1,5,300);
        doAnimateClose(mItemButton3,2,5,300);
        doAnimateClose(mItemButton4,3,5,300);
        doAnimateClose(mItemButton5,4,5,300);
    }
}
