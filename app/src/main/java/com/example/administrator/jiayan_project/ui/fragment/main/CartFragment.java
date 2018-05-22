package com.example.administrator.jiayan_project.ui.fragment.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.vondear.rxtools.view.dialog.RxDialogShapeLoading;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 购物车fragment，底部栏第三个
 */
public class CartFragment extends BaseFragment {
    @BindView(R.id.one)
    Button one;

    private static final String TAG = "CartFragment";

    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cart, null);
        ButterKnife.bind(this, layout);


        onViewClicked(layout);
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @OnClick({R.id.one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one:

                break;
            default:
                break;
        }
    }

}
