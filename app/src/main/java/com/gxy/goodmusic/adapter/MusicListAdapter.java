package com.gxy.goodmusic.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gxy.goodmusic.R;
import com.gxy.goodmusic.bean.Song;
import com.gxy.goodmusic.util.DateTimeUtils;

import java.util.List;

/**
 * @ProjectName : GoodMusic
 * @Author : Victor Scott
 * @Time : 2022/8/28 9:03
 * @Description : 描述
 */
public class MusicListAdapter extends BaseQuickAdapter<Song, BaseViewHolder> {

    public MusicListAdapter(int layoutResId, @Nullable List<Song> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Song item) {
        // 给控件赋值
        int duration = item.duration;
        String time = DateTimeUtils.formatTime(duration);

        // 歌曲名称
        helper.setText(R.id.tv_song_name, item.getSong().trim())
                // 歌手 - 专辑
                .setText(R.id.tv_singer, item.getSinger() + " - " + item.getAlbum())
                // 歌曲时间
                .setText(R.id.tv_duration_time, time)
                //歌曲序号，因为getAdapterPosition得到的位置是从0开始，故而加1，
                //是因为位置和1都是整数类型，直接赋值给TextView会报错，故而拼接了""
                .setText(R.id.tv_position, helper.getAdapterPosition() + 1 + "");

        // 给item添加点击事件，点击后传递数据到播放页面或者在本页面进行音乐播放
        helper.addOnClickListener(R.id.item_music);

        // 点击后改变文字颜色
        if (item.isCheck()) {
            helper.setTextColor(R.id.tv_position, mContext.getColor(R.color.gold_color))
                    .setTextColor(R.id.tv_song_name, mContext.getColor(R.color.gold_color))
                    .setTextColor(R.id.tv_singer, mContext.getColor(R.color.gold_color))
                    .setTextColor(R.id.tv_duration_time, mContext.getColor(R.color.gold_color));
        } else {
            helper.setTextColor(R.id.tv_position, mContext.getColor(R.color.white))
                    .setTextColor(R.id.tv_song_name, mContext.getColor(R.color.white))
                    .setTextColor(R.id.tv_singer, mContext.getColor(R.color.white))
                    .setTextColor(R.id.tv_duration_time, mContext.getColor(R.color.white));
        }
    }

    /**
     * 刷新数据
     */
    public void changeState() {
        notifyDataSetChanged();
    }


}
