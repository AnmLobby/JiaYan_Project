package com.example.administrator.jiayan_project.mvp.mine;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseListCallBack;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/7/6/006.
 */

public class MineModel extends BaseModel {
    private Call<LoginBean> loginBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  MineModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void loginUser(String phone,final IBaseListCallBack<LoginBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postMessage(phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<LoginBean>>() {
                    @Override
                    public void accept(List<LoginBean> loginBean) throws Exception {

                        iBaseRequestCallBack.requestBannerSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(loginBeanCall!= null && !loginBeanCall.isCanceled()){
            loginBeanCall.cancel();
        }
    }
}
