package com.example.administrator.jiayan_project.ui.base;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentActivity;


/**
 * Created by 鱼握拳 on 2017/12/12.
 */

public abstract class BaseActivity extends QMUIFragmentActivity {
    /**
     * 获取状态栏的高度
     * @param fragment
     * @return
     */
    private static final String TAG = "BaseActivity";
    public int getStatusBarHeight(Fragment fragment) {
        double statusBarHeight = Math.ceil(25 * fragment.getResources().getDisplayMetrics().density);
        return (int) statusBarHeight;
    }

    /**
     * 处理后台返回应用为空
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        if(outState!=null){
            FragmentManager manager = getSupportFragmentManager();
            manager.popBackStackImmediate(null, 1);
        }
    }
}
