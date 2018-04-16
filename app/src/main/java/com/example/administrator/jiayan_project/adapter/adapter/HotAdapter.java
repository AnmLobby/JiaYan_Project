package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.HomeChooseViewHolder;
import com.example.administrator.jiayan_project.adapter.holder.HotViewHolder;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/4/16.
 */

public class HotAdapter extends RecyclerArrayAdapter<HotBean> {
    public HotAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotViewHolder(parent);
    }
}
