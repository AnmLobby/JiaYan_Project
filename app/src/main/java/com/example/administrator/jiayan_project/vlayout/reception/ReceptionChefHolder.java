package com.example.administrator.jiayan_project.vlayout.reception;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.ReceptionChefAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.ReceptionDinnerAdapter;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionChefHolder extends VlayoutBaseHolder<ReceptionDinnerBean> {
    private List<ReceptionDinnerBean.CookoBean> itemListBeans;
    private ReceptionChefAdapter homeRecyclervAdapter;
    @BindView(R.id.title)
    TextView textView;
    @BindView(R.id.select_recycler)
    RecyclerView easyrecycler;
    private static final String TAG = "SelectHolder";

    public ReceptionChefHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ReceptionDinnerBean rData) {
        super.setData(ps, rData);
        textView.setText(mText);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        homeRecyclervAdapter = new  ReceptionChefAdapter(MyApplication.getContext());
        easyrecycler.setAdapter(homeRecyclervAdapter);
        itemListBeans = rData.getCooko();
        homeRecyclervAdapter.addAll(itemListBeans);
        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}