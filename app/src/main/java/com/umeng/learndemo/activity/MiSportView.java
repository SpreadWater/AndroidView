package com.umeng.learndemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.SweepGradient;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.umeng.learndemo.R;

import static com.umeng.learndemo.utils.Utils.dpToPixel;
/*
    一款仿小米运动的自定义view，其中绘制烟花值得学习。9月13日写
 */
public class MiSportView extends AppCompatActivity {

    private Button mButton;
    private Bitmap baseBitmap;
    private Canvas canvas;
    private ImageView mImageView;

    float centerX, centerY;

    private ValueAnimator mAnimator;
    private float mCurrentValue;
    private ValueAnimator mAnimator2;
    private float mCurrentValue2;

    final float radius = dpToPixel(120);

    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint6 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint7 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint8 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint9 = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float[] mPos;
    private float[] mTan;

    private PathMeasure mPathMeasure;
    SweepGradient mSWeepGradient1;
    SweepGradient mSWeepGradient2;
    private Path mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_sport_view);
        setView();
        setAnimator();
        init();
    }


    private void setView() {
        mImageView = (ImageView) findViewById(R.id.mImageView);
        mButton = (Button) findViewById(R.id.mButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseBitmap = Bitmap.createBitmap(mImageView.getWidth(), mImageView.getHeight(), Bitmap.Config.ARGB_8888);
                canvas = new Canvas(baseBitmap);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(mAnimator, mAnimator2);
                animatorSet.start();
            }
        });
    }


    private void setAnimator() {
        mAnimator = ValueAnimator.ofFloat(0, 1);
        mAnimator.setDuration(2000);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurrentValue = (float) valueAnimator.getAnimatedValue();
                initFirstView();
            }
        });
        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //清空画布
                resumeCanvas();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mAnimator2 = ValueAnimator.ofFloat(1, 0);
        mAnimator2.setDuration(500);
        mAnimator2.setInterpolator(new AccelerateInterpolator());
        mAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mCurrentValue2 = (float) valueAnimator.getAnimatedValue();
                initSecondView();
            }
        });
        mAnimator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //一个圆点，一条虚线圆弧，一条实线圆弧
                PathEffect pathEffect = new DashPathEffect(new float[]{5, 10}, 5);
                paint7.setStrokeWidth(dpToPixel(2));
                paint7.setStyle(Paint.Style.STROKE);
                paint7.setColor(Color.WHITE);

                //实线
                canvas.drawArc(120, 328, 600, 808, -90, 270, false, paint7);

                paint7.setStyle(Paint.Style.FILL);
                canvas.drawCircle(120, 568, dpToPixel(4), paint7);

                //虚线
                paint9.setPathEffect(pathEffect);

                canvas.drawArc(120, 328, 600, 808, 180, 90, false, paint9);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


    private void init() {
        mPath = new Path();
        mPos = new float[2];
        mTan = new float[2];

        mPath.addCircle(0, 0, radius, Path.Direction.CW);
        mPathMeasure = new PathMeasure();
        mPathMeasure.setPath(mPath, false);

        mSWeepGradient1 = new SweepGradient(0, 0, Color.parseColor("#00ffffff"), Color.parseColor("#50ffffff"));
        paint1.setShader(mSWeepGradient1);
        paint1.setShadowLayer(20, 0, 0, Color.parseColor("#aaffffff"));
        paint1.setColor(Color.WHITE);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(dpToPixel(2));

        mSWeepGradient2 = new SweepGradient(0, 0, Color.parseColor("#00ffffff"), Color.parseColor("#32ffffff"));
        paint2.setShader(mSWeepGradient2);
        paint2.setShadowLayer(20, 0, 0, Color.parseColor("#aaffffff"));
        paint2.setColor(Color.WHITE);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(dpToPixel(2));

        paint3.setColor(Color.parseColor("#bbffffff"));
        paint4.setColor(Color.parseColor("#32ffffff"));

        paint6.setColor(Color.WHITE);
        paint6.setStrokeWidth(dpToPixel(12));
        paint6.setStyle(Paint.Style.STROKE);

        paint8.setColor(Color.parseColor("#3497e8"));
        paint8.setStrokeWidth(dpToPixel(6));
        paint8.setStyle(Paint.Style.STROKE);


        paint9.setStrokeWidth(dpToPixel(2));
        paint9.setColor(Color.WHITE);
        paint9.setStyle(Paint.Style.STROKE);

    }

    //画第一阶段的动画
    private void initFirstView() {
        canvas.drawColor(Color.parseColor("#3497e8"));

        centerX = mImageView.getWidth() / 2;
        centerY = mImageView.getHeight() / 2;

        mPathMeasure.getPosTan(mCurrentValue * mPathMeasure.getLength(), mPos, mTan);
        float degree = (float) (Math.atan2(mTan[1], mTan[0]) * 180 / Math.PI);


        canvas.save();
        canvas.translate(centerX, centerY);

        //画烟花
        canvas.drawCircle(mPos[0], mPos[1], 4, paint3);
        canvas.drawCircle(mPos[0] - 7, mPos[1], 4, paint3);

        canvas.drawCircle(mPos[0] - 7, mPos[1] - 12, 4, paint3);
        canvas.drawCircle(mPos[0] + 7, mPos[1] - 12, 4, paint3);


        canvas.drawCircle(mPos[0] - 7, mPos[1] - 25, 4, paint3);
        canvas.drawCircle(mPos[0] + 14, mPos[1] - 25, 4, paint3);

        canvas.drawCircle(mPos[0] - 14, mPos[1] - 36, 4, paint4);
        canvas.drawCircle(mPos[0] + 30, mPos[1] - 36, 4, paint4);

        drawCenter();

        //画圆圈
        canvas.rotate(degree - 90);
        canvas.drawCircle(0, 0, radius, paint2);
        canvas.drawCircle(0, 0, radius - 5, paint1);
        canvas.drawCircle(0, 0, radius - 8, paint1);
        canvas.drawCircle(0, 0, radius - 13, paint2);
        canvas.restore();

        mImageView.setImageBitmap(baseBitmap);

    }


    //画第二阶段的动画
    private void initSecondView() {
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.drawCircle(0, 0, dpToPixel(140) + mCurrentValue2 * 30 + 12, paint8);
        canvas.drawCircle(0, 0, dpToPixel(140) + mCurrentValue2 * 30, paint6);
        drawCenter();
        canvas.restore();
        mImageView.setImageBitmap(baseBitmap);

    }

    //画中间的文字和手表
    private void drawCenter() {
        paint5.setColor(Color.WHITE);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setTextSize(100);
        paint5.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("2274", 0, 0 - (paint5.ascent() + paint5.descent()) / 2, paint5);
        paint5.setTextSize(20);
        canvas.drawText("1.5公里  |  34千卡", 0, 0 + 80, paint5);
        canvas.drawRect(0 - 7, 0 + 130, 0 + 7, 0 + 135, paint5);
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(dpToPixel(1));
        canvas.drawCircle(0, 135 + 15, 15, paint5);
        canvas.drawLine(0, 135 + 15, 0, 135 + 5, paint5);
        canvas.drawLine(0, 135 + 15, 0 + 10, 135 + 15, paint5);
        paint5.setStyle(Paint.Style.FILL);
        canvas.drawRect(0 - 7, 135 + 30, 0 + 7, 135 + 35, paint5);


    }

    //清除画布
    private void resumeCanvas() {
        if (baseBitmap != null) {
            baseBitmap = Bitmap.createBitmap(mImageView.getWidth(), mImageView.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(baseBitmap);
            canvas.drawColor(Color.parseColor("#3497e8"));
            mImageView.setImageBitmap(baseBitmap);
        }

    }
}