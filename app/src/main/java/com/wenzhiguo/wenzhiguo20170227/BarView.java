package com.wenzhiguo.wenzhiguo20170227;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dell on 2017/2/28.
 */

public class BarView extends View {
    private Paint paint = new Paint();
    private int count = 1;
    private RectF rectF;
    private Threads thread;
    //    private float dimension1;
//    private float dimension2;
//    private String string;
//    private int color;
//    private float dimension;

    public BarView(Context context) {
        super(context);
    }

    public BarView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init(context,attrs);
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
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 150, paint);

        paint.setColor(Color.RED);
        rectF = new RectF(getWidth() / 2-150, getHeight() / 2-150, getWidth()/2+150 ,getHeight()/2+150);
        canvas.drawArc(rectF,0,(float) (count*3.6),true,paint);

        paint.setColor(Color.YELLOW);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, paint);

        paint.setTextSize(25);
        paint.setColor(Color.BLACK);
        canvas.drawText(count + "%", getWidth() / 2 - 25, getHeight() / 2 , paint);

        if (thread == null){
            thread = new Threads();
            thread.start();
        }

//        //画笔的宽度
//        paint.setStrokeWidth(10);
//        //调试是字体
//        paint.setTextSize(200);
//        //颜色
//        paint.setColor(Color.YELLOW);
//        paint.setStyle(Paint.Style.STROKE);
//        //画圆
//        canvas.drawCircle(getWidth()/2,getHeight()/2,150,paint);
//        //空心圆
//        paint.setColor(Color.RED);
//        canvas.drawCircle(getWidth()/2,getHeight()/2,100,paint);
//        //数字转为字符串
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextSize(30);
//        String text = String.valueOf(count);
//        paint.getTextBounds(text, 0, text.length(), mBounds);
//        float textWidth = mBounds.width();
//        float textHeight = mBounds.height();
//        canvas.drawText(text, (getWidth() - textWidth) / 2, (getHeight() - textHeight) / 2, paint);
//
//        /*//画笔的颜色
//        paint.setARGB(255,count,255-count,count);
//        //矩形
//        canvas.drawRect(0,0,getHeight(),getWidth(),paint);
//        paint.setColor(Color.YELLOW);
//        画笔的锯齿
//        paint.setAntiAlias(true);
//        //画布的颜色
//        canvas.drawColor(Color.BLUE);
//        //圆
//        //canvas.drawCircle(100,100,30,paint);
//        //画圆弧
//        //canvas.drawArc(10,10,50,50,0,90,true,paint);
//        //画圆角矩形
//        //canvas.drawRoundRect(10,20,30,40,50,50,paint);
//        //椭圆
//        //canvas.drawOval(10,20,30,40,paint);
//        //画字
//        //canvas.drawText("温",200,200,paint);
//        //canvas.drawBitmap();*/
    }
    class Threads extends Thread{
        @Override
        public void run() {
            super.run();
            while(true){
                count++;
                if (count<101){
                    postInvalidate();
                }
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
