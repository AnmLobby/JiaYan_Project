package com.example.administrator.jiayan_project.ui.fragment.mine_payorder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.order_adapter.RefundedAdapter;
import com.example.administrator.jiayan_project.enity.order.UnpayBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 已付款
 */
public class HavePayFragment extends BaseFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private View errorView;
    private List<UnpayBean> list=new ArrayList<>();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_have_pay, null);
        ButterKnife.bind(this, layout);
        errorView= getLayoutInflater().inflate(R.layout.havepay_empty, (ViewGroup) recyclerView.getParent(), false);
        RefundedAdapter refundedAdapter=new RefundedAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(refundedAdapter);
        refundedAdapter.setEmptyView(errorView);
        return  layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
