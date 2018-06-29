package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/27/027.
 */

public class BanquetDetailModel extends BaseModel {
    private Call<BanquetDetailBean> banquetBeanCall;
    private Context context;
    private Api api;
    private CompositeDisposable mcompositeDisposable;
    public  BanquetDetailModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void getBanquetDetail(String id, final IBaseRequestCallBack<BanquetDetailBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getBanquetDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BanquetDetailBean>() {
                    @Override
                    public void accept(BanquetDetailBean banquetBean) throws Exception {

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
