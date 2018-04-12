package com.example.administrator.jiayan_project.ui.fragment.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.mine.IconBean;
import com.example.administrator.jiayan_project.enity.mine.TitieBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.SettingFragment;
import com.example.administrator.jiayan_project.utils.util.VlayoutLayoutHelper;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.example.administrator.jiayan_project.vlayout.mine.GridHolder;
import com.example.administrator.jiayan_project.vlayout.mine.TitleHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MineFragment extends BaseFragment {
    private static final String TAG = "MineFragment";
    @BindView(R.id.recyclerview)
    RecyclerView mRecycler;
    private VlayoutBaseAdapter gridAdapter,titleAdapter;
    private DelegateAdapter delegateAdapter;
    private Context mContext;
    private IconBean[] iconBeans={new IconBean("我的收藏",R.mipmap.oo),
            new IconBean("开通会员",R.mipmap.huiyuan),new IconBean("收货地址",R.mipmap.shouhuo)
            ,new IconBean("我的评价",R.mipmap.pingjia),new IconBean("服务说明",R.mipmap.fuwu),
            new IconBean("电话客服",R.mipmap.kefu),new IconBean("电子卡卷",R.mipmap.kajuan),
            new IconBean("分享好友",R.mipmap.fenxiang),
        };
    private TitieBean[] titieBeans={new TitieBean("W")};
    private  List<TitieBean> titie=new ArrayList<>();
    private  List<IconBean> iconBeanList=new ArrayList<>();

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
        for (int i = 0; i <iconBeans.length ; i++) {
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
                       switch (String.valueOf(position)){
                           case "0":
                               LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                               View detailcontent=inflater.inflate(R.layout.dialog_detail,null);
                               AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setView(detailcontent);
                               builder.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialog, int which) {
                                     dialog.dismiss();
                                   }
                               });
                               builder.show();
                               break;
                           default:
                       }
                    }
                });
        titleAdapter= new VlayoutBaseAdapter(mContext)
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
    public void onDestroyView() {
        super.onDestroyView();
    }
}
