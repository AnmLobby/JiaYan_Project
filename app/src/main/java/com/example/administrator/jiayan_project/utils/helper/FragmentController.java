package com.example.administrator.jiayan_project.utils.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SettingFragment;
import com.qmuiteam.qmui.arch.QMUIFragment;
import com.qmuiteam.qmui.arch.QMUIFragmentActivity;

/**
 * Created by 鱼握拳 on 2018/4/18.
 */

public class FragmentController {
    private FragmentController mHomeControlListener;

    public static volatile FragmentController activityController;

    public static FragmentController getInstance() {
        if (activityController == null) {
            synchronized (FragmentController.class) {
                if (activityController == null) {
                    activityController = new FragmentController();
                }
            }
        }
        return activityController;
    }
    
    
    public void startEditAddressActivityWithAddress(Context context, AddressBean address) {
        SettingFragment settingFragment=new SettingFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("address", address);
        settingFragment.setArguments(bundle);

        startFragment(new SetAddressFragment());
    }

    protected void startFragment(BaseFragment fragment) {
        if (mHomeControlListener != null) {
            mHomeControlListener.startFragment(fragment);
        }
    }
}
