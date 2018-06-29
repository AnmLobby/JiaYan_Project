package com.example.administrator.jiayan_project.adapter.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.http.Constants;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/29/029.
 */

public class DetailClassifyAdapter extends BaseQuickAdapter<ClassifyBean.TypedataBean.DetailBean, BaseViewHolder> {


    public DetailClassifyAdapter(@Nullable List<ClassifyBean.TypedataBean.DetailBean> data) {
        super(R.layout.vlayout_home_grid, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder,ClassifyBean.TypedataBean.DetailBean item) {
        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+item.getOriginalimg())
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.icon));
        viewHolder.setText(R.id.name,item.getDinnername());
    }
}
