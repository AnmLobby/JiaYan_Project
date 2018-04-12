package com.example.administrator.jiayan_project;

import android.app.Application;
import android.content.Context;

import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.AppContextUtil;


/**
 * Created by Administrator on 2017/12/26.
 */

public class MyApplication extends Application {
    public static Context applicationContext;
    public static Context getContext() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this);
        applicationContext = this;
        new RudenessScreenHelper(this, 1080).activate();
    }
}

