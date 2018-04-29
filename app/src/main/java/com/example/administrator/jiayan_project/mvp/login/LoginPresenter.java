package com.example.administrator.jiayan_project.mvp.login;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

/**
 * Created by 鱼握拳 on 2018/4/27.
 */

public class LoginPresenter extends AbstractMvpPersenter<LoginView> {
    private LoginModel loginModel;
    public LoginPresenter () {
        this.loginModel=new LoginModel(MyApplication.getContext());
    }

    public void clickRequest(final String phone, final String password) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginModel.loginIn(phone,password, new IBaseRequestCallBack<UserBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(UserBean userBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultUserSuccess(userBean);
                        }
                    }
                });

            }
        }, 10);
    }
}
