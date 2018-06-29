package com.example.administrator.jiayan_project.ui.fragment.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.BigYanAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.MainClassifyAdapter;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyPresenter;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyView;
import com.example.administrator.jiayan_project.mvp.search.SearchRequestPresenter;
import com.example.administrator.jiayan_project.mvp.search.SearchRequestView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TypeFragment extends AbstractMvpFragment<MainClassifyView, MainClassifyPresenter> implements MainClassifyView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private List<ClassifyBean.TypedataBean> classBeans=new ArrayList<>();
    private MainClassifyAdapter mainClassifyAdapter;
    private static final String TAG = "TypeFragment";
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_type, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestClassify();
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultRegisterSuccess(ClassifyBean classifyBean) {
        classBeans=classifyBean.getTypedata();
        mainClassifyAdapter = new MainClassifyAdapter(classBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainClassifyAdapter);
//        mainClassifyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Log.e(TAG, "onItemClick: 水水水水水水水水水水水水水水" );
//            }
//        });
    }

    @Override
    public MainClassifyPresenter createPresenter() {
        return new MainClassifyPresenter();
    }
}
