package com.umeng.learndemo.Evaluator;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * @author zhangsan
 * @date
 * @description
 */
public class FallingBallEvaluator implements TypeEvaluator<Point> {
    private Point point=new Point();
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        point.x=(int)(startValue.x+fraction*(endValue.x-startValue.x));
//        抛体运动的y具有的关系是
        if (fraction<=0.5){
            point.y=(int)(startValue.y+fraction*2*(endValue.y-startValue.y));
        }else{
            point.y=endValue.y;
        }
        return point;
    }
}
