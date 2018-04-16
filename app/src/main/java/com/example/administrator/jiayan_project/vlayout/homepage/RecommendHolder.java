package com.example.administrator.jiayan_project.vlayout.homepage;

import android.view.View;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class RecommendHolder extends VlayoutBaseHolder<RecommendBean>{
    @BindView(R.id.image)
    QMUIRadiusImageView imageView;

    public RecommendHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, RecommendBean rData) {
        super.setData(ps, rData);
    }
}
