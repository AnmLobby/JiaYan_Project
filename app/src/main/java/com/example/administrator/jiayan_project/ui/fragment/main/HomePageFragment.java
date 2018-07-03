package com.example.administrator.jiayan_project.ui.fragment.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.DataBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.homepage.HomePresenter;
import com.example.administrator.jiayan_project.mvp.homepage.HomeView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BookSuccessFragment;
import com.example.administrator.jiayan_project.ui.fragment.big.BigYanFragment;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.ReceptionFragment;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.WZServiceFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.DeliveryFragment;

import com.example.administrator.jiayan_project.ui.fragment.recruit.CookRegisterFragment;
import com.example.administrator.jiayan_project.ui.fragment.yan_news.NewsDetailFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.BannerHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.BaonianHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.ChooseHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.FestivalHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.HeadHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.Hotholder;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.homepage.NewsHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.RecommendHolder;
import com.example.administrator.jiayan_project.vlayout.homepage.StartHolder;
import com.example.administrator.jiayan_project.vlayout.mine.GridHolder;
import com.vondear.rxtools.activity.ActivityScanerCode;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页面，底部栏第一个
 */
public class HomePageFragment extends AbstractMvpFragment<HomeView, HomePresenter> implements HomeView {
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.erweima)
    ImageView erweima;
    private Banner banner = new Banner(MyApplication.getContext());
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VlayoutBaseAdapter banneradapter, festivalAdapter, chooseAdapter, hotAdapter, recommendAdapter, startAdapter, tOnewAdapter, tTwoadapter, threeAdapter, gridAdapter, newsAdapter,baonianAdapter;
    private List<BannerBean> bannerBeans = new ArrayList<>();
    private List<FestivalBean> festivalBeans = new ArrayList<>();
    private List<FirstChooseBean> firstChooseBeans = new ArrayList<>();
    private List<HotBean> hotBeans = new ArrayList<>();
    private List<RecommendBean> recommendBeans = new ArrayList<>();
    private List<StarBean> starBeans = new ArrayList<>();
    private List<NewsBean> newsBeans = new ArrayList<>();
    private static final String TAG = "HomePageFragment";
    private VirtualLayoutManager virtualLayoutManager;
    private IconBean[] iconBeans = {new IconBean("大型酒席", R.mipmap.b_yanxi),
            new IconBean("万众服务", R.mipmap.w_fuwu), new IconBean("高级接待", R.mipmap.g_siyan)
    };
    private List<IconBean> iconBeanList = new ArrayList<>();

    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_page, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequest();
        virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        initVlayout();
        initBean();

        return layout;
    }

    private void initBean() {
        iconBeanList.clear();
        for (int i = 0; i < iconBeans.length; i++) {
            iconBeanList.add(iconBeans[i]);

        }
        gridAdapter.setData(iconBeanList);
        gridAdapter.notifyDataSetChanged();
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
                        String id = String.valueOf(mData.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());

//                     startFragment(new BlankOneFragment());
                    }
                });
        //超值首选
        chooseAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<FirstChooseBean>())
                .setLayout(R.layout.vlayout_home_choose)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChooseHolder.class)
                .setListener(new ItemListener<FirstChooseBean>() {
                    @Override
                    public void onItemClick(View view, int position, FirstChooseBean mData) {
                        String id = String.valueOf(mData.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
        festivalAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<DataBean>())
                .setLayout(R.layout.vlayout_home_festival)
                .setLayoutHelper(getGridLayoutHelper())
                .setHolder(FestivalHolder.class)
                .setListener(new ItemListener<DataBean>() {
                    @Override
                    public void onItemClick(View view, int position, DataBean mData) {
                        String id = String.valueOf(mData.getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());

                    }
                });
        hotAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<HotBean>())
                .setLayout(R.layout.vlayout_home_hot)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(Hotholder.class)
                .setListener(new ItemListener<HotBean>() {
                    @Override
                    public void onItemClick(View view, int position, HotBean mData) {

                        String id = String.valueOf(mData.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
        //新品推荐
        recommendAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<DataBean>())
                .setLayout(R.layout.vlayout_home_recomment)
                .setLayoutHelper(getGridTwoLayoutHelper())
                .setHolder(RecommendHolder.class)
                .setListener(new ItemListener<DataBean>() {
                    @Override
                    public void onItemClick(View view, int position, DataBean mData) {
                        String id = String.valueOf(mData.getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
//特色
        startAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<DataBean>())
                .setLayout(R.layout.vlayout_home_start)
                .setLayoutHelper(getGridLayoutHelper())
                .setHolder(StartHolder.class)
                .setListener(new ItemListener<DataBean>() {
                    @Override
                    public void onItemClick(View view, int position, DataBean mData) {
                        String id = String.valueOf(mData.getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
//                        Bundle bundle=new Bundle();
//                        bundle.putString("iid",id);
//                        BanquetFragment banquetFragment=new BanquetFragment();
//                        banquetFragment.setArguments(bundle);
//                        Log.e(TAG, "onItemClick: "+id );

//                        Log.e(TAG, "onItemClickaaaaaaaaaaaaaaaa: " );
                    }
                });
        tOnewAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.recyclerview_head)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(HeadHolder.class)
                .setTitle("新品推荐")
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {

                    }
                });
        tTwoadapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.recyclerview_head)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(HeadHolder.class)
                .setTitle("特色美食")
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {

                    }
                });
        threeAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.recyclerview_head)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(HeadHolder.class)
                .setTitle("节日盛宴")
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {

                    }
                });
        baonianAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<BannerBean>())
                .setLayout(R.layout.vlayout_home_baonian)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(BaonianHolder.class)
                .setListener(new ItemListener<BannerBean>() {
                    @Override
                    public void onItemClick(View view, int position, BannerBean mData) {

                    }
                });
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<IconBean>())
                .setLayout(R.layout.vlayout_home_grid)
                .setHolder(GridHolder.class)
                .setLayoutHelper(getGridLayoutHelper())
                .setListener(new ItemListener<IconBean>() {
                    @Override
                    public void onItemClick(View view, int position, IconBean mData) {
                        switch (String.valueOf(position)) {
                            case "0":
                                startFragment(new BigYanFragment());
                                break;
                            case "1":
                                startFragment(new WZServiceFragment());
//                                startFragment(new CookRegisterFragment());
                                break;
                            case "2":
//                                startFragment(new DeliveryFragment());
                                startFragment(new ReceptionFragment());
                                break;
                            default:
                        }
                    }
                });
        newsAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<NewsBean>())
                .setLayout(R.layout.vlayout_home_news)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(NewsHolder.class)
                .setListener(new ItemListener<NewsBean>() {
                    @Override
                    public void onItemClick(View view, int position, NewsBean mData) {
                        String id = String.valueOf(mData.getData().get(position).getId());
                        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("id", id);
                        newsDetailFragment.setArguments(bundle);
                        startFragment(newsDetailFragment);
//                        Log.e(TAG, "onItemClick: "+id );
                    }
                });
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(newsAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(baonianAdapter);
        delegateAdapter.addAdapter(chooseAdapter);
        delegateAdapter.addAdapter(tOnewAdapter);
        delegateAdapter.addAdapter(recommendAdapter);
        delegateAdapter.addAdapter(tTwoadapter);
        delegateAdapter.addAdapter(startAdapter);
        delegateAdapter.addAdapter(hotAdapter);
        delegateAdapter.addAdapter(threeAdapter);
        delegateAdapter.addAdapter(festivalAdapter);
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
        Log.e(TAG, "resultFailure: " + result);
    }

    @Override
    public void successBanner(BannerBean bannerBean) {
        bannerBeans.add(bannerBean);
        banneradapter.setData(bannerBeans);
        banneradapter.notifyDataSetChanged();

        tOnewAdapter.setData(bannerBeans);
        tOnewAdapter.notifyDataSetChanged();

        tTwoadapter.setData(bannerBeans);
        tTwoadapter.notifyDataSetChanged();

        threeAdapter.setData(bannerBeans);
        threeAdapter.notifyDataSetChanged();

        baonianAdapter.setData(bannerBeans);
        baonianAdapter.notifyDataSetChanged();
    }

    @Override
    public void successFirst(FirstChooseBean firstChooseBeann) {
        firstChooseBeans.add(firstChooseBeann);
        chooseAdapter.setData(firstChooseBeans);
        chooseAdapter.notifyDataSetChanged();
    }

    @Override
    public void successRecommend(RecommendBean recommendBean) {
//        recommendBeans.add(recommendBean);
        recommendAdapter.setData(recommendBean.getData());
        recommendAdapter.notifyDataSetChanged();
//

    }

    @Override
    public void successStar(StarBean starBean) {
//        starBeans.add(starBean);
        startAdapter.setData(starBean.getData());
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
//        festivalBeans.add(festivalBean);
        festivalAdapter.setData(festivalBean.getData());
        festivalAdapter.notifyDataSetChanged();
    }

    @Override
    public void successNews(NewsBean newsBean) {
        newsBeans.add(newsBean);
        newsAdapter.setData(newsBeans);
        newsAdapter.notifyDataSetChanged();
    }

    private LayoutHelper getGridLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(3);
        gridHelper.setMarginTop(20);
        gridHelper.setWeights(new float[]{33.3f, 33.3f, 33.3f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(4);
        //设置水平方向条目的间隔
        gridHelper.setHGap(4);
        gridHelper.setMarginLeft(5);
        gridHelper.setMarginBottom(5);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
    }

    private LayoutHelper getGridTwoLayoutHelper() {
        GridLayoutHelper gridHelper = new GridLayoutHelper(2);
        gridHelper.setMarginTop(20);
        gridHelper.setWeights(new float[]{ 50f, 50f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(4);
        //设置水平方向条目的间隔
        gridHelper.setHGap(4);
        gridHelper.setMarginLeft(5);
        gridHelper.setMarginBottom(5);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        return gridHelper;
    }


    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }
    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.stopAutoPlay();
    }

    @OnClick({R.id.search, R.id.erweima})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search:
                startFragment(new SearchFragment());
                break;
            case R.id.erweima:
                Intent intent=new Intent(MyApplication.getContext(),ActivityScanerCode.class);
                startActivity(intent);
                break;
        }
    }
}
