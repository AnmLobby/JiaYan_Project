package com.example.administrator.jiayan_project.ui.fragment.recruit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.regesigt_list.ChefResignDataBean;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegListBean;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegPresenter;
import com.example.administrator.jiayan_project.mvp.regesigt_list.RegView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.SearchFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.VlayoutLayoutHelper;
import com.example.administrator.jiayan_project.utils.weight.WageDialog;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.mine.GridHolder;
import com.example.administrator.jiayan_project.vlayout.mine.JifenHolder;
import com.example.administrator.jiayan_project.vlayout.recruit.RecruitGridHolder;
import com.example.administrator.jiayan_project.vlayout.recruit.RecruitImageHolder;
import com.example.administrator.jiayan_project.vlayout.recruit.RecruitTextviewHolder;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 英才招聘界面
 */
public class CookRegisterFragment extends AbstractMvpFragment<RegView, RegPresenter> implements RegView  {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecycler;
    private VlayoutBaseAdapter gridAdapter,imageAdapter,textviewAdapter;
    private DelegateAdapter delegateAdapter;
    private Context mContext;
    private List<IconBean> iconBeanList=new ArrayList<>();
    private List<RegListBean> regListBeans=new ArrayList<>();
    private QMUITipDialog tipDialog;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cook_register, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestNews();
        initTopBar();
        initRecyclerView();
        initVlayout();
        initBean();
        return layout;
    }

    private void initBean() {


    }

    private void initVlayout() {
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefResignDataBean>())
                .setLayout(R.layout.vlayout_cook_grid)
                .setHolder(RecruitGridHolder.class)
                .setLayoutHelper(VlayoutLayoutHelper.getGridTwoLayoutHelper())
                .setListener(new ItemListener<ChefResignDataBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefResignDataBean mData) {
                        int i=mData.getId();
                        CookRegisterPostFragment cookRegisterFragment=new CookRegisterPostFragment();
                        Bundle bundle=new Bundle();
                        bundle.putInt("id",i);
                        cookRegisterFragment.setArguments(bundle);
                        startFragment(cookRegisterFragment);
                    }
                });
        imageAdapter= new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RegListBean>())
                .setLayout(R.layout.recruit_image)
                .setHolder(RecruitImageHolder.class)
                .setLayoutHelper(new LinearLayoutHelper())
                .setListener(new ItemListener<RegListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RegListBean mData) {

                    }
                });
        textviewAdapter= new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<RegListBean>())
                .setLayout(R.layout.recruit_textview)
                .setHolder(RecruitTextviewHolder.class)
                .setLayoutHelper(new LinearLayoutHelper())
                .setListener(new ItemListener<RegListBean>() {
                    @Override
                    public void onItemClick(View view, int position, RegListBean mData) {

                    }
                });
        delegateAdapter.addAdapter(imageAdapter);
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(textviewAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    private void initRecyclerView() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initTopBar() {
        mTopBar.addRightImageButton(R.mipmap.wage_order, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //薪资标准dialog
                final WageDialog wageDialog=new WageDialog(getActivity());
                wageDialog.setYesOnclickListener(new WageDialog.onCloseOnclickListener() {
                    @Override
                    public void onYesClick() {
                        wageDialog.dismiss();
                    }
                });
                wageDialog.show();
            }
        });
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("英才聘用");
    }
    @Override
    protected boolean canDragBack() {
        return false;
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
        Toast.makeText(MyApplication.getContext(), "出错了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resultBannerSuccess(RegListBean regListBean) {
        regListBeans.add(regListBean);
        imageAdapter.setData(regListBeans);
        imageAdapter.notifyDataSetChanged();

        textviewAdapter.setData(regListBeans);
        textviewAdapter.notifyDataSetChanged();

        gridAdapter.setData(regListBean.getChefResignData());
        gridAdapter.notifyDataSetChanged();
        mRecycler.setVisibility(View.VISIBLE);
        tipDialog.dismiss();
    }

    @Override
    public RegPresenter createPresenter() {
        return new RegPresenter();
    }
}
