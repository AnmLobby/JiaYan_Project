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

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.VlayoutLayoutHelper;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.mine.GridHolder;
import com.example.administrator.jiayan_project.vlayout.mine.JifenHolder;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 英才招聘界面
 */
public class CookRegisterFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView mRecycler;
    private VlayoutBaseAdapter gridAdapter;
    private IconBean[] iconBeans={new IconBean("厨师",R.mipmap.chef),
            new IconBean("厨工",R.mipmap.kwork),new IconBean("面点师",R.mipmap.pastry)
            ,new IconBean("营养师",R.mipmap.nutrition)
    };
    private DelegateAdapter delegateAdapter;
    private Context mContext;
    private List<IconBean> iconBeanList=new ArrayList<>();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cook_register, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        initRecyclerView();
        initVlayout();
        initBean();
        return layout;
    }

    private void initBean() {
        iconBeanList.clear();
        for (int i = 0; i <iconBeans.length ; i++) {
            iconBeanList.add(iconBeans[i]);

        }
        gridAdapter.setData(iconBeanList);
        gridAdapter.notifyDataSetChanged();

    }

    private void initVlayout() {
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<IconBean>())
                .setLayout(R.layout.vlayout_cook_grid)
                .setHolder(GridHolder.class)
                .setLayoutHelper(VlayoutLayoutHelper.getGridTwoLayoutHelper())
                .setListener(new ItemListener<IconBean>() {
                    @Override
                    public void onItemClick(View view, int position, IconBean mData) {
                        switch (String.valueOf(position)){
                            case "0":
                                break;
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            default:
                        }
                    }
                });
        delegateAdapter.addAdapter(gridAdapter);
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
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("英才聘用");
    }
}
