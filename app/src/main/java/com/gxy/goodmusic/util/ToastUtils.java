package com.gxy.goodmusic.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 23:07
 * @Description : 描述
 */
public class ToastUtils {
    /**
     * 长消息
     *
     * @param context 上下文参数
     * @param gxy     内容
     */
    public static void longToast(Context context, CharSequence gxy) {
        Toast.makeText(context.getApplicationContext(), gxy, Toast.LENGTH_LONG).show();
    }

    /**
     * 短消息
     *
     * @param context 上下文参数
     * @param gxy     内容
     */
    public static void shortToast(Context context, CharSequence gxy) {
        Toast.makeText(context.getApplicationContext(), gxy, Toast.LENGTH_SHORT).show();
    }

}
