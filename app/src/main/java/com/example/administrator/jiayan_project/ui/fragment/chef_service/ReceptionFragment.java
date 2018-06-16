package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.homepage.HomePresenter;
import com.example.administrator.jiayan_project.mvp.homepage.HomeView;
import com.example.administrator.jiayan_project.mvp.reception.ReceptionPresenter;
import com.example.administrator.jiayan_project.mvp.reception.ReceptionView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefBannerDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefCommentDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefMsgDetailHolder;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.reception.ReceptionBannerHolder;
import com.example.administrator.jiayan_project.vlayout.reception.ReceptionChefHolder;
import com.example.administrator.jiayan_project.vlayout.reception.ReceptionDinnerHolder;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 高级接待，包含厨师页面。有banner ，vlaoyout实现
 */


public class ReceptionFragment extends AbstractMvpFragment<ReceptionView, ReceptionPresenter> implements ReceptionView{
    private static final String TAG = "ReceptionFragment";
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private  VirtualLayoutManager virtualLayoutManager;
    private VlayoutBaseAdapter banneradapter, chefAdapter,dinnerAdapter;
    private List<ReceptionBannerBean> receptionBannerBeans=new ArrayList<>();
    private List<ReceptionDinnerBean> receptionDinnerBeans=new ArrayList<>();
    private List<ReceptionChefBean>  receptionChefBeans=new ArrayList<>();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_reception, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        initRecycler();
        initDele();
        return layout;
    }

    private void initRecycler() {
        virtualLayoutManager= new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initDele() {

        banneradapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ReceptionBannerBean>())
                .setLayout(R.layout.vlayout_chefdetail_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ReceptionBannerHolder.class)
                .setListener(new ItemListener<ReceptionBannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, ReceptionBannerBean mData) {

                    }
                });
        dinnerAdapter= new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ReceptionDinnerBean>())
                .setLayout(R.layout.vlayout_chefdetail_detail)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ReceptionDinnerHolder.class)
                .setListener(new ItemListener<ReceptionDinnerBean>() {
                    @Override
                    public void onItemClick(View view, int position, ReceptionDinnerBean mData) {

                    }
                });

        chefAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ReceptionChefBean>())
                .setLayout(R.layout.vlayout_chef_grid)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ReceptionChefHolder.class)
                .setListener(new ItemListener<ReceptionChefBean>() {
                    @Override
                    public void onItemClick(View view, int position, ReceptionChefBean mData) {

                    }
                });
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(dinnerAdapter);
        delegateAdapter.addAdapter(chefAdapter);
        mRecycler.setAdapter(delegateAdapter);

    }
    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.HighReception);
        mTopBar.addRightImageButton(R.mipmap.share, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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
        Toast.makeText(MyApplication.getContext(), "发生未知错误", Toast.LENGTH_SHORT).show();
        popBackStack();
    }

    @Override
    public void resultBannerSuccess(ReceptionBannerBean receptionBannerBean) {

    }

    @Override
    public void resultChefSuccess(ReceptionChefBean receptionChefBean) {

    }

    @Override
    public void resultDinnerSuccess(ReceptionDinnerBean receptionDinnerBean) {

    }

    @Override
    public ReceptionPresenter createPresenter() {
        return new ReceptionPresenter();
    }
}
