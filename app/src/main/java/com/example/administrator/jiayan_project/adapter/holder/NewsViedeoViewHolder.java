package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/5/8/008.
 */

public class NewsViedeoViewHolder extends BaseViewHolder<NewsVideoBean.DataBean> {
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    private TextView title,author,cliclnum;
    private static final String TAG = "CagViewHolder";

public NewsViedeoViewHolder(ViewGroup parent) {
        super(parent, R.layout.video_item);
        jzVideoPlayerStandard=$(R.id.player);
        title=$(R.id.title);
        author=$(R.id.author);
        cliclnum=$(R.id.clicknum);
        }

    @Override
    public void setData(final NewsVideoBean.DataBean data) {
        super.setData(data);
        title.setText(data.getNewstitle());
        author.setText("文章作者："+data.getNewsauthor());
        cliclnum.setText(data.getClick()+"人浏览过");
        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+data.getNewsimg())
                .centerCrop()
                .into(jzVideoPlayerStandard.thumbImageView);
//        jzVideoPlayerStandard.setUp(data.getNewsvideo(),jzVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
    }
}