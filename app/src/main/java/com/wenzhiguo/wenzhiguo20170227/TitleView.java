package com.wenzhiguo.wenzhiguo20170227;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by dell on 2017/2/27.
 */

public class TitleView extends RelativeLayout {
    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.titleview, this, true);
//        View view = inflate(context,R.layout.titleview,null);
        ImageView image= (ImageView) view.findViewById(R.id.title_image);
        Button btn =(Button) view.findViewById(R.id.title_button);
        TextView text = (TextView) view.findViewById(R.id.title_text);

        TypedArray typedArray = context.getResources().obtainAttributes(attrs, R.styleable.titleBar);
        if (typedArray != null){
            int color = typedArray.getColor(R.styleable.titleBar_btn_backgroup, Color.WHITE);
            btn.setBackgroundColor(color);
            Drawable drawable = typedArray.getDrawable(R.styleable.titleBar_img_imageView);
            image.setImageDrawable(drawable);
            String string = typedArray.getString(R.styleable.titleBar_text_textView);
            text.setText(string);
        }
        typedArray.recycle();
    }
}
