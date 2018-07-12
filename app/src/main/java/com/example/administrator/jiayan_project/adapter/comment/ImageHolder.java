package com.example.administrator.jiayan_project.adapter.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public class ImageHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public LinearLayout linearLayout;
    public ImageHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        imageView=(ImageView) itemView.findViewById(R.id.banquet_image);
        linearLayout=(LinearLayout) itemView.findViewById(R.id.banquet_layout);
    }
}
