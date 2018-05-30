package com.example.administrator.jiayan_project.vlayout.homepage;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class StartHolder  extends VlayoutBaseHolder<DataBean> {
    @BindView(R.id.image)
    QMUIRadiusImageView imageView;
    @BindView(R.id.name)
    TextView name;
    public StartHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps,DataBean sData) {
        super.setData(ps, sData);
//        for (int i = 0; i < sData.getData().size(); i++) {
            Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+sData.getOriginalimg()).into(imageView);
            name.setText(sData.getPrice());
//        }

    }
}
