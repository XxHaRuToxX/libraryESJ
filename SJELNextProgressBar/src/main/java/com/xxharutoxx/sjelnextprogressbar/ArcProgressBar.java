package com.xxharutoxx.sjelnextprogressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.xxharutoxx.sjelnextprogressbar.utils.ShapeType;

public class ArcProgressBar extends ProgressView {
    private static final int START_ANGLE = 180;
    private int PADDING = 0;
    private float left;
    private float right;
    private RectF oval;
    private float top;
    private float bottom;
    private boolean isGradientColor;

    public ArcProgressBar(Context context) {
        super(context);
    }

    public ArcProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public ArcProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    void init() {
        oval = new RectF();
        initForegroundColor();
        initBackgroundColor();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(oval, START_ANGLE, START_ANGLE, false, backgroundPaint);
        setLinearGradientPaint();


        float angle = START_ANGLE * progress / maximum_progress;
        canvas.drawArc(oval, START_ANGLE, angle, false, foregroundPaint);
    }

    private void setLinearGradientPaint() {
        if (isGradientColor)
            setLinearGradientProgress(gradColors);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        left = 0 + strokeWidth / 2;
        top = 0 + strokeWidth / 2;
        right = min - strokeWidth / 2;
        bottom = min - strokeWidth / 2;
        oval.set(left + PADDING, top + PADDING, right - PADDING, bottom
                - PADDING);

    }

    public void setArcViewPadding(int padding) {
        PADDING = padding;
        invalidate();
    }

    public void setLinearGradientProgress(boolean isGradientColor, int[] colors) {
        this.isGradientColor = isGradientColor;
        gradColors=colors;
    }
    private void setLinearGradientProgress(int[] gradColors) {
        if(gradColors!=null)
            colorHelper.setGradientPaint(foregroundPaint, left, top, right, top,gradColors);
        else
            colorHelper.setGradientPaint(foregroundPaint, left, top, right, top);

    }
    public int getPadding() {
        return PADDING;
    }

    @Override
    public ShapeType setType(ShapeType type) {
        return ShapeType.ARC;

    }
}
