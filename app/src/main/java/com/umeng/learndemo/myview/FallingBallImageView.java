package com.umeng.learndemo.myview;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

/**
 * @author zhangsan
 * @date
 * @description //ObjectAnimator自定义view
 */
class FallingBallImageView extends androidx.appcompat.widget.AppCompatImageView {
    public FallingBallImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setFallingPos(Point pos) {
        layout(pos.x, pos.y, pos.x + getWidth(), pos.y + getHeight());
    }
}
