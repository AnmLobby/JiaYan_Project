package com.example.administrator.jiayan_project.ui.fragment.mine_payorder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OrderBlankFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_blank, container, false);
    }

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_about, null);
        ButterKnife.bind(this, layout);
        initTopBar();
        return  layout;
    }
    private void initTopBar() {

        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.MyOrder);
    }

}
