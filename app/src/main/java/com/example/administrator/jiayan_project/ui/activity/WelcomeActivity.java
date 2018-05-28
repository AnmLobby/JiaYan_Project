package com.example.administrator.jiayan_project.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);
        Observable.timer(0,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                    }
                });
    }
}
