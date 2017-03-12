package com.wenzhiguo.wenzhiguo20170227;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dell on 2017/2/28.
 */

public class Image extends ImageView {
    private Paint paint = new Paint();
    private int progress;
    private Rect rect;

    public Image(Context context) {
        super(context);
    }

    public Image(Context context, AttributeSet attrs) {
        super(context, attrs);
        inintPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void inintPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.save();
        // canvas.translate(300,300);
        //画笔颜色
        paint.setColor(Color.parseColor("#70000000"));
        //背景颜色改变
        canvas.drawRect(0, 0, getWidth(), getHeight() - getHeight() * progress / 100, paint);
        //覆盖之前颜色
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        if (progress < 100) {
            rect = new Rect();
            paint.getTextBounds("00%", 0, "00%".length(), rect);
            canvas.drawText(progress + "%", getWidth() / 2 - (rect.width() / 2), getHeight() / 2, paint);
        } else {
            canvas.drawText("", getWidth() / 2, getHeight() / 2, paint);
        }
        canvas.restore();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }
}

