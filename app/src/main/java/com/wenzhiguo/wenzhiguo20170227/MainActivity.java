package com.wenzhiguo.wenzhiguo20170227;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fragment;
    private TextView wode;
    private TextView quanzi;
    private TextView fenlei;
    private TextView shouye;
    private TextView[] text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(new ShouyeFragment());
        //找控件
        initView();
    }

    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        shouye = (TextView) findViewById(R.id.shouye);
        fenlei = (TextView) findViewById(R.id.fenlei);
        quanzi = (TextView) findViewById(R.id.quanzi);
        wode = (TextView) findViewById(R.id.wode);

        text = new TextView[]{shouye,fenlei,quanzi,wode};

        shouye.setOnClickListener(this);
        fenlei.setOnClickListener(this);
        quanzi.setOnClickListener(this);
        wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shouye:
                setFragment(new ShouyeFragment());
                setBackgroup(0);
                break;
            case R.id.fenlei:
                setFragment(new FenleiFragment());
                setBackgroup(1);
                break;
            case R.id.quanzi:
                setFragment(new QuanziFragment());
                setBackgroup(2);
                break;
            case R.id.wode:
                setFragment(new WodeFragment());
                setBackgroup(3);
                break;
        }
    }
    private void setFragment(Fragment f){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,f);
        fragmentTransaction.commit();
    }
    private void setBackgroup(int a) {
        for (int i = 0; i < text.length; i++) {
            if (a == i) {
                text[a].setTextColor(Color.RED);
            } else {
                text[i].setTextColor(Color.BLACK);
            }
        }
    }
}
