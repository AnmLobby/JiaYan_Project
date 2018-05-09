package com.example.administrator.jiayan_project.ui.fragment.main;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.TitieBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetOrderFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BookSuccessFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.AboutFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.DeliveryFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.JifenFragment;
import com.example.administrator.jiayan_project.ui.fragment.recruit.CookRegisterFragment;
import com.example.administrator.jiayan_project.ui.fragment.recruit.TestRecycleFragment;
import com.example.administrator.jiayan_project.ui.fragment.yan_news.YanNewsMainFragment;
import com.example.administrator.jiayan_project.utils.util.VlayoutLayoutHelper;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.mine.GridHolder;
import com.example.administrator.jiayan_project.vlayout.mine.TitleHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面，底部栏第四个
 */
public class MineFragment extends BaseFragment {
    private static final String TAG = "MineFragment";
    @BindView(R.id.recyclerview)
    FatRecyclerview mRecycler;
    @BindView(R.id.yuelayout)
    LinearLayout yuelayout;
    @BindView(R.id.chongzhilayout)
    LinearLayout chongzhilayout;
    @BindView(R.id.jifenlayout)
    LinearLayout jifenlayout;
    private VlayoutBaseAdapter gridAdapter, titleAdapter;
    private DelegateAdapter delegateAdapter;
    private Context mContext;
    private IconBean[] iconBeans = {new IconBean("我的收藏", R.mipmap.aa),
            new IconBean("开通会员", R.mipmap.mhuiyuan), new IconBean("收货地址", R.mipmap.mshouhuo)
            , new IconBean("我的评价", R.mipmap.mpingjia), new IconBean("服务说明", R.mipmap.mfuwu),
            new IconBean("电话客服", R.mipmap.mcall), new IconBean("电子卡卷", R.mipmap.mkajuan),
            new IconBean("分享好友", R.mipmap.mfenxiang),
    };
    private TitieBean[] titieBeans = {new TitieBean("W")};
    private List<TitieBean> titie = new ArrayList<>();
    private List<IconBean> iconBeanList = new ArrayList<>();

    @Override
    protected View onCreateView() {
        CoordinatorLayout layout = (CoordinatorLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this, layout);
        initRecycler();
        initVlayout();
        initBean();
        return layout;
    }

    private void initBean() {
        iconBeanList.clear();
        for (int i = 0; i < iconBeans.length; i++) {
            iconBeanList.add(iconBeans[i]);

        }


        titie.add(titieBeans[0]);
        titleAdapter.setData(titie);
        titleAdapter.notifyDataSetChanged();


        gridAdapter.setData(iconBeanList);
        gridAdapter.notifyDataSetChanged();
    }


    private void initRecycler() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initVlayout() {
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<IconBean>())
                .setLayout(R.layout.vlayout_mine_grid)
                .setHolder(GridHolder.class)
                .setLayoutHelper(VlayoutLayoutHelper.getGridLayoutHelper())
                .setListener(new ItemListener<IconBean>() {
                    @Override
                    public void onItemClick(View view, int position, IconBean mData) {
                        switch (String.valueOf(position)) {
                            case "0":
                                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View detailcontent = inflater.inflate(R.layout.dialog_detail, null);
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setView(detailcontent);
                                builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                builder.show();
                                break;
                            case "1":
                                startFragment(new CookRegisterFragment());
                                break;
                            case "2":
                                startFragment(new DeliveryFragment());
                                break;
                            case "3":
                                startFragment(new BookSuccessFragment());
                                break;
                            case"4":
                                startFragment(new YanNewsMainFragment());
                                break;
                            case"5":
                                startFragment(new TestRecycleFragment());
                                break;
                            case"6":
                                startFragment(new BanquetOrderFragment());
                                break;
                            case "7":
                                startFragment(new SearchFragment());
                                break;
                            default:
                        }
                    }
                });
        titleAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<TitieBean>())
                .setLayout(R.layout.vlayout_mine_title)
                .setHolder(TitleHolder.class)
                .setTitle("常用工具")
                .setLayoutHelper(new LinearLayoutHelper());
        delegateAdapter.addAdapter(titleAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.yuelayout, R.id.chongzhilayout, R.id.jifenlayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yuelayout:
                break;
            case R.id.chongzhilayout:
                break;
            case R.id.jifenlayout:
                startFragment(new JifenFragment());
                break;
        }
    }

//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        if (mItemAnimator != null) {
//            mItemAnimator.endAnimations();
//        }
//        mFirstLayoutComplete = false;
//        stopScroll();
//        mIsAttached = false;
//        if (mLayout != null) {
//            mLayout.onDetachedFromWindow(this, mRecycler);
//        }
//        removeCallbacks(mItemAnimatorRunner);
//    }
}
