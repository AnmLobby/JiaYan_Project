package com.example.administrator.jiayan_project.ui.base;


import android.view.KeyEvent;

import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public  abstract class BaseFragment extends QMUIFragment {

    public BaseFragment() {
    }


    @Override
    protected int backViewInitOffset() {
        return QMUIDisplayHelper.dp2px(getContext(), 0);
    }

    public int getStatusBarHeight(BaseFragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
