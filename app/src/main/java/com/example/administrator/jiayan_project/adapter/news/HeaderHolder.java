package com.example.administrator.jiayan_project.adapter.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;


/**
 * Created by lyd10892 on 2016/8/23.
 */

public class HeaderHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public TextView openView;
    public HeaderHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        titleView = (TextView) itemView.findViewById(R.id.title);
        openView = (TextView) itemView.findViewById(R.id.tv_open);
    }
}
