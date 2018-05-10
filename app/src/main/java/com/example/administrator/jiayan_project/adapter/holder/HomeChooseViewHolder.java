package com.example.administrator.jiayan_project.adapter.holder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * Created by 鱼握拳 on 2018/4/16.
 */

public class HomeChooseViewHolder  extends BaseViewHolder<FirstChooseBean.DataBean>{
    private QMUIRadiusImageView imageView;
    private static final String TAG = "HomeChooseViewHolder";
    public HomeChooseViewHolder(ViewGroup viewGroup)  {
        super(viewGroup, R.layout.firstchoose_item);
        imageView=$(R.id.image);
    }

    @Override
    public void setData(FirstChooseBean.DataBean data) {
        super.setData(data);
        Log.e(TAG, "setaaaData: "+Constants.JiaYan+data.getOriginalimg() );
        Glide.with(MyApplication.getContext()).load(Constants.JiaYan+data.getOriginalimg()).into(imageView);
    }

}
