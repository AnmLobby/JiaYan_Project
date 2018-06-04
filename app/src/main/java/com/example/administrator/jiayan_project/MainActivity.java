package com.example.administrator.jiayan_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.jiayan_project.ui.base.BaseActivity;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.MainFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.AboutFragment;
import com.example.administrator.jiayan_project.ui.fragment.yan_news.YanNewsMainFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity{


    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            BaseFragment fragment = new MainFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(getContextViewId(), fragment, fragment.getClass().getSimpleName())
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .commit();
        }
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void onMoonEvent(StartNewsEvent startNewsEvent){
        if (startNewsEvent.getMessage()==null){
            startFragment(new YanNewsMainFragment());
        }
    }
}
