package com.gxy.goodmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gxy.goodmusic.R;
import com.gxy.goodmusic.basic.BasicActivity;
import com.gxy.goodmusic.bean.Song;
import com.gxy.goodmusic.util.BLog;

import org.litepal.LitePal;

import java.util.List;

/**
 * 主页面
 */

public class MainActivity extends BasicActivity {


    @Override
    public void initData(Bundle savedInstanceState) {
        List<Song> list = LitePal.findAll(Song.class);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void onClick(View view) {
        startActivity(new Intent(context, LocalMusicActivity.class));
    }
}