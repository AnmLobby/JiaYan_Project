package com.example.administrator.jiayan_project.vlayout.homepage;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class RecommendHolder extends VlayoutBaseHolder<DataBean>{
    @BindView(R.id.image)
    QMUIRadiusImageView imageView;
    @BindView(R.id.name)
    TextView   name;
    @BindView(R.id.liangdian)
    TextView   liangdian;
    @BindView(R.id.money)
    TextView   money;
    private static final String TAG = "RecommendHolder";
    public RecommendHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, DataBean rData) {
        super.setData(ps, rData);



            Glide.with(MyApplication.getContext())
                    .load(Constants.BaseUrl+rData.getOriginalimg())
                    .into(imageView);
            name.setText(rData.getDinnername());
            liangdian.setText(rData.getSubname());
            money.setText("¥"+rData.getPrice());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(mView, position, mData);
                }
            });
    }
}
