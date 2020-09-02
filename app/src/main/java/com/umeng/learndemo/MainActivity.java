package com.umeng.learndemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private  MarqueeText marqueeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marqueeText = (MarqueeText) findViewById(R.id.marqueeText);
        //设置跑马灯内容
        marqueeText.setMyContext("污渍yyds");

        //setL2r设置方向，默认为从左向右；
        marqueeText.setL2r(true);

        //设置跑马灯速度
        marqueeText.setMySpeed(5);

        //设置点击监听事件
        marqueeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
                Log.d("zt","点击一次");
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop();
    }
    public void start() {
        marqueeText.startScroll();
    }

    public void stop() {
        marqueeText.stopScroll();
    }
}