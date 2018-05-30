package com.example.administrator.jiayan_project.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.KeepPhoneBean;
import com.example.administrator.jiayan_project.db.bean.KeepPhoneBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class WelcomeActivity extends BaseActivity {
//    private List<KeepPhoneBean> list=new ArrayList<>();
    private  List<KeepPhoneBean> list;
private static final String TAG = "WelcomeActivity";
    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       list = GreenDaoManager.getInstance().getSession().getKeepPhoneBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(300)//只获取结果集的前 3 个数据
                .orderDesc(KeepPhoneBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        Log.e(TAG, "onCreate:杀杀杀杀杀杀杀杀杀s"+list.size() );

//        setContentView(R.layout.activity_welcome);
        Observable.timer(0,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
//                        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                        if (list.size()==0){
                            startActivity(new Intent(WelcomeActivity.this,IntroActivityActivity.class));
                        }else {
                            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                        }
                        finish();
                    }
                });
    }
}
