package com.gxy.goodmusic.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.gxy.goodmusic.R;
import com.gxy.goodmusic.databinding.ActivityLocalMusicBinding;
import com.gxy.goodmusic.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    /**
     * 位移动画
     * @param savedInstanceState
     */
    private TranslateAnimation translateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();

    }

    private void initView() {
        ActivitySplashBinding binding = DataBindingUtil.setContentView(SplashActivity.this, R.layout.activity_splash);
        TextView tvTranslate = binding.tvTranslate;

        /**
         * post方法的作用：
         * 1.在子线程中更新UI。从子线程中切换到主线程更新UI，不需要额外new一个Handler实例来实现。
         * 2.获取View的宽高等属性值。在Activity的onCreate()、onStart()、onResume()等方法中调用View.getWidth()等方法时会返回0，
         * 而通过post方法却可以解决这个问题。
         *
         */
        tvTranslate.post(() -> {
            // 通过post拿到的tvTranslate.getWith()不会为0
            translateAnimation = new TranslateAnimation(0, tvTranslate.getWidth(), 0, 0);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            tvTranslate.startAnimation(translateAnimation);

            // 动画监听
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        });



    }
}