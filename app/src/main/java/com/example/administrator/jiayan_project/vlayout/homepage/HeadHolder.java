package com.example.administrator.jiayan_project.vlayout.homepage;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/10/010.
 */

public class HeadHolder extends VlayoutBaseHolder<BannerBean> {
        @BindView(R.id.title) TextView titleText;
        @BindView(R.id.more) TextView more;
         private static final String TAG = "RecommendHolder";
        public HeadHolder(View itemView) {
            super(itemView);
            }

    @Override
    public void setData(int ps, BannerBean rData) {
            super.setData(ps, rData);
            titleText.setText(mText);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(mView, position, mData);
                }
            });


    }
}
