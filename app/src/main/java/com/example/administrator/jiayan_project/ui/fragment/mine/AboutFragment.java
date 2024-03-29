package com.example.administrator.jiayan_project.ui.fragment.mine;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 关于宴万家fragment
 */

public class AboutFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_about, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);

        ButterKnife.bind(this, layout);
        initTopBar();
        return  layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle(ContantsName.AboutName);
    }
//        mTopBar.addLeftImageButton(R.mipmap.ic_back,R.id.qmui_topbar_item_left_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popBackStack();
//            }
//        });
}
