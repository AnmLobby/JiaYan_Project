package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.JifenBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
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
 * 积分兑换页面
 */
public class JifenFragment extends BaseFragment{
    @BindView(R.id.recyclerview)
    RecyclerView mRecycler;
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    private VlayoutBaseAdapter gridAdapter,priceAdapter;
    private IconBean[] iconBeans={new IconBean("积分8888",R.mipmap.jifenyue),
            new IconBean("兑换记录",R.mipmap.duihuanjilu),new IconBean("积分规则",R.mipmap.jifenguize)
    };
    private DelegateAdapter delegateAdapter;
    private Context mContext;
    private List<IconBean> iconBeanList=new ArrayList<>();
    private List<JifenBean> jifenBeans=new ArrayList<>();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_jifen, null);
        ButterKnife.bind(this, layout);
        initTopBar();
        initRecycler();
        initVlayout();
        initBean();
        return  layout;
    }

    private void initBean() {

        iconBeanList.clear();
        for (int i = 0; i <iconBeans.length ; i++) {
            iconBeanList.add(iconBeans[i]);

        }
        gridAdapter.setData(iconBeanList);
        gridAdapter.notifyDataSetChanged();

        priceAdapter.setData(jifenBeans);
        priceAdapter.notifyDataSetChanged();

    }

    private void initVlayout() {
        gridAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<IconBean>())
                .setLayout(R.layout.vlayout_mine_grid)
                .setHolder(GridHolder.class)
                .setLayoutHelper(VlayoutLayoutHelper.getGridThreeLayoutHelper())
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
                            default:
                        }
                    }
                });
        priceAdapter=new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<JifenBean>())
                .setLayout(R.layout.vlayout_jifen_duihuan)
                .setHolder(JifenHolder.class)
                .setLayoutHelper(new LinearLayoutHelper())
                .setListener(new ItemListener<JifenBean>() {
                    @Override
                    public void onItemClick(View view, int position, JifenBean mData) {

                    }
                });
        delegateAdapter.addAdapter(gridAdapter);
        delegateAdapter.addAdapter(priceAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.MyIntegral);
    }
    private void initRecycler() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }
}
