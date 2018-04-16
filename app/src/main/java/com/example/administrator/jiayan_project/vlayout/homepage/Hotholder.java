package com.example.administrator.jiayan_project.vlayout.homepage;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.HomeChooseAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.HotAdapter;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */

public class Hotholder extends VlayoutBaseHolder<HotBean> {
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easyRecyclerView;
    private List<HotBean> hotbean=new ArrayList<>();
    private HotAdapter hotAdapter=new HotAdapter(MyApplication.getContext());
    public Hotholder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, HotBean hData) {
        super.setData(ps, hData);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        easyRecyclerView.setLayoutManager(layoutManager);
//        firstChooseBeans = fData;
       hotAdapter.addAll(hotbean);
        easyRecyclerView.setAdapter(hotAdapter);
        hotAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
