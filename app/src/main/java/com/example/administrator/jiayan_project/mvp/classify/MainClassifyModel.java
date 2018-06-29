package com.example.administrator.jiayan_project.mvp.classify;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chef.CookRegesigtBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/29/029.
 */

public class MainClassifyModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<ClassifyBean> chefMsgBeanCall;
    private Context context;
    private Api api;
    public MainClassifyModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void getClassify(final IBaseRequestCallBack<ClassifyBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getClassify()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ClassifyBean>() {
                    @Override
                    public void accept(ClassifyBean classifyBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(classifyBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){

        if(chefMsgBeanCall != null && !chefMsgBeanCall.isCanceled()){
            chefMsgBeanCall.cancel();
        }
    }
}

