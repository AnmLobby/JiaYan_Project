package com.example.administrator.jiayan_project.vlayout.chef;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.chef.ChefDataBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/13/013.
 */

/**
 * 丢弃。添加进bannerHolder里面
 */
public class ViewLineHolder extends VlayoutBaseHolder<ChefDataBean> {

    private static final String TAG = "GridHolder";
    public ViewLineHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ChefDataBean cData) {
        super.setData(ps, cData);

    }

}