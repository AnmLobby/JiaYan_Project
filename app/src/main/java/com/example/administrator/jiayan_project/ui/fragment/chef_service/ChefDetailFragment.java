package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailPresenter;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailView;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefBannerDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefCommentDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefMsgDetailHolder;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 选菜预定界面，具有banner 。已验证信息，厨师详情
 */
public class ChefDetailFragment extends AbstractMvpFragment<ChefDetailView, ChefDetailPresenter> implements ChefDetailView {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;

    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private VlayoutBaseAdapter banneradapter, chefmsgAdapter, commentAdapter;
    private List<ChefDetailMsgBean> msgBeans = new ArrayList<>();

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chef_detail, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        getPresenter().clickRequestCart(id);
        initTopBar();
        initRecycler();
        initDele();
        return layout;
    }

    private void initDele() {
        banneradapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailBannerBean>())
                .setLayout(R.layout.vlayout_chefdetail_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefBannerDetailHolder.class)
                .setListener(new ItemListener<ChefDetailBannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailBannerBean mData) {

                    }
                });
        chefmsgAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailMsgBean>())
                .setLayout(R.layout.vlayout_chefdetail_detail)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefMsgDetailHolder.class)
                .setListener(new ItemListener<ChefDetailMsgBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailMsgBean mData) {

                    }
                });
        /**
         * 评论布局还没写
         */
        commentAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailCommentBean>())
                .setLayout(R.layout.vlayout_chef_grid)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefCommentDetailHolder.class)
                .setListener(new ItemListener<ChefDetailCommentBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailCommentBean mData) {

                    }
                });
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(chefmsgAdapter);
        delegateAdapter.addAdapter(commentAdapter);
        mRecycler.setAdapter(delegateAdapter);

    }

    private void initRecycler() {
        virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.AboutName);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Toast.makeText(MyApplication.getContext(), "后台发生未知错误", Toast.LENGTH_SHORT).show();
        popBackStack();
    }

    @Override
    public void resultChefBannerSuccess(ChefDetailBannerBean chefDetailBannerBean) {

    }

    @Override
    public void resultChefMsgSuccess(ChefDetailMsgBean chefDetailMsgBean) {
        msgBeans.add(chefDetailMsgBean);
        chefmsgAdapter.setData(msgBeans);
        chefmsgAdapter.notifyDataSetChanged();
    }

    @Override
    public void resultChefCommentSuccess(ChefDetailCommentBean chefDetailCommentBean) {

    }

    @Override
    public ChefDetailPresenter createPresenter() {
        return new ChefDetailPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
