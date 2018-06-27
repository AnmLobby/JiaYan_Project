package com.example.administrator.jiayan_project.mvp.setting;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.mine.UpdateAppInfo;
import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/25/025.
 */

public class SettingModel  extends BaseModel {
    private Context context = null;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    private Call<UpdateAppInfo> chefClassifyBeanCall;
    public SettingModel(Context mContext) {
        super();
        context = mContext;
        api = firManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }


    public void loadUpdate(final IBaseRequestCallBack<UpdateAppInfo> iBaseRequestCallBack) {
        mcompositeDisposable.add(api.getUpdateInfo("dc392760fe078b181f912fd7b6640bda")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<UpdateAppInfo>() {
                    @Override
                    public void accept(UpdateAppInfo updateAppInfo) throws Exception {
                        iBaseRequestCallBack.requestSuccess(updateAppInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(chefClassifyBeanCall != null && !chefClassifyBeanCall.isCanceled()){
            chefClassifyBeanCall.cancel();
        }
    }
}