package com.example.administrator.jiayan_project.adapter.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class FootHolder extends RecyclerView.ViewHolder {
    public TextView comment_name,comment_price;
    public ImageView footimage;
    public FootHolder(View itemView) {
        super(itemView);
        comment_name=itemView.findViewById(R.id.comment_name);
        comment_price=itemView.findViewById(R.id.comment_price);
        footimage=itemView.findViewById(R.id.footimage);
    }
}
