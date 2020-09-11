package com.umeng.learndemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.umeng.learndemo.R;
import com.umeng.learndemo.myview.WaterWaveView;

/**
 * @author zhangsan
 * @date
 * @description
 */
public class WaterViewActivity extends AppCompatActivity {

    private WaterWaveView waterWaveView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterview);
        waterWaveView = (WaterWaveView) findViewById(R.id.waterview);
        waterWaveView.setmWaterLevel(0.5F);
        waterWaveView.startWave();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        waterWaveView.stopWave();
        waterWaveView=null;
    }
}
