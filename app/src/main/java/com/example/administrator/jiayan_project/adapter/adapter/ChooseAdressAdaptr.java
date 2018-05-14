package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.ChoorseAddressViewHolder;
import com.example.administrator.jiayan_project.adapter.holder.NewsViewHolder;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.enity.news.NewsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/5/14/014.
 */

public class ChooseAdressAdaptr  extends RecyclerArrayAdapter<AddressBean> {
    public ChooseAdressAdaptr(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChoorseAddressViewHolder(parent);
    }
}
