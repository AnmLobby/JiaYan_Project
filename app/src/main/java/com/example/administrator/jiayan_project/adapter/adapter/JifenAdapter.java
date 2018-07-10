package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.JifenShopViewHolder;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/4/25.
 */

public class JifenAdapter extends RecyclerArrayAdapter<JifenMainBean.IntegralBean> {
    public JifenAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new JifenShopViewHolder(parent);
    }
}
