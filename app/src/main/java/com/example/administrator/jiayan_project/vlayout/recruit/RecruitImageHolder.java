package com.example.administrator.jiayan_project.vlayout.recruit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegListBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/16/016.
 */

public class RecruitImageHolder extends VlayoutBaseHolder<RegListBean> {

    private static final String TAG = "GridHolder";
    public RecruitImageHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RegListBean cData) {
        super.setData(ps, cData);
    }
}