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

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionDinnerViewHolder   extends BaseViewHolder<ReceptionDinnerBean> {
    private ImageView imageView;
    private TextView title,price;
    private static final String TAG = "CagViewHolder";

    public  ReceptionDinnerViewHolder(ViewGroup parent) {
        super(parent, R.layout.receptiondinner_item);
        imageView=$(R.id.image);
        title=$(R.id.title);
        price=$(R.id.price);

    }

    @Override
    public void setData(ReceptionDinnerBean data) {
        super.setData(data);
    }
}