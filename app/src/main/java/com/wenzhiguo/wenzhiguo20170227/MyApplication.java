package com.wenzhiguo.wenzhiguo20170227;

import android.app.Activity;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.ViewInjector;
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
        ViewInjector viewInjector = new ViewInjector() {
            @Override
            public void inject(View view) {

            }

            @Override
            public void inject(Activity activity) {

            }

            @Override
            public void inject(Object handler, View view) {

            }

            @Override
            public View inject(Object fragment, LayoutInflater inflater, ViewGroup container) {
                return null;
            }
        };

        x.Ext.setViewInjector(viewInjector);
    }
}
