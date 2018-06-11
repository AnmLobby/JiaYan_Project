package com.example.administrator.jiayan_project.vlayout.chef;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/11/011.
 */

public class ChefMsgHolder extends VlayoutBaseHolder<ChefMsgBean.DataBean> {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.name)
    TextView mFunc;
    private static final String TAG = "GridHolder";
    public ChefMsgHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefMsgBean.DataBean cData) {
        super.setData(ps, cData);
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+cData.getCookimg()).into(mIcon);
        mFunc.setText(cData.getSubname());
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
