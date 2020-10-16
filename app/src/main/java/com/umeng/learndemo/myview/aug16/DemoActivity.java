package com.umeng.learndemo.myview.aug16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.umeng.learndemo.R;

public class DemoActivity extends AppCompatActivity {
    private TitleBar mTitleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mTitleBar=(TitleBar)this.findViewById(R.id.title);
        mTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DemoActivity.this, "点击左边返回", Toast.LENGTH_SHORT).show();
            }
        });
        mTitleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DemoActivity.this, "点击右键返回", Toast.LENGTH_SHORT).show();
            }
        });
    }
}