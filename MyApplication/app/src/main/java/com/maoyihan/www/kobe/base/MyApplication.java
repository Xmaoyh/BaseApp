package com.maoyihan.www.kobe.base;

import android.app.Application;
import android.content.Context;

/** 应用程序实体
 * Created by Administrator on 2016/9/15.
 */
public class MyApplication extends Application {
    private static MyApplication app;

    @Override
    public void onCreate() {
         super.onCreate(); 
         app = this;  
    }

    public static MyApplication getInstance() {  
          return app;  
       }  
}
