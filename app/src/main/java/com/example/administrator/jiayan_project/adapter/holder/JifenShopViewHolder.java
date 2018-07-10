package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.ui.fragment.big.MoreYanFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by 鱼握拳 on 2018/4/25.
 */

public class JifenShopViewHolder extends BaseViewHolder<JifenMainBean.IntegralBean> {
    private ImageView imageView;
    private TextView textView,price;
    public JifenShopViewHolder(ViewGroup parent) {
        super(parent, R.layout.jifen_item);
        imageView=$(R.id.image);
        textView=$(R.id.name);
        price=$(R.id.price);
    }

    @Override
    public void setData(JifenMainBean.IntegralBean data) {
        super.setData(data);
        textView.setText(data.getName());
        price.setText(data.getStorecount()+"积分 "+"+ ¥ "+data.getIntegralprice());
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+data.getOriginalimg()).into(imageView);
    }
}
