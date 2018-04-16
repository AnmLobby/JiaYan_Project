package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.HomeChooseViewHolder;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by 鱼握拳 on 2018/4/16.
 */

public class HomeChooseAdapter extends RecyclerArrayAdapter<FirstChooseBean> {
    public HomeChooseAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeChooseViewHolder(parent);
    }
}
