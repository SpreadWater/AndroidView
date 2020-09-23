package com.umeng.learndemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Fade;
import android.util.TypedValue;
import android.view.Window;
import android.widget.RelativeLayout;
import com.umeng.learndemo.myview.spetember13.SearchView;

import com.umeng.learndemo.R;
import com.umeng.learndemo.adapter.SimpleAdapter;

public class SearchBarActivity extends AppCompatActivity {
    private SearchView mSearchView;
    private Drawable headBg ;
    private RecyclerView rv;
    private RelativeLayout rlHead;
    private int scrollY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search_bar);
        initView();
        getWindow().setEnterTransition(new Fade().setDuration(2000));
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        mSearchView= (SearchView) findViewById(R.id.activity_main_searchview);
        rlHead = (RelativeLayout) findViewById(R.id.activity_main_rlhead);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SimpleAdapter());
        headBg = rlHead.getBackground().mutate();//获取head的背景drawable
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                float fraction = calcFraction(dy);
                setBackgoundAlpha(fraction);//通过滑动来设置搜索框的容器的背景的透明度。
            }
        });

    }


    //通过滑动的距离来启动动画,并返回一个float，返回一个插值器。
    private float calcFraction(int dy){
        float imgHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, getResources().getDisplayMetrics());
        float toolbarHeight = rlHead.getHeight();
        float maxHeight = imgHeight - toolbarHeight;//滑动的最大高度
        scrollY += dy;
        //如果滑动的距离大于最大高度，也就是滑到了底
        if(scrollY>maxHeight){
            mSearchView.startAnimation(SearchView.SCROLL_HEAD_BOTTOM);
        }
        //滑动的距离为0
        if(scrollY==0){
            mSearchView.startAnimation(SearchView.SCROLL_HEAD_TOP);
        }
        if (scrollY >= maxHeight) {
            return 1.0f;//完全透明

        } else if (scrollY <= 0) {
            return 0f;
        } else {
            return scrollY/maxHeight;
        }
    }


    private void  setBackgoundAlpha(float fraction){
        //背景只需要设置透明度，255是全不透明
        headBg.setAlpha((int) (fraction*255));
    }
}