package com.example.administrator.jiayan_project.vlayout.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;


import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class GridHolder extends VlayoutBaseHolder<IconBean> {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.name)
    TextView mFunc;
    private static final String TAG = "GridHolder";
    public GridHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, IconBean data) {
        super.setData(ps, data);
        Glide.with(MyApplication.getContext())
                .load(data.getImageId())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mIcon);
        mFunc.setText(data.getName());
    }
    @Override
    public void init() {
        super.init();
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}

