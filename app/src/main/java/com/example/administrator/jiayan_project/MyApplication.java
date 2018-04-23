package com.example.administrator.jiayan_project;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.jiayan_project.db.bean.DaoMaster;
import com.example.administrator.jiayan_project.db.bean.DaoSession;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.AppContextUtil;
import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by Administrator on 2017/12/26.
 */

public class MyApplication extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

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
        Fresco.initialize(this);
        GreenDaoManager.getInstance();
    }

}

