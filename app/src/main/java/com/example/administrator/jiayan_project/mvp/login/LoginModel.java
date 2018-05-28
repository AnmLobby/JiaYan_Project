package com.example.administrator.jiayan_project.mvp.login;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

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
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  LoginModel(Context mContext) {
        super();
        context = mContext;
        api = loginManager.getService();
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
    public void interruptHttp(){
        if(userBeanCall != null && !userBeanCall.isCanceled()){
            userBeanCall.cancel();
        }
    }
}
