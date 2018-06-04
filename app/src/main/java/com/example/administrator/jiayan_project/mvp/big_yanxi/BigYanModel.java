package com.example.administrator.jiayan_project.mvp.big_yanxi;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/4/004.
 */

public class BigYanModel  extends BaseModel{
    private Call<BigYanBean> bigYanBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public BigYanModel(Context mContext){
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }

    public void getBigYan(final IBaseRequestCallBack<BigYanBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getBigYan()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BigYanBean>() {
                    @Override
                    public void accept(BigYanBean bigYanBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(bigYanBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void interruptHttp(){
        if(bigYanBeanCall!= null && !bigYanBeanCall.isCanceled()){
            bigYanBeanCall.cancel();
        }

    }

}
