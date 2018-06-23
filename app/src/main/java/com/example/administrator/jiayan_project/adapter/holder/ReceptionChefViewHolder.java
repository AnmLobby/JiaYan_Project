package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionChefViewHolder   extends BaseViewHolder<ReceptionDinnerBean.CookoBean> {
    private ImageView imageView;
    private TextView title,price;
    private static final String TAG = "CagViewHolder";

    public  ReceptionChefViewHolder(ViewGroup parent) {
        super(parent, R.layout.receptiondinner_item);

    }

    @Override
    public void setData(ReceptionDinnerBean.CookoBean data) {
        super.setData(data);
    }
}