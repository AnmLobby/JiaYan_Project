package com.example.administrator.jiayan_project.ui.fragment.big;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.MoreAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.SearchAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanPresenter;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanView;
import com.example.administrator.jiayan_project.mvp.more.MoreYanPresenter;
import com.example.administrator.jiayan_project.mvp.more.MoreYanView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoreYanFragment extends AbstractMvpFragment<MoreYanView, MoreYanPresenter> implements MoreYanView {

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_more_yan, container, false);
//    }
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private String str,type;
    private MoreAdapter moreAdapter;
    private List<MoreYanBean.DataBean> dataBeanList;
    private View errorView;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_more_yan, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        Bundle bundle=getArguments();
        str=bundle.getString("title");
        type=bundle.getString("type");
        getPresenter().clickRequest(type);
        initTopBar(str);
        return  layout;
    }

    private void initTopBar(String str) {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle(str);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultMoreSuccess(MoreYanBean moreYanBean) {
        errorView= getLayoutInflater().inflate(R.layout.empty_more, (ViewGroup) recyclerView.getParent(), false);

        int code =moreYanBean.getCode();
        dataBeanList = moreYanBean.getData();
        moreAdapter = new MoreAdapter(dataBeanList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(searchAdapter);
        switch (code){
            case 200:
                recyclerView.setAdapter(moreAdapter);
                moreAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String id= String.valueOf(moreAdapter.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
                break;
            case 404:
                moreAdapter.setEmptyView(errorView);
                recyclerView.setAdapter(moreAdapter);
        }
    }


    @Override
    public MoreYanPresenter createPresenter() {
        return new MoreYanPresenter();
    }
}
