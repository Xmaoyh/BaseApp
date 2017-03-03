package com.maoyihan.www.kobe.base;

import android.app.Application;
import android.content.Context;

/** 应用程序实体
 * Created by Administrator on 2016/9/15.
 */
public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        context = getApplicationContext();
    }
}
