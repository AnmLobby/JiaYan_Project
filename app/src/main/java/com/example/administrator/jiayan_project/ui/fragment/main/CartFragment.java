package com.example.administrator.jiayan_project.ui.fragment.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.vondear.rxtools.view.dialog.RxDialogShapeLoading;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购物车fragment，底部栏第三个
 */
public class CartFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;


    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cart, null);
        ButterKnife.bind(this, layout);
        initTopBar();
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
    private void initTopBar() {
//        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popBackStack();
//            }
//        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle("购物车");
    }
}
