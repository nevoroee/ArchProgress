package com.training.archprogress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by roeenevo on 23/10/2016.
 */

public class ArchProgressBar extends LinearLayout {

    private static final float START_ANGLE = 130;
    private static final float ARCH_LENGTH = 50;

    public ArchProgressBar(Context context) {
        super(context);
        init(context);
    }

    public ArchProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.setWillNotDraw(false);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.arch_progress_bar, this, true);

        this.postInvalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {

        float middleWidth = canvas.getWidth() / 2;
        float middleHeight = canvas.getHeight() / 2;
        float left = middleWidth - 105 * getResources().getDisplayMetrics().density;
        float top = middleHeight - 90 * getResources().getDisplayMetrics().density;
        float right = middleWidth + 105 * getResources().getDisplayMetrics().density;
        float bottom = middleHeight + 120 * getResources().getDisplayMetrics().density;

        Paint mPaintBackground = new Paint();
        mPaintBackground.setAntiAlias(true);
        mPaintBackground.setStyle(Paint.Style.STROKE);
        mPaintBackground.setStrokeWidth(35);
        mPaintBackground.setColor(Color.BLACK);

        RectF mRectF = new RectF(left, top, right, bottom);

        // draw background line
        canvas.drawArc(mRectF, START_ANGLE, ARCH_LENGTH, false, mPaintBackground);

        canvas.drawArc(mRectF, START_ANGLE + ARCH_LENGTH + 10, ARCH_LENGTH, false, mPaintBackground);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, Math.max(800, heightMeasureSpec));
    }

}