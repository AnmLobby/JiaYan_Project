package com.example.administrator.jiayan_project.ui.fragment.yan_news;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import butterknife.ButterKnife;


public class ViedeoFragment extends BaseFragment {


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viedeo, null);
        ButterKnife.bind(this, layout);
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }

}

