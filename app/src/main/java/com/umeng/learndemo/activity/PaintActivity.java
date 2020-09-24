package com.umeng.learndemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;

import com.umeng.learndemo.R;
import com.umeng.learndemo.myview.spetember14.ShadowLayerView;

/*
    用于记录Paint方面的学习的demo
 */
public class PaintActivity extends AppCompatActivity {
    //    private ShadowLayerView mShadowLayerView;
//    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
//        btn=(Button)findViewById(R.id.btn_fade);
//        mShadowLayerView=(ShadowLayerView)findViewById(R.id.shadowlayerview);
//        findViewById(R.id.clear_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mShadowLayerView.setmSetShadow(false);
//            }
//        });
//        findViewById(R.id.show_btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mShadowLayerView.setmSetShadow(true);
//            }
//        });
//    }
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(PaintActivity.this,SearchBarActivity.class),
//                        ActivityOptions.makeSceneTransitionAnimation(PaintActivity.this).toBundle());
//                getWindow().setEnterTransition(new Fade().setDuration(2000));
////            getWindow().setExitTransition(new Slide().setDuration(2000));
//            }
//        });
    }
}