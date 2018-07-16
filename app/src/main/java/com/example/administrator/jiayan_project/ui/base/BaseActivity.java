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
     * t通过QMUI能获取到。无需自己写
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
     * 7-10 注释掉 ，在低版本Android4.4 会出现EventBus报错  java.lang.NoClassDefFoundError: android/os/PersistableBundle
     * 处理后台返回应用为空，有下图标
     *
     * 7-16导致界面全部为空，无下图标
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

//        6-13重新修改
        if(outState!=null){
            FragmentManager manager = getSupportFragmentManager();
            manager.popBackStackImmediate(null, 1);
        }
    }
}
