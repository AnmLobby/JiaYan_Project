package com.example.administrator.jiayan_project.vlayout.recruit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.regesigt_list.ChefResignDataBean;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegListBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/16/016.
 */

public class RecruitGridHolder extends VlayoutBaseHolder<ChefResignDataBean> {
    @BindView(R.id.icon)
    ImageView mIcon;
    @BindView(R.id.name)
    TextView mFunc;
    private static final String TAG = "GridHolder";
    public RecruitGridHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps,ChefResignDataBean data) {
        super.setData(ps, data);

        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+data.getCookerimg())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mIcon);
        mFunc.setText(data.getTitlename());
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
