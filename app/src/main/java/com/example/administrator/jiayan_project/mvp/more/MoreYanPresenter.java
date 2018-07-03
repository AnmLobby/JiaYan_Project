package com.example.administrator.jiayan_project.mvp.more;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.login.LoginModel;
import com.example.administrator.jiayan_project.mvp.login.LoginView;

/**
 * Created by Administrator on 2018/7/3/003.
 */

public class MoreYanPresenter extends AbstractMvpPersenter<MoreYanView> {
    private MoreYanModel loginModel;

    public MoreYanPresenter() {
        this.loginModel = new MoreYanModel(MyApplication.getContext());
    }

    public void clickRequest(final String phone) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginModel.requestMore(phone, new IBaseRequestCallBack<MoreYanBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(MoreYanBean userBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultMoreSuccess(userBean);
                        }
                    }
                });

            }
        }, 10);
    }
    public void interruptHttp(){
        loginModel.interruptHttp();
    }
}
