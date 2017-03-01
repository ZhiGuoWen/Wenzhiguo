package com.wenzhiguo.wenzhiguo20170227;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dell on 2017/2/28.
 */

public class BarView extends View {
    private Paint paint = new Paint();

    public BarView(Context context) {
        super(context);
    }

    public BarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔的宽度
        paint.setStrokeWidth(10);
        //调试是字体
        paint.setTextSize(200);
        //画笔的颜色
        paint.setColor(Color.YELLOW);
        //画笔的锯齿
        paint.setAntiAlias(true);
        //画布的颜色
        canvas.drawColor(Color.BLUE);
        //矩形
        // canvas.drawRect(20,20,getHeight()/2,getWidth()/2,paint);
        //圆
        //canvas.drawCircle(100,100,30,paint);
        //画圆弧
        //canvas.drawArc(10,10,50,50,0,90,true,paint);
        //画圆角矩形
        //canvas.drawRoundRect(10,20,30,40,50,50,paint);
        //椭圆
        //canvas.drawOval(10,20,30,40,paint);
        //画字
        //canvas.drawText("温",200,200,paint);
        //canvas.drawBitmap();
    }
}
