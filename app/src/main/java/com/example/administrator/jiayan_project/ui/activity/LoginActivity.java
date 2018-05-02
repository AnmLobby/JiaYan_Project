package com.example.administrator.jiayan_project.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.huoqu_pwd)
    Button huoquPwd;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.wb)
    ImageView wb;
    @BindView(R.id.wx)
    ImageView wx;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.content)
    LinearLayout content;
    private Disposable mdDisposable;

    @Override
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.huoqu_pwd, R.id.login, R.id.wb, R.id.wx, R.id.qq})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huoqu_pwd:
                huoquPwd.setEnabled(false);
                //从0开始发射11个数字为：0-10依次输出，延时0s执行，每1s发射一次。
                mdDisposable = Flowable.intervalRange(0, 11, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                huoquPwd.setText("重新获取(" + (10 - aLong) + ")");
                            }
                        })
                        .doOnComplete(new Action() {
                            @Override
                            public void run() throws Exception {
                                //倒计时完毕置为可点击状态
                                huoquPwd.setEnabled(true);
                                huoquPwd.setText("获取验证码");
                            }
                        })
                        .subscribe();



                break;
            case R.id.login:
                break;
            case R.id.wb:
                break;
            case R.id.wx:
                break;
            case R.id.qq:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mdDisposable != null) {
            mdDisposable.dispose();
        }
    }


}
