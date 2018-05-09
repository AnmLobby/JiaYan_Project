package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/5/8/008.
 */

public class NewsViedeoViewHolder extends BaseViewHolder<NewsVideoBean> {
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    private TextView title,author;
    private static final String TAG = "CagViewHolder";

public NewsViedeoViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_item);
        jzVideoPlayerStandard=$(R.id.player);
        title=$(R.id.title);
        author=$(R.id.author);
        }
}