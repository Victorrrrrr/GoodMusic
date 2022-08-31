package com.gxy.goodmusic;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.gxy.goodmusic.basic.ActivityManager;
import com.gxy.goodmusic.basic.BasicApplication;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.permissionx.guolindev.request.ForwardScope;

import org.litepal.LitePal;

import java.util.List;
import java.util.logging.Handler;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 10:53
 * @Description : 描述
 */
public class MusicApplication extends BasicApplication {

    /**
     * 应用实例
     */
    public static MusicApplication musicApplication;
    private static Context context;
    private static ActivityManager activityManager;

    public static Context getContext() {
        return musicApplication == null ? null : musicApplication.getApplicationContext();
    }

    private Handler myHandler;
    public Handler getMyHandler() {
        return myHandler;
    }

    public void setMyHandler(Handler handler) {
        myHandler = handler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activityManager = new ActivityManager();
        context = getApplicationContext();
        musicApplication = this;
        // 初始化
        LitePal.initialize(this);
    }

    public static ActivityManager getActivityManger() {
        return activityManager;
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }




}
