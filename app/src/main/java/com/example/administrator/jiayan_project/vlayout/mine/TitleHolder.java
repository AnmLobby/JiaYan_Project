package com.example.administrator.jiayan_project.vlayout.mine;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.TitieBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class TitleHolder extends VlayoutBaseHolder<TitieBean> {
    @BindView(R.id.titletext)
    TextView mFunc;
    public TitleHolder(View itemView) {
        super(itemView);

    }
    @Override
    public void setData(int ps, TitieBean data) {
        super.setData(ps, data);
        mFunc.setText(mText);
    }
}



