package com.maoyihan.www.kobe.utils;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.widget.LinearLayout;

import java.lang.reflect.Field;


/**
 * Created by DiWenqiang on 2017/6/12.
 */

public class TabLayoutUtils {

    public static void setIndicator(Context context, TabLayout tabs, double leftDip, double rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        int left = (int) (getDisplayMetrics(context).density * leftDip);
//        int right = (int) (getDisplayMetrics(context).density * rightDip);
//    public static DisplayMetrics getDisplayMetrics(Context context) {
//        DisplayMetrics metric = new DisplayMetrics();
//        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
//        return metric;
//    }

//        for (int i = 0; i < ll_tab.getChildCount(); i++) {
//            View child = ll_tab.getChildAt(i);
//            child.setPadding(0, 0, 0, 0);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
//            params.leftMargin = left;
//            params.rightMargin = right;
//            child.setLayoutParams(params);
//            child.invalidate();
//        }
    }

}