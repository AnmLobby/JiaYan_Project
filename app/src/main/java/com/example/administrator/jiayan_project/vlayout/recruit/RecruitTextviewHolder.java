package com.example.administrator.jiayan_project.vlayout.recruit;

import android.view.View;

import com.example.administrator.jiayan_project.mvp.regesigt_list.RegListBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

/**
 * Created by Administrator on 2018/6/16/016.
 */

public class RecruitTextviewHolder extends VlayoutBaseHolder<RegListBean> {

    private static final String TAG = "GridHolder";

    public RecruitTextviewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RegListBean cData) {
        super.setData(ps, cData);
    }
}