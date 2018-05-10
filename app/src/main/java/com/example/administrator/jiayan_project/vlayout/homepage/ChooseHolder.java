package com.example.administrator.jiayan_project.vlayout.homepage;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.HomeChooseAdapter;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 鱼握拳 on 2018/4/12.
 */
//超值首选  http://jiayan.didi0769.com/index.php/api/index/huasuan
public class ChooseHolder  extends VlayoutBaseHolder<FirstChooseBean>{
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easyRecyclerView;
    private List<FirstChooseBean.DataBean> firstChooseBeans=new ArrayList<>();
    private static final String TAG = "ChooseHolder";
    private HomeChooseAdapter homeChooseAdapter=new HomeChooseAdapter(MyApplication.getContext());
    public ChooseHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, FirstChooseBean fData) {
        super.setData(ps, fData);

        LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        easyRecyclerView.setLayoutManager(layoutManager);

        firstChooseBeans=fData.getData();
        Log.e(TAG, "setData-------------------: "+firstChooseBeans.size() );
        homeChooseAdapter.addAll(firstChooseBeans);
        easyRecyclerView.setAdapter(homeChooseAdapter);
        homeChooseAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
