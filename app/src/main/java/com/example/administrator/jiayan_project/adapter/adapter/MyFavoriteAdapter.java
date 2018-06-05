package com.example.administrator.jiayan_project.adapter.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.http.Constants;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5/005.
 */

public class MyFavoriteAdapter extends BaseQuickAdapter<FavouriteBean.DataBean, BaseViewHolder> {
    public MyFavoriteAdapter(@Nullable List<FavouriteBean.DataBean> data) {
        super(R.layout.myfavorite_item, data);
    }

    @Override
    protected void convert(BaseViewHolder  viewHolder, FavouriteBean.DataBean item) {
        viewHolder
                .setText(R.id.title, item.getDinnername())
                .addOnClickListener(R.id.buy)    //给图标添加 点击事件
                .addOnClickListener(R.id.cancel)
                .setText(R.id.money,"¥ "+ String.valueOf(item.getPrice()))
                .setText(R.id.detail,item.getSubname());
        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+item.getOriginalimg())
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.image));
    }
}
