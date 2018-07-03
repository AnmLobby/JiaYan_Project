package com.example.administrator.jiayan_project.adapter.adapter;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/29/029.
 */

public class MainClassifyAdapter extends BaseQuickAdapter<ClassifyBean.TypedataBean, BaseViewHolder> {
    private List<ClassifyBean.TypedataBean.DetailBean> mList=new ArrayList<>();
    private DetailClassifyAdapter detailClassifyAdapter;
    public MainClassifyAdapter(@Nullable List<ClassifyBean.TypedataBean> data) {
        super(R.layout.classify_item, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder,ClassifyBean.TypedataBean item) {
        viewHolder.setText(R.id.title,item.getTypename());

        RecyclerView recyclerView=viewHolder.getView(R.id.recyclerview);
        viewHolder.addOnClickListener(R.id.recyclerview);
        mList=item.getDetail();
        detailClassifyAdapter = new DetailClassifyAdapter(mList);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);



        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setAdapter(detailClassifyAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MyApplication.getContext(),3));
        detailClassifyAdapter.notifyDataSetChanged();
        detailClassifyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int id= detailClassifyAdapter.getData().get(position).getId();
                Log.e(TAG, "onIssssssssstemClick: "+detailClassifyAdapter.getData().get(position).getDinnername());
            }
        });
    }
}
