package com.example.administrator.jiayan_project.vlayout.reception;

import android.view.View;

import com.example.administrator.jiayan_project.adapter.adapter.ReceptionDinnerAdapter;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ReceptionChefHolder extends VlayoutBaseHolder<ReceptionChefBean> {
    private List<ReceptionDinnerBean> itemListBeans;
    private ReceptionDinnerAdapter homeRecyclervAdapter;

    //    @BindView(R.id.select_recycler)
//    EasyRecyclerView easyrecycler;
    private static final String TAG = "SelectHolder";

    public ReceptionChefHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, ReceptionChefBean rData) {
        super.setData(ps, rData);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
//        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
//        homeRecyclervAdapter = new ReceptionDinnerAdapter(MyApplication.getContext());
//        easyrecycler.setAdapter(homeRecyclervAdapter);
//        itemListBeans = rData.getItemList();
//        homeRecyclervAdapter.addAll(itemListBeans);
//        homeRecyclervAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                mListener.onItemClick(mView, position, mData);
//            }
//        });
    }
}