package com.example.administrator.jiayan_project.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpActivity;
import com.example.administrator.jiayan_project.mvp.login.LoginPresenter;
import com.example.administrator.jiayan_project.mvp.login.LoginView;

import java.util.ArrayList;
import java.util.List;
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
    private String phone;
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
                if (etMobile.getText().toString().trim().length() < 11) {
                    Toast.makeText(MyApplication.getContext(), "手机号码格式错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                i= "%23code%23%3d"+String.valueOf(getRandNum(1,999999));
                getPresenter().clickRequest(etMobile.getText().toString().trim(),i);
                phone=etMobile.getText().toString().trim();
                Log.e(TAG, "accept: "+i );
                huoquPwd.setEnabled(false);
                //从0开始发射11个数字为：0-10依次输出，延时0s执行，每1s发射一次。
                mdDisposable = Flowable.intervalRange(0, 61, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                huoquPwd.setText("重新获取(" + (60 - aLong) + ")");
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
//                    Log.e(TAG, "true" );
                    getPresenter().clickPostMessage(phone);
//                    Toast.makeText(this, "准备跳转", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
//                    finish();

                }else {
                    Log.e(TAG, "false" );
                    Toast.makeText(this, "验证码错误，请输入正确的验证码", Toast.LENGTH_SHORT).show();
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

//    @Override
//    public void resultLoginSuccess(LoginBean loginBean) {
//
//        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
//                    finish();
//    }


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
    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void resultUserSuccess(UserBean userBean) {
        String  code= String.valueOf(userBean.getError_code());
        if (code.equals("0")){
            Toast.makeText(this, "短信已发送，请留意手机接收短信", Toast.LENGTH_SHORT).show();
        }
        if (code.equals("205401")){
            Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        }
        if (code.equals("205405")){
            Toast.makeText(this, "发送短信短语频繁，请稍后再试", Toast.LENGTH_SHORT).show();
        }
        if (code.equals("205403")){
            Toast.makeText(this, "网络错误,请重试", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void resultLoginSuccess(List<LoginBean> loginBean) {
        List<KeepUserBean> keepUserBeans ;

        keepUserBeans = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 3 个数据
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        Log.e(TAG, "尚未添加的长度 "+ keepUserBeans.size());

        KeepUserBeanDao addressBeanDao= GreenDaoManager.getInstance().getSession().getKeepUserBeanDao();
        KeepUserBean addressBean=new KeepUserBean();
        addressBean.setUserId(loginBean.get(0).getId());
        addressBean.setAge(loginBean.get(0).getAge());
        addressBean.setAvatar(loginBean.get(0).getAvatar());
        addressBean.setGender(loginBean.get(0).getGender());
        addressBean.setGroup_id(loginBean.get(0).getGroup_id());
        addressBean.setLevel(loginBean.get(0).getLevel());
        addressBean.setMobile(loginBean.get(0).getMobile());
        addressBean.setNickname(loginBean.get(0).getNickname());
//        if (loginBean.get(0).getRealname().isEmpty()){
//            addressBean.setNickname("null");
//        }else {
//            addressBean.setNickname(loginBean.get(0).getRealname());
//        }
//        if (loginBean.get(0).getAvatar().isEmpty()){
//            addressBean.setNickname("null");
//        }else {
//            addressBean.setNickname(loginBean.get(0).getAvatar());
//        }

        addressBean.setUsername(loginBean.get(0).getUsername());
        addressBeanDao.insert(addressBean);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//        Log.e(TAG, "打印消息"+loginBean.get(0).getRealname()+loginBean.get(0).getUsername());
//
//        Log.e(TAG, "resultLogin "+loginBean );
//        Log.e(TAG, "获取数据库长度 "+ keepUserBeans.size());
//        Log.e(TAG, "resultLoginSuccess: "+loginBean.size() );
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_still);
                    finish();
    }


}
