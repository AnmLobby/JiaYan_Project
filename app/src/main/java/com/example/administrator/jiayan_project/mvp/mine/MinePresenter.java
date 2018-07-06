package com.example.administrator.jiayan_project.mvp.mine;

import android.os.Handler;
import android.util.Log;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseListCallBack;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6/006.
 */

public class MinePresenter extends AbstractMvpPersenter<MineView> {
    private MineModel loginModel;

    public MinePresenter () {
        this.loginModel=new MineModel(MyApplication.getContext());
    }

    public void clickPostMessage(final String phone) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginModel.loginUser(phone, new IBaseListCallBack<LoginBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestBannerSuccess(List<LoginBean> callBack) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultLoginSuccess(callBack);
                        }
                    }

//                    @Override
//                    public void requestSuccess(List<LoginBean> loginBean) {
//
//                    }
                });

            }
        }, 10);
    }
}
