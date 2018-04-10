package com.example.administrator.jiayan_project.ui.fragment.main;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;


public class ClassifyFragment extends BaseFragment {
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify, null);
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
