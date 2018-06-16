package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import butterknife.ButterKnife;

/**
 * 丢弃
 */
public class ChefTablayoutFragment extends BaseFragment {
    public static ChefTablayoutFragment newInstance(int position) {
        Bundle args = new Bundle();
//        args.putString(PATH, path[position]);
        ChefTablayoutFragment fragment = new ChefTablayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected View onCreateView() {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chef_tablayout, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
}
