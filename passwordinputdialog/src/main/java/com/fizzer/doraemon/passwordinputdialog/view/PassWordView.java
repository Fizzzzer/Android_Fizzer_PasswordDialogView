package com.fizzer.doraemon.passwordinputdialog.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.fizzer.doraemon.passwordinputdialog.impl.PassWordCompleteListener;
import com.fizzer.doraemon.passwordinputdialog.utils.Utils;

/**
 * Created by Fizzer on 2017/4/18.
 * Email: doraemonmqq@sina.com
 */

public class PassWordView extends View {

    private Paint mPaint;
    private Path mPath;
    private Paint mPointPaint;
    private PassWordCompleteListener mListener;

    //密码框边界线的颜色值
    private int STROKE_COLOR = Color.parseColor("#666666");

    //需要的密码个数
    private int pswNum = 6;

    //单个密码框的高度
    private int item_W = 44;

    private int item_H = 41;

    //中心黑点的半径大小
    private int POINT_RADIUS = 15;

    //中心黑点的颜色
    private int POINT_COLOR = Color.parseColor("#000000");

    //已经输入的密码个数，也就是需要显示的小黑点个数
    private int mIndex = 0;

    public PassWordView(Context context) {
        super(context);
        init(context);
    }

    public PassWordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PassWordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureW(widthMeasureSpec);
        int height = measureH(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    private int measureW(int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else {
            return item_W * pswNum;
        }
    }

    private int measureH(int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else {
            return item_H;
        }
    }

    /**
     * 初始化
     */
    private void init(Context context) {

        item_W = Utils.Dp2Px(context, item_W);
        item_H = Utils.Dp2Px(context, item_H);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);  //设置抗锯齿
        mPaint.setColor(STROKE_COLOR);  //设置颜色
        mPaint.setStyle(Paint.Style.STROKE);    //设置描边

        mPath = new Path();
        mPath.moveTo(0, 0);
        mPath.lineTo(item_W * pswNum, 0);
        mPath.lineTo(item_W * pswNum, item_H);
        mPath.lineTo(0, item_H);
        mPath.close();

        mPointPaint = new Paint();
        mPointPaint.setAntiAlias(true);
        mPointPaint.setStyle(Paint.Style.FILL);
        mPointPaint.setColor(POINT_COLOR);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setStrokeWidth(5);
        canvas.drawPath(mPath, mPaint);

        drawDivide(canvas);
        drawBlackPoint(canvas);
    }

    /**
     * 画单个的分割线
     *
     * @param canvas
     */
    private void drawDivide(Canvas canvas) {
        mPaint.setStrokeWidth(3);
        for (int index = 1; index < pswNum; index++) {
            canvas.drawLine(item_W * index, 0, item_W * index, item_H, mPaint);
        }
    }

    /**
     * 绘制中间的小黑点
     *
     * @param canvas
     */
    private void drawBlackPoint(Canvas canvas) {
        if (mIndex == 0) {
            return;
        }
        for (int i = 1; i <= mIndex; i++) {
            canvas.drawCircle(i * item_W - item_W / 2, item_H / 2, POINT_RADIUS, mPointPaint);
        }
    }

    /**
     * 改变密码提示小黑点的个数
     *
     * @param index
     */
    public void setPassWord(int index) {
        mIndex = index;
        invalidate();
        if (index == pswNum && mListener != null) {
            mListener.complete();
        }
    }

    /**
     * 设置密码填写完成的监听
     *
     * @param listener
     */
    public void setCompleteListener(PassWordCompleteListener listener) {
        mListener = listener;
    }
}
