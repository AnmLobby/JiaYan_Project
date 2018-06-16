package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.BigYanAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.ChefListAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.chef_classify.ChefClassifyPresenter;
import com.example.administrator.jiayan_project.mvp.chef_classify.ChefClassifyView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 选中厨师类型列表
 */
public class ChefClassifyFragment  extends AbstractMvpFragment<ChefClassifyView, ChefClassifyPresenter> implements ChefClassifyView {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private List<ChefClassifyBean.ChefDataBean> chefDataBeanList;
    private ChefListAdapter chefListAdapter;
    private static final String TAG = "ChefClassifyFragment";
    private QMUITipDialog tipDialog;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chef_classify, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        Bundle bundle=getArguments();
        int id=bundle.getInt("id");
        String msg=bundle.getString("msg");
        initTopBar(msg);
        getPresenter().clickRequestCart(id);
        return layout;
    }

    private void initTopBar(String msg) {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle(msg);
    }


    @Override
    public void requestLoading() {
        tipDialog = new QMUITipDialog.Builder(getActivity())
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: " );
    }

    @Override
    public void resultChefClassifySuccess(ChefClassifyBean chefClassifyBean) {
        chefDataBeanList=chefClassifyBean.getChefData();
        chefListAdapter = new ChefListAdapter(chefDataBeanList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chefListAdapter);
        chefListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                int id= chefListAdapter.getData().get(position).getId();
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                ChefDetailFragment chefDetailFragment=new ChefDetailFragment();
                chefDetailFragment.setArguments(bundle);
                startFragment(chefDetailFragment);
            }
        });
        tipDialog.dismiss();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public ChefClassifyPresenter createPresenter() {
        return new ChefClassifyPresenter();
    }
}
