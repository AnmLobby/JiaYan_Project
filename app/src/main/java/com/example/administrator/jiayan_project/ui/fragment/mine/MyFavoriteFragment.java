package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import butterknife.ButterKnife;


public class MyFavoriteFragment extends BaseFragment {



    @Override
    protected View onCreateView() {
        FrameLayout layout = ( FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_favorite, null);
        ButterKnife.bind(this, layout);
        return layout;
    }

}
