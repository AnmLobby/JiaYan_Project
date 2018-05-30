package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.NewsViedeoViewHolder;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/5/8/008.
 */

public class NewsVideoAdapter extends RecyclerArrayAdapter<NewsVideoBean> {
    public NewsVideoAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViedeoViewHolder(parent);
    }
}

