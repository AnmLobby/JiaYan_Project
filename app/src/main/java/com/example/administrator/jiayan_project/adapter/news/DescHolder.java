package com.example.administrator.jiayan_project.adapter.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;


/**
 * Created by lyd10892 on 2016/8/23.
 */

public class DescHolder extends RecyclerView.ViewHolder {
    public TextView descView;
    public ImageView imageView;
    public LinearLayout linearLayout;
    public DescHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        descView = (TextView) itemView.findViewById(R.id.nameee);
        imageView=(ImageView) itemView.findViewById(R.id.icon);
        linearLayout=(LinearLayout) itemView.findViewById(R.id.desc_layout);
    }
}
