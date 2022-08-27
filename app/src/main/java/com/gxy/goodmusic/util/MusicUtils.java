package com.gxy.goodmusic.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.gxy.goodmusic.bean.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/27 23:09
 * @Description : 音乐扫描工具
 */
public class MusicUtils {

    /**
     * 扫描系统里面的音频文件，返回一个list集合
     */
    public static List<Song> getMusicData(Context context) {
        List<Song> list = new ArrayList<Song>();
        // 媒体库查询语句(写一个工具MusicUtils)
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Audio.Media.IS_MUSIC);
        if(cursor != null) {
            while(cursor.moveToNext()) {
                Song song = new Song();
                // 歌曲名称
                song.song = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                // 歌手
                song.singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));


            }
        }
        return list;


    }

}
