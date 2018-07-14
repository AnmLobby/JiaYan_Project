package com.example.administrator.jiayan_project.vlayout.chefDetail;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.comment.BanquetCommentAdapter;
import com.example.administrator.jiayan_project.adapter.comment.ChefCommentAdapter;
import com.example.administrator.jiayan_project.adapter.news.SectionedSpanSizeLookup;
import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.vlayout.helper.SectionVlayoutBaseHolder;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefCommentDetailHolder  extends SectionVlayoutBaseHolder<ChefDetailMsgBean> {
    private ChefCommentAdapter chefCommentAdapter;
    private List<ChefDetailMsgBean.EvaluateBean> classBeans;
    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    public ChefCommentDetailHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setSectionData(int ps, ChefDetailMsgBean lData) {
        super.setSectionData(ps, lData);
        classBeans=lData.getEvaluate();
//        for (int i = 0; i <classifyBean.getTypedata().size() ; i++) {
//            detailBeans=classifyBean.getTypedata().get(1).getDetail();
//        }
      
        chefCommentAdapter = new ChefCommentAdapter(MyApplication.getContext());

        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(chefCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(chefCommentAdapter);
        chefCommentAdapter.setOnChefCommentItemClickListener(new ChefCommentAdapter.OnChefCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
//                mListener.onItemClick(mView, position, mData);
                mListener.onSectionItemClick(mView,section,position,mSectionData);
            }
        });

        chefCommentAdapter.setData(classBeans);
    }
}
