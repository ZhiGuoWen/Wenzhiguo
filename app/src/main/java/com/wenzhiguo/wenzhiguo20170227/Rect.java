package com.wenzhiguo.wenzhiguo20170227;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by dell on 2017/3/10.
 */

public class Rect extends View implements View.OnClickListener{
    private Paint paint = new Paint();
    private Random ran;
    private Threads threads;
    private boolean flag = true;
    String s = null;
    public Rect(Context context) {
        super(context);
    }

    public Rect(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(20);
        canvas.drawRect(getWidth()/2-150,getHeight()/2-150,getWidth()/2+150,getHeight()/2+150,paint);

        paint.setTextSize(30);
        paint.setColor(Color.BLACK);
        canvas.drawText("#"+s, getWidth()/2-50, getHeight()/2, paint);

        if (threads == null){
            threads = new Threads();
            threads.start();
        }
    }
    class Threads extends Thread{
        Random   ran=new Random();
        @Override
        public void run() {
            super.run();

            while(true){
                int r = ran.nextInt(256);
                int g = ran.nextInt(256);
                int b = ran.nextInt(256);
                paint.setARGB(255,r,g,b);
                //得到颜色值，转成字符串
                int color = paint.getColor();
                s = Integer.toHexString(color);
                try {
                    if (flag){
                        postInvalidate();
                    }
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (flag)
            flag = false;
        else
            flag = true;
    }
}
