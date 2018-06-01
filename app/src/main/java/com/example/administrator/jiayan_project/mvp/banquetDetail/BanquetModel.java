package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class BanquetModel extends BaseModel {
    private Call<BanquetBean> banquetBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  BanquetModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }

    public void getBanquet(String id, final IBaseRequestCallBack<BanquetBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getBanquet(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BanquetBean>() {
                    @Override
                    public void accept(BanquetBean banquetBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(banquetBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }


    public void interruptHttp(){
        if(banquetBeanCall != null && !banquetBeanCall.isCanceled()){
            banquetBeanCall.cancel();
        }
    }
}
