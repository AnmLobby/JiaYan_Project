package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionDinnerViewHolder   extends BaseViewHolder<ReceptionDinnerBean.ReceptionBean> {
    private QMUIRadiusImageView imageView;
    private TextView title,price,sac;
    private static final String TAG = "CagViewHolder";

    public  ReceptionDinnerViewHolder(ViewGroup parent) {
        super(parent, R.layout.receptiondinner_item);
        imageView=$(R.id.image);
        title=$(R.id.title);
        price=$(R.id.price);
        sac=$(R.id.saclenum);
    }


    @Override
    public void setData(ReceptionDinnerBean.ReceptionBean data) {
        super.setData(data);
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+data.getOriginalimg()).into(imageView);
        title.setText(data.getDinnername());
        price.setText("¥ "+String.valueOf(data.getPrice()));
        sac.setText("已销售："+data.getSalesum()+"笔");
    }
}