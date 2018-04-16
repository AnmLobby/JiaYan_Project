package com.example.administrator.jiayan_project.vlayout.homepage;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class FestivalHolder extends VlayoutBaseHolder<FestivalBean> {
    @BindView(R.id.image)
    QMUIRadiusImageView imageView;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.liangdian)
    TextView liangdian;
    @BindView(R.id.money)
    TextView money;
    public FestivalHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, FestivalBean fData) {
        super.setData(ps, fData);
        name.setText("8");
        liangdian.setText("88");
        money.setText("¥");
    }
}
