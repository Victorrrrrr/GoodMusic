package com.gxy.goodmusic.basic;

import android.os.Bundle;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 9:40
 * @Description : 描述
 */
public interface UiCallBack {

    /**
     * 初始化savedInstanceState
     *
     * @param savedInstanceState
     */
    void initBeforeView(Bundle savedInstanceState);


    /**
     * 初始化数据 相当于onCreate
     *
     * @param savedInstanceState
     */
    void initData(Bundle savedInstanceState);

    /**
     * 绑定布局
     *
     * @return
     */
    int getLayoutId();

}
