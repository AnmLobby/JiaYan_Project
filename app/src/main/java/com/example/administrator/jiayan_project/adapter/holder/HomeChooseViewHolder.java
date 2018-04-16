package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/**
 * Created by 鱼握拳 on 2018/4/16.
 */

public class HomeChooseViewHolder  extends BaseViewHolder<FirstChooseBean>{
    private QMUIRadiusImageView imageView;
    public HomeChooseViewHolder(ViewGroup viewGroup)  {
        super(viewGroup, R.layout.firstchoose_item);
        imageView=$(R.id.image);
    }

    @Override
    public void setData(FirstChooseBean data) {
        super.setData(data);
    }
}
