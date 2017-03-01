package com.wenzhiguo.wenzhiguo20170227;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShouyeFragment extends Fragment {
    private int progress = 0 ;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (progress == 100){
                return;
            }
            progress++;
            image.setProgress(progress);
            handler.sendEmptyMessageDelayed(0,100);
        }
    };
    private Image image;

    public ShouyeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shouye, container, false);

        image = (Image) inflate.findViewById(R.id.image_view);

        handler.sendEmptyMessageDelayed(0,100);

        return inflate;
    }

}
