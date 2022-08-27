package com.gxy.goodmusic.basic;

import android.app.Activity;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 9:22
 * @Description : 管理所有的Activity
 */
public class ActivityManager {
    /**
     * 保存所有创建的Activity
     */
    private List<Activity> allActivities = new ArrayList<>();

    /**
     * 添加Activity到管理器
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activity != null) {
            allActivities.add(activity);
        }
    }

    /**
     * 从管理器中移除Activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            allActivities.remove(activity);
        }
    }

    /**
     * 关闭所有Activity
     */
    public void finishAll() {
        for (Activity activity : allActivities) {
            activity.finish();
        }
    }

    /**
     * 获取栈顶的Activity
     * @return
     */
    public Activity getTaskTop() {
        return allActivities.get(allActivities.size() - 1);
    }



}
