package com.example.administrator.jiayan_project.adapter.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
import com.example.administrator.jiayan_project.http.Constants;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3/003.
 */

public class MoreAdapter extends BaseQuickAdapter<MoreYanBean.DataBean, BaseViewHolder> {

    public  MoreAdapter(@Nullable List<MoreYanBean.DataBean> data) {
            super(R.layout.receptiondinner_item, data);
            }

@Override
    protected void convert(BaseViewHolder  viewHolder, MoreYanBean.DataBean item) {

        viewHolder
        .setText(R.id.title, item.getDinnername())
        .setText(R.id.price,"¥ "+ String.valueOf(item.getPrice()))
        .setText(R.id.saclenum,"已销售："+item.getSalesum()+"笔");
            Glide.with(MyApplication.getContext())
            .load(Constants.BaseUrl+item.getOriginalimg())
            .crossFade()
            .into((ImageView) viewHolder.getView(R.id.image));
     }
}
