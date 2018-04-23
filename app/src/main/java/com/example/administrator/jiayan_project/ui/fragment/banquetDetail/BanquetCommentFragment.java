package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * 高级宴会菜单评论
 */
public class BanquetCommentFragment extends BaseFragment {



    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_comment, null);
        ButterKnife.bind(this, layout);
        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }


}
