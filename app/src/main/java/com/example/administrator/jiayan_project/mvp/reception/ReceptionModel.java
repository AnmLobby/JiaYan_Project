package com.example.administrator.jiayan_project.mvp.reception;

import android.content.Context;


import com.example.administrator.jiayan_project.enity.reception.ReceptionBannerBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionChefBean;
import com.example.administrator.jiayan_project.enity.reception.ReceptionDinnerBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ReceptionModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<ReceptionBannerBean> chefClassifyBeanCall;
    private Call<ReceptionDinnerBean> chefDetailMsgBeanCall;
    private Call<ReceptionChefBean> chefDetailCommentBeanCall;
    private Context context;
    private Api api;
    public ReceptionModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void getReceptionBanner(final IBaseRequestCallBack<ReceptionBannerBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getReceptionBanner()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ReceptionBannerBean>() {
                    @Override
                    public void accept(ReceptionBannerBean chefDetailBannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(chefDetailBannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getReceptionChef(final IBaseRequestCallBack<ReceptionChefBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getReceptionChef()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ReceptionChefBean>() {
                    @Override
                    public void accept(ReceptionChefBean chefDetailBannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(chefDetailBannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getReceptionDinner(final IBaseRequestCallBack<ReceptionDinnerBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getReceptionDinner()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ReceptionDinnerBean>() {
                    @Override
                    public void accept(ReceptionDinnerBean chefDetailBannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(chefDetailBannerBean);
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
        if(chefDetailMsgBeanCall != null && !chefDetailMsgBeanCall.isCanceled()){
            chefDetailMsgBeanCall.cancel();
        }
        if(chefDetailCommentBeanCall!= null && !chefDetailCommentBeanCall.isCanceled()){
            chefDetailCommentBeanCall.cancel();
        }
    }
}
