package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/5/7/007.
 */

public class NewsViewHolder  extends BaseViewHolder<NewsDetailBean> {
    private ImageView imageView;
    private TextView title,author;
    private static final String TAG = "CagViewHolder";

    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_item);
        imageView=$(R.id.image);
        title=$(R.id.title);
        author=$(R.id.author);
    }
}