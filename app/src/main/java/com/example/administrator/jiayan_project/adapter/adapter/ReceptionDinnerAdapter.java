package com.example.administrator.jiayan_project.adapter.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.administrator.jiayan_project.adapter.holder.ReceptionDinnerViewHolder;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionDinnerAdapter  extends RecyclerArrayAdapter<ReceptionDinnerBean> {
    public ReceptionDinnerAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReceptionDinnerViewHolder(parent);
    }
}
