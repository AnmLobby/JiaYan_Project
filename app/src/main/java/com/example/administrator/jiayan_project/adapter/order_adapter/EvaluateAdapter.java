package com.example.administrator.jiayan_project.adapter.order_adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.order.UnpayBean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/10/010.
 */

public class EvaluateAdapter extends BaseQuickAdapter<UnpayBean, BaseViewHolder> {
   

    public EvaluateAdapter(@Nullable List<UnpayBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UnpayBean item) {

    }
}
