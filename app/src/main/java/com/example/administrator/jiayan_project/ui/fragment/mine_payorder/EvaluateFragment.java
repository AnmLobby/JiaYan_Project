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
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 待评价
 */
public class EvaluateFragment extends BaseFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private View errorView;
    private List<UnpayBean> list=new ArrayList<>();
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_all_order, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        errorView= getLayoutInflater().inflate(R.layout.evaluate_empty, (ViewGroup) recyclerView.getParent(), false);
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
