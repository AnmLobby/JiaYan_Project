package com.example.administrator.jiayan_project.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpActivity;
import com.example.administrator.jiayan_project.mvp.login.LoginPresenter;
import com.example.administrator.jiayan_project.mvp.login.LoginView;
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

public class LoginActivity extends AbstractMvpActivity<LoginView, LoginPresenter> implements LoginView {

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
    private String i;
    private static final String TAG = "LoginActivity";
//    @Override
//    protected int getContextViewId() {
//        return R.id.qmuidemo;
//    }

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
                i= "%23code%23%3d"+String.valueOf(getRandNum(1,999999));
                getPresenter().clickRequest(etMobile.getText().toString().trim(),i);
                Log.e(TAG, "accept: "+i );
                huoquPwd.setEnabled(false);
                //从0开始发射11个数字为：0-10依次输出，延时0s执行，每1s发射一次。
                mdDisposable = Flowable.intervalRange(0, 7, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                huoquPwd.setText("重新获取(" + (6 - aLong) + ")");
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
                String s="%23code%23%3d"+etPassword.getText().toString().trim();
                if (s.equals(i)){
                    Log.e(TAG, "true" );
                }else {
                    Log.e(TAG, "false" );
                }
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

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    public static int getRandNum(int min, int max) {
        int randNum = min + (int)(Math.random() * ((max - min) + 1));
        return randNum;
    }
    public void rand(){
        System.out.println("随机数为" + getRandNum(1,999999));
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "re三双 "+result );
    }

    @Override
    public void resultUserSuccess(UserBean userBean) {
        String  code= String.valueOf(userBean.getError_code());
        if (code.equals("0")){
            Toast.makeText(this, "请留意短信", Toast.LENGTH_SHORT).show();
        }
        if (code.equals("205401")){
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        }
        Log.e(TAG, "啊啊 "+userBean.getError_code() );
    }
}
