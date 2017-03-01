package com.wenzhiguo.wenzhiguo20170227;

import android.app.Application;

import org.xutils.x;

/**
 * Created by dell on 2017/2/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
