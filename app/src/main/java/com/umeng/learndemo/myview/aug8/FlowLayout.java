package com.umeng.learndemo.myview.aug8;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author SpreadWater
 * @Date 2020/10/8
 * @Time 15:44
 * @description
 */
public class FlowLayout extends ViewGroup {
    int lineWidth = 0;//记录每一行的宽度
    int lineHeight = 0;//记录每一行的高度
    int height = 0;//记录整个FlowLayout的高度
    int width = 0;//记录整个FlowLayout的宽度

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        //开始计算
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.bottomMargin + lp.topMargin;

            if (lineWidth + childWidth > measureWidth) {
                //换行
                width = Math.max(lineWidth, width);
                height += lineHeight;
                //因为当前行放不下当前控件，需要换行，所以将此控件的高度和宽度的初始化给lineHeight、lineWidth
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                //不需要换行的时候
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth += childWidth;
            }
            //因为最后一行是不会超出width范围的，所以需要单独处理
            if (i == count - 1) {
                height += lineHeight;
                width = Math.max(width, lineWidth);
            }
        }
        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY) ? measureWidth : width,
                (measureHeightMode == MeasureSpec.EXACTLY) ? measureHeight : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count=getChildCount();
        int lineWidth=0;//累加当前行的宽度
        int lineHeight=0;//累加当前行的高度
        int top=0,left=0;//当前控件的left坐标和top坐标
        for (int i = 0; i <count ; i++) {
            View child=getChildAt(i);
            MarginLayoutParams lp=(MarginLayoutParams)child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.bottomMargin + lp.topMargin;

            if (childWidth+lineWidth>getMeasuredWidth()){
                //如果换行
                top+=lineHeight;
                left=0;
                lineHeight=childHeight;
                lineWidth=childWidth;
            }else{
                lineHeight=Math.max(lineHeight,childHeight);
                lineWidth+=childWidth;
            }
            //计算childView的left，top，right，bottom
            int lc=left+lp.leftMargin;
            int tc=top+lp.topMargin;
            int rc=lc+child.getMeasuredWidth();
            int bc=tc+child.getMeasuredHeight();
            child.layout(lc,tc,rc,bc);
            //将left设置为下一个子控件的起始点
            left+=childWidth;
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }
}
