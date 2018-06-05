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
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanPresenter;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.qmuiteam.qmui.widget.QMUITopBar;

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
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_big_yan, null);
        ButterKnife.bind(this, layout);

        getPresenter().clickRequestBigYan();
        return layout;
    }


    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: " );
    }

    @Override
    public void resultYanListSuccess(BigYanBean newsListBean) {
        Log.e(TAG, "resultYanListSuccess: " );
        dataBeans=newsListBean.getData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        initTopBar();
        //创建适配器
        bigYanAdapter = new BigYanAdapter(dataBeans);
        bigYanAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MyApplication.getContext(), "88888", Toast.LENGTH_SHORT).show();
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
        recyclerView.setAdapter(bigYanAdapter);
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
}
