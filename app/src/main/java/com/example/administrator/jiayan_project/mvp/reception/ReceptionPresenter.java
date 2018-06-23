package com.example.administrator.jiayan_project.mvp.reception;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;

import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailModel;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ReceptionPresenter extends AbstractMvpPersenter<ReceptionView> {
    private ReceptionModel receptionModel;
    public ReceptionPresenter() {
        this.receptionModel= new ReceptionModel(MyApplication.getContext());
    }
    public void clickRequestCart() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                receptionModel.getReceptionBanner( new IBaseRequestCallBack<ReceptionBannerBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ReceptionBannerBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBannerSuccess(cartBean);
                        }
                    }
                });
                receptionModel.getReceptionChef( new IBaseRequestCallBack<ReceptionChefBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ReceptionChefBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultChefSuccess(cartBean);
                        }
                    }
                });
                receptionModel.getReceptionDinner( new IBaseRequestCallBack<ReceptionDinnerBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ReceptionDinnerBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultDinnerSuccess(cartBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void clickRequestDinner() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                receptionModel.getReceptionDinner( new IBaseRequestCallBack<ReceptionDinnerBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ReceptionDinnerBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultDinnerSuccess(cartBean);
                        }
                    }
                });
            }
        }, 10);
    }
}