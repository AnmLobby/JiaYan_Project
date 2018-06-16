package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.chef.ChefBannerBean;
import com.example.administrator.jiayan_project.enity.chef.ChefDataBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.chef.ChefPresenter;
import com.example.administrator.jiayan_project.mvp.chef.ChefView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.ClassifyFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.SearchFragment;
import com.example.administrator.jiayan_project.ui.fragment.recruit.CookRegisterFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.vlayout.chef.ChefBannerHolder;
import com.example.administrator.jiayan_project.vlayout.chef.ChefMsgHolder;
import com.example.administrator.jiayan_project.vlayout.chef.ViewLineHolder;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.BannerHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.FestivalHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 万众服务
 */
public class WZServiceFragment extends AbstractMvpFragment<ChefView, ChefPresenter> implements ChefView {

    private QMUITipDialog tipDialog;
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecycler;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter banneradapter, chefAdapter,lineAdapter;
    private  VirtualLayoutManager virtualLayoutManager;
    private List<ChefBannerBean> chefBannerBeans=new ArrayList<>();
    private static final String TAG = "WZServiceFragment";
    private ChefBannerBean[] bannerBean = new ChefBannerBean[]{new ChefBannerBean("http://bmob-cdn-18241.b0.upaiyun.com/2018/06/11/591738b640ac699080fc1d808960a55f.png"),
            new ChefBannerBean("http://bmob-cdn-18241.b0.upaiyun.com/2018/06/11/591738b640ac699080fc1d808960a55f.png")};
    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wz_service, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestCart();
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
                .setData(new ArrayList<ChefBannerBean>())
                .setLayout(R.layout.chef_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefBannerHolder.class)
                .setListener(new ItemListener<ChefBannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefBannerBean mData) {
                        startFragment(new CookRegisterFragment());
//                        String id = String.valueOf(mData.getData().get(position).getId());
//                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
//                        startFragment(new BlankOneFragment());
//                        startFragment(new BlankOneFragment());
                    }
                });
        lineAdapter= new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDataBean>())
                .setLayout(R.layout.vlayout_chef_head)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ViewLineHolder.class)
                .setListener(new ItemListener<ChefDataBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDataBean mData) {

                    }
                });
       chefAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDataBean>())
                .setLayout(R.layout.vlayout_chef_grid)
                .setLayoutHelper(getGridLayoutHelper())
                .setHolder(ChefMsgHolder.class)
                .setListener(new ItemListener<ChefDataBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDataBean mData) {
                        int id =mData.getId();
                        String msg=mData.getTitlename();
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",id);
                        bundle.putString("msg",msg);
                        ChefClassifyFragment chefClassifyFragment=new ChefClassifyFragment();
                        chefClassifyFragment.setArguments(bundle);
                        startFragment(chefClassifyFragment);
                    }
                });
        delegateAdapter.addAdapter(banneradapter);
//        delegateAdapter.addAdapter(lineAdapter);
        delegateAdapter.addAdapter(chefAdapter);
        mRecycler.setAdapter(delegateAdapter);

        chefBannerBeans.add(bannerBean[1]);
        banneradapter.setData(chefBannerBeans);
        banneradapter.notifyDataSetChanged();
    }
    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.addRightImageButton(R.mipmap.chef_search, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SearchFragment());
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle(ContantsName.WZService);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public ChefPresenter createPresenter() {
        return new ChefPresenter();
    }
    private LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(3);
        gridHelper.setMarginTop(20);
        gridHelper.setWeights(new float[]{33.3f, 33.3f, 33.3f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(4);
        //设置水平方向条目的间隔
        gridHelper.setHGap(4);
        gridHelper.setMarginLeft(8);
        gridHelper.setMarginBottom(20);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
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
            popBackStack();
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void resultChefSuccess(ChefMsgBean chefMsgBean) {




//        List<ChefMsgBean> list=new ArrayList<>();
//        list.add(chefMsgBean);
        chefAdapter.setData(chefMsgBean.getChefData());
        chefAdapter.notifyDataSetChanged();

//        lineAdapter.setData(chefMsgBean.getChefData());
//        lineAdapter.notifyDataSetChanged();

        tipDialog.dismiss();
}
}
