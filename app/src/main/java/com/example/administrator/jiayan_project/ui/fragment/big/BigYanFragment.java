package com.example.administrator.jiayan_project.ui.fragment.big;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.BigYanAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanPresenter;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BigYanFragment extends AbstractMvpFragment<BigYanView, BigYanPresenter> implements BigYanView {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView  recyclerView;
    private static final String TAG = "BigYanFragment";
    private List<BigYanBean.DataBean> dataBeans;
    private BigYanAdapter bigYanAdapter;
    private List<KeepUserBean> list;
    private int userid;
    private QMUITipDialog tipDialog;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_big_yan, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 1 个数据
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        userid=list.get(0).getUserId();
        getPresenter().clickRequestBigYan();
        return layout;
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
    }

    @Override
    public void resultYanListSuccess(BigYanBean newsListBean) {
        dataBeans=newsListBean.getData();
        bigYanAdapter = new BigYanAdapter(dataBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        recyclerView.setAdapter(bigYanAdapter);
        bigYanAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String id= String.valueOf(bigYanAdapter.getData().get(position).getId());
                getPresenter().AddToCart(userid,1,1, Integer.parseInt(id),10);
            }
        });
        bigYanAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id= String.valueOf(bigYanAdapter.getData().get(position).getId());
                EventBus.getDefault().postSticky(new StartNewsEvent(id));
                startFragment(new BlankOneFragment());
            }
        });
        //给RecyclerView设置适配器
        tipDialog.dismiss();
    }

    @Override
    public void resultAddMyCartSuccess(FavoritrResultBean favoritrResultBean) {
        Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public BigYanPresenter createPresenter() {
        return new BigYanPresenter();
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.LargeBanQuet);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
