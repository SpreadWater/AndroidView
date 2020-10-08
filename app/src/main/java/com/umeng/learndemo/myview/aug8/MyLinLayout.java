package com.umeng.learndemo.myview.aug8;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author SpreadWater
 * @Date 2020/10/8
 * @Time 14:37
 * @description
 */
public class MyLinLayout extends ViewGroup {

    public MyLinLayout(Context context) {
        super(context);
    }

    public MyLinLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int height = 0;
        int width = 0;
        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            //测量子控件
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //获得子控件的高度和宽度
            MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();

            int childHeight = child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
            int childWideth = child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;
            //得到最大宽度，并且累加高度
            height += childHeight;
            width = Math.max(childWideth, width);
        }
        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY) ? measureWidth : width,
                (measureHeightMode == MeasureSpec.EXACTLY) ? measureHeight : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child=getChildAt(i);

            MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();

            int childHeight=child.getMeasuredHeight()+lp.topMargin+lp.bottomMargin;
            int chlidWidth=child.getMeasuredWidth()+lp.leftMargin+lp.rightMargin;

            child.layout(0,top,chlidWidth,top+childHeight);
            top+=childHeight;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        return new MarginLayoutParams(lp);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}
