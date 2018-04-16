package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.qmuiteam.qmui.span.QMUIMarginImageSpan;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * Created by 鱼握拳 on 2018/4/16.
 */

public class HotViewHolder extends BaseViewHolder<HotBean> {
    private TextView name;
    private QMUIRadiusImageView imageView;
    public HotViewHolder(ViewGroup parent) {
        super(parent, R.layout.hot_item);
        imageView=$(R.id.image);
        name=$(R.id.name);
    }

    @Override
    public void setData(HotBean data) {
        super.setData(data);
    }
}
