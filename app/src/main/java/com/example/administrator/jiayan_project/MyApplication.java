package com.example.administrator.jiayan_project;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;

import com.example.administrator.jiayan_project.db.bean.DaoMaster;
import com.example.administrator.jiayan_project.db.bean.DaoSession;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.AppContextUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;
import com.vondear.rxtools.RxTool;
import com.vondear.rxtools.module.wechat.share.WechatShareTools;


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
        initX5Core();
        new RudenessScreenHelper(this, 1080).activate();
        Fresco.initialize(this);
        GreenDaoManager.getInstance();
        RxTool.init(this);
        WechatShareTools.init(this, "wx4a05b523f7d9fcb6");//初始化

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
    private void initX5Core() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功
                //否则表示x5内核加载失败，会自动切换到系统内核。
            }
            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
}

