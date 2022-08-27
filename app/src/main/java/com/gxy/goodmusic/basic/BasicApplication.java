package com.gxy.goodmusic.basic;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 9:28
 * @Description :  工程管理
 */
public class BasicApplication extends Application {
    private static ActivityManager activityManager;
    private static BasicApplication application;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        //声明Activity管理
        activityManager = new ActivityManager();
        context = getApplicationContext();
        application = this;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public static ActivityManager getActivityManager() {
        return activityManager;
    }

    public static BasicApplication getApplication() {
        return application;
    }

    public static Context getContext() {
        return context;
    }
}
