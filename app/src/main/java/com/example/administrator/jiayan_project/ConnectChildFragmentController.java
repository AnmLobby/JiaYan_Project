package com.example.administrator.jiayan_project;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.jiayan_project.ui.fragment.main.CartFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.ClassifyFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.MineFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.AboutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/13.
 */

public class ConnectChildFragmentController {
    private int containerId;
    private FragmentManager fm;
    private List<Fragment> fragments;

    private static ConnectChildFragmentController controller;

    public static ConnectChildFragmentController getInstance(Fragment parentFragment, int containerId) {
        if (controller == null) {
            controller = new ConnectChildFragmentController(parentFragment, containerId);
        }
        return controller;
    }

    private ConnectChildFragmentController(Fragment fragment, int containerId) {
        this.containerId = containerId;
        //fragment嵌套fragment，调用getChildFragmentManager
        fm = fragment.getChildFragmentManager();

        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<Fragment>();

        fragments.add(new AboutFragment());
        fragments.add(new MineFragment());
//        fragments.add(new CartFragment());
//        fragments.add(new ClassifyFragment());

        FragmentTransaction ft = fm.beginTransaction();
        for(Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commit();
    }

    public List<Fragment> getFragmentList(){
        return  fragments;
    }

    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commit();
    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for(Fragment fragment : fragments) {
            if(fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
