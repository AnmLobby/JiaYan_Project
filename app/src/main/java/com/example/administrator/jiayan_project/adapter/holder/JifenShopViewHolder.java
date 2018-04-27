package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;

/**
 * Created by 鱼握拳 on 2018/4/25.
 */

public class JifenShopViewHolder extends BaseViewHolder<JifenBean> {
    private ImageView imageView;
    private TextView textView;
    public JifenShopViewHolder(ViewGroup parent) {
        super(parent, R.layout.jifen_item);
        imageView=$(R.id.image);
        textView=$(R.id.name);
    }

    @Override
    public void setData(JifenBean data) {
        super.setData(data);
    }
}
