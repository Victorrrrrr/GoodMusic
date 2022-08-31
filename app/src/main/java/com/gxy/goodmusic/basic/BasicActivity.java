package com.gxy.goodmusic.basic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 9:48
 * @Description : 基础Activity
 */
public abstract class BasicActivity extends AppCompatActivity implements UiCallBack {

    /**
     * 快速点击的时间间隔
     */
    private static final int FAST_CLICK_DELAY_TIME = 500;

    /**
     * 最后点击的时间
     */
    private static long lastClickTime;

    /**
     * 上下文参数
     */
    protected Activity context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeView(savedInstanceState);
        this.context = this;

        //添加继承这个BasicActivity的Activity
        BasicApplication.getActivityManager().addActivity(this);
        //绑定布局id
        if(getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        //初始化数据
        initData(savedInstanceState);
    }

    @Override
    public void initBeforeView(Bundle savedInstanceState) {

    }

    /**
     * 返回
     *
     * @param toolbar
     */
    protected void Back(Toolbar toolbar) {
        toolbar.setNavigationOnClickListener(view -> {
            context.finish();
            if(!isFastClick()) {
                context.finish();
            }
        });
    }

    /**
     * 两次点击间隔不能少于500ms   防止多次点击
     *
     * @return flag
     */
    protected static boolean isFastClick() {
        boolean flag = true;
        long currentClickTime = System.currentTimeMillis();
        if((currentClickTime - lastClickTime) >= FAST_CLICK_DELAY_TIME) {
            flag = false;
        }
        lastClickTime = currentClickTime;

        return false;
    }

    /**
     * 消息提示
     *
     * @param gxy
     */
    protected void show(CharSequence gxy) {
        Toast.makeText(context, gxy, Toast.LENGTH_SHORT).show();
    }

}
