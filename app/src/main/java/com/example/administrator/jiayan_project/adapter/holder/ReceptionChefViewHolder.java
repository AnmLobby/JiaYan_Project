package com.example.administrator.jiayan_project.adapter.holder;

import android.graphics.Color;
import android.media.Rating;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.hedgehog.ratingbar.RatingBar;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionChefViewHolder   extends BaseViewHolder<ReceptionDinnerBean.CookoBean> {
    private ImageView imageView;
    private TextView one,two,three,name;
    private static final String TAG = "CagViewHolder";
    private float mShadowAlpha = 0.25f;
    private int mShadowElevationDp = 15;
    private int mRadius;
    private RatingBar ratingBar;
    private QMUIRelativeLayout mTestLayout;

    public  ReceptionChefViewHolder(ViewGroup parent) {
        super(parent, R.layout.reception_chef_item);
        imageView=$(R.id.image);
        one=$(R.id.one);
        two=$(R.id.two);
        three=$(R.id.three);
        name=$(R.id.name);
        mTestLayout=$(R.id.layout);
        ratingBar=$(R.id.ratingbar);
    }

    @Override
    public void setData(ReceptionDinnerBean.CookoBean data) {
        super.setData(data);
        ratingBar.setStar(3);
        name.setText(data.getCookname());
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+data.getCookimg()).into(imageView);
        initQmuiLayout();
        if (data.getCookfront()==0){
            one.setTextColor(Color.parseColor("#808080"));
        }
        if (data.getDietionfront()==0){
            two.setTextColor(Color.parseColor("#808080"));
        }
        if (data.getCertificates()==0){
            three.setTextColor(Color.parseColor("#808080"));
        }
    }

    private void initQmuiLayout() {

        mRadius = QMUIDisplayHelper.dp2px(getContext(), 10);
//        mTestLayout.setRadiusAndShadow(mRadius,
//                QMUIDisplayHelper.dp2px(getContext(), mShadowElevationDp), mShadowAlpha);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp), mShadowAlpha);
        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE);

    }
}