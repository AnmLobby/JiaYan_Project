package com.example.administrator.jiayan_project.adapter.comment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.hedgehog.ratingbar.RatingBar;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public class CommentHolder extends RecyclerView.ViewHolder {
    public TextView comment_name,comment_time,num,openView,comment;
    public CircleImageView circleImageView;
    public RatingBar ratingBar;
    public CommentHolder(View itemView) {
        super(itemView);
        initView();
    }

    private void initView() {
        openView = (TextView) itemView.findViewById(R.id.tv_open);
        comment=(TextView) itemView.findViewById(R.id.comment);
        comment_name = (TextView) itemView.findViewById(R.id.comment_name);
        comment_time = (TextView) itemView.findViewById(R.id.comment_time);
        num= (TextView) itemView.findViewById(R.id.num);
        circleImageView=(CircleImageView)itemView.findViewById(R.id.comment_image);
        ratingBar=(RatingBar)itemView.findViewById(R.id.comment_ratingbar);
    }
}
