package com.example.administrator.jiayan_project.adapter.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.qmuiteam.qmui.layout.QMUIRelativeLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4/004.
 */

public class BigYanAdapter extends BaseQuickAdapter<BigYanBean.DataBean, BaseViewHolder> {
    public BigYanAdapter(@Nullable List<BigYanBean.DataBean> data) {
        super(R.layout.big_item, data);
    }



//    @Override
//    protected void convert(BaseViewHolder viewHolder, BigYanBean item) {
//        viewHolder.setText(R.id.tweetName, item.getUserName())
//                .setText(R.id.tweetText, item.getText())
//                .setText(R.id.tweetDate, item.getCreatedAt())
//                .setVisible(R.id.tweetRT, item.isRetweet())
//                .linkify(R.id.tweetText);
//        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+item.getData()).crossFade().into((ImageView) viewHolder.getView(R.id.iv));
//
//    }

    @Override
    protected void convert(BaseViewHolder viewHolder, BigYanBean.DataBean item) {
        int mRadius= QMUIDisplayHelper.dp2px(MyApplication.getContext(), 3);
        float mShadowAlpha = 0.64f;
        int mShadowElevationDp = 13;
        Glide.with(MyApplication.getContext())
                .load(Constants.BaseUrl+item.getOriginalimg())
                .crossFade()
                .into((ImageView) viewHolder.getView(R.id.image));
        viewHolder
                .setText(R.id.dishes_name, item.getDinnername())
                .setText(R.id.money_before,"原价：¥ "+ String.valueOf(item.getOriginprice())+" /套")
                .setText(R.id.buy_money, String.valueOf(item.getPrice()))
                .addOnClickListener(R.id.add_cart)
                .setText(R.id.saclenum,String.valueOf(item.getSalesum())+"人付款");
        TextView textView=viewHolder.getView(R.id.money_before);
        textView.getPaint().setFlags(
                Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
        QMUIRelativeLayout  qmuiRelativeLayout=viewHolder.getView(R.id.relayout);
        qmuiRelativeLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(MyApplication.getContext(), mShadowElevationDp),
                mShadowAlpha);
    }
}
