package com.example.administrator.jiayan_project.ui.fragment.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.FrameLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.homepage.HomePresenter;
import com.example.administrator.jiayan_project.mvp.homepage.HomeView;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.BannerHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.ChooseHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.FestivalHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.Hotholder;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.homepage.RecommendHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.StartHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面，底部栏第一个
 */
public class HomePageFragment extends AbstractMvpFragment<HomeView, HomePresenter> implements HomeView {
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter banneradapter,festivalAdapter,chooseAdapter,hotAdapter,recommendAdapter,startAdapter;
    private List<BannerBean> bannerBeans=new ArrayList<>();
    private List<FestivalBean> festivalBeans=new ArrayList<>();
    private List<FirstChooseBean> firstChooseBeans =new ArrayList<>();
    private List<HotBean> hotBeans=new ArrayList<>();
    private List<RecommendBean> recommendBeans=new ArrayList<>();
    private List<StarBean> starBeans=new ArrayList<>();
    private static final String TAG = "HomePageFragment";
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_page, null);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequest();
        initRecycleview();
        initVlayout();

        return layout;
    }

    private void initRecycleview() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initVlayout() {
        banneradapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(BannerHolder.class)
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {

                    }
                });

        chooseAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<FirstChooseBean>())
                .setLayout(R.layout.vlayout_home_choose)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChooseHolder.class)
                .setListener(new ItemListener<FirstChooseBean>() {
                    @Override
                    public void onItemClick(View view, int position, FirstChooseBean mData) {

                    }
                });

        festivalAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<FestivalBean>())
                .setLayout(R.layout.vlayout_home_festival)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(FestivalHolder.class)
                .setListener(new ItemListener<FestivalBean>() {
                    @Override
                    public void onItemClick(View view, int position, FestivalBean mData) {

                    }
                });

        hotAdapter=new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<HotBean>())
                .setLayout(R.layout.vlayout_home_hot)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(Hotholder.class)
                .setListener(new ItemListener<HotBean>() {
                    @Override
                    public void onItemClick(View view, int position,HotBean mData) {

                    }
                });

        recommendAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RecommendBean>())
                .setLayout(R.layout.vlayout_home_recomment)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(RecommendHolder.class)
                .setListener(new ItemListener<RecommendBean>() {
                    @Override
                    public void onItemClick(View view, int position, RecommendBean mData) {

                    }
                });

        startAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<StarBean>())
                .setLayout(R.layout.vlayout_home_start)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(StartHolder.class)
                .setListener(new ItemListener<StarBean>() {
                    @Override
                    public void onItemClick(View view, int position, StarBean mData) {

                    }
                });
        delegateAdapter.addAdapter(banneradapter);
        mRecycler.setAdapter(delegateAdapter);

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
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void successBanner(List<BannerBean> bannerBean) {
//        bannerBeans.add(bannerBean);
        Log.e(TAG, "successBanner: "+bannerBean.size() );
        banneradapter.setData(bannerBean);
        banneradapter.notifyDataSetChanged();
    }



    @Override
    public void successFirst(FirstChooseBean firstChooseBean) {
            firstChooseBeans.add(firstChooseBean);
            festivalAdapter.setData(firstChooseBeans);
            festivalAdapter.notifyDataSetChanged();
    }

    @Override
    public void successRecommend(RecommendBean recommendBean) {
            recommendBeans.add(recommendBean);
            recommendAdapter.setData(recommendBeans);
            recommendAdapter.notifyDataSetChanged();
    }

    @Override
    public void successStar(StarBean starBean) {
            starBeans.add(starBean);
            startAdapter.setData(starBeans);
            startAdapter.notifyDataSetChanged();
    }

    @Override
    public void successHot(HotBean hotBean) {
            hotBeans.add(hotBean);
            hotAdapter.setData(hotBeans);
            hotAdapter.notifyDataSetChanged();
    }

    @Override
    public void successFestival(FestivalBean festivalBean) {
            festivalBeans.add(festivalBean);
            festivalAdapter.setData(festivalBeans);
            festivalAdapter.notifyDataSetChanged();
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }
}
