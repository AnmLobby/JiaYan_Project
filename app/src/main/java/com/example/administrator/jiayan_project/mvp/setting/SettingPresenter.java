package com.example.administrator.jiayan_project.mvp.setting;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.mine.UpdateAppInfo;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.reception.ReceptionModel;
import com.example.administrator.jiayan_project.mvp.reception.ReceptionView;

/**
 * Created by Administrator on 2018/6/25/025.
 */

public class SettingPresenter extends AbstractMvpPersenter<SettingView> {
    private SettingModel settingModel;
    public SettingPresenter() {
        this.settingModel= new SettingModel(MyApplication.getContext());
    }
    public void clickRequestUpdate() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                settingModel.loadUpdate( new IBaseRequestCallBack<UpdateAppInfo>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(UpdateAppInfo updateAppInfo) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultUpdateSuccess(updateAppInfo);
                        }
                    }
                });
            }
        }, 10);
    }
}