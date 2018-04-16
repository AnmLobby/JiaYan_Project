package com.example.administrator.jiayan_project.ui.fragment.main;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;


public class ClassifyFragment extends BaseFragment {
    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify, null);
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
