package com.example.administrator.jiayan_project.vlayout.mine;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.JifenAdapter;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/24.
 */

public class JifenHolder extends VlayoutBaseHolder<JifenMainBean> {
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easyrecycler;
    private List<JifenMainBean.IntegralBean> list=new ArrayList<>();
    private JifenAdapter adapter;
    public JifenHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, JifenMainBean jData) {
        super.setData(ps, jData);
        list=jData.getIntegral();
        adapter=new JifenAdapter(MyApplication.getContext());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        adapter.addAll(list);
        easyrecycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
