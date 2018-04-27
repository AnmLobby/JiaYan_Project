package com.example.administrator.jiayan_project.vlayout.mine;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.JifenAdapter;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/24.
 */

public class JifenHolder extends VlayoutBaseHolder<JifenBean> {
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easyrecycler;
    private List<JifenBean> list=new ArrayList<>();
    private JifenAdapter adapter=new JifenAdapter(MyApplication.getContext());
    public JifenHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, JifenBean jData) {
        super.setData(ps, jData);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        easyrecycler.setLayoutManager(staggeredGridLayoutManager);
        easyrecycler.setAdapter(adapter);
    }
}
