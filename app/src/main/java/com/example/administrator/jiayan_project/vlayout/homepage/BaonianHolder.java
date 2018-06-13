package com.example.administrator.jiayan_project.vlayout.homepage;

import android.view.View;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/13/013.
 */

public class BaonianHolder extends VlayoutBaseHolder<BannerBean> {
    @BindView(R.id.image)
    QMUIRadiusImageView imageView;

    private static final String TAG = "FestivalHolder";
    public BaonianHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, BannerBean fData) {
        super.setData(ps, fData);
        Glide.with(MyApplication.getContext()).load(R.drawable.bg_people).into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(mView, position, mData);
            }
        });

    }
}