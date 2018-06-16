package com.example.administrator.jiayan_project.mvp.chefDetail;

/**
 * Created by Administrator on 2018/6/15/015.
 */

import android.content.Context;

import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * 厨师个人信息展示页面。轮播图。个人信息以及评价
 */
public class ChefDetailModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<ChefDetailBannerBean> chefClassifyBeanCall;
    private Call<ChefDetailMsgBean> chefDetailMsgBeanCall;
    private Call<ChefDetailCommentBean> chefDetailCommentBeanCall;
    private Context context;
    private Api api;
    public ChefDetailModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void getChefDetailBanner(int id,final IBaseRequestCallBack<ChefDetailBannerBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getChefDetailBanner(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChefDetailBannerBean>() {
                    @Override
                    public void accept(ChefDetailBannerBean chefDetailBannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(chefDetailBannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getChefDetailComment(int id,final IBaseRequestCallBack<ChefDetailCommentBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getChefDetailComment(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChefDetailCommentBean>() {
                    @Override
                    public void accept(ChefDetailCommentBean chefDetailBannerBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(chefDetailBannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getChefDetailMsg(int id,final IBaseRequestCallBack<ChefDetailMsgBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getChefDetailMsg(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChefDetailMsgBean>() {
                    @Override
                    public void accept(ChefDetailMsgBean chefDetailBannerBean) throws Exception {
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
