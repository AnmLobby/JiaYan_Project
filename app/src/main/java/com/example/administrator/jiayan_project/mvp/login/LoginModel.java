package com.example.administrator.jiayan_project.mvp.login;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.login.LoginBean;
import com.example.administrator.jiayan_project.enity.login.UserBean;
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
 * Created by 鱼握拳 on 2018/4/27.
 */

public class LoginModel extends BaseModel {
    private Call<UserBean> userBeanCall;
    private Call<LoginBean> loginBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api,mainAPi;
    public  LoginModel(Context mContext) {
        super();
        context = mContext;
        api = loginManager.getService();
        mainAPi=retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void loginIn(String phone,String password,final IBaseRequestCallBack<UserBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postUser(phone,password,"6c980c4ab7b574935234355bfe217e10","75662")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(userBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void loginUser(String phone,final IBaseListCallBack<LoginBean> iBaseRequestCallBack){
        mcompositeDisposable.add(mainAPi.postMessage(phone)
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
        if(userBeanCall != null && !userBeanCall.isCanceled()){
            userBeanCall.cancel();
        }
        if(loginBeanCall != null && !loginBeanCall.isCanceled()){
            loginBeanCall.cancel();
        }
    }
}
