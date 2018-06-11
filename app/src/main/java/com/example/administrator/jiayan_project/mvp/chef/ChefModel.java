package com.example.administrator.jiayan_project.mvp.chef;

import android.content.Context;


import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/11/011.
 */

public class ChefModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<ChefMsgBean> chefMsgBeanCall;
    private Context context;
    private Api api; 
    public ChefModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void ChefAll(final IBaseRequestCallBack<ChefMsgBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getChef()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChefMsgBean>() {
                    @Override
                    public void accept(ChefMsgBean cartBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(cartBean);
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
