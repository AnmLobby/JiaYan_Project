package com.example.administrator.jiayan_project.mvp.more;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.homepage.MoreYanBean;
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
 * Created by Administrator on 2018/7/3/003.
 */

public class MoreYanModel extends BaseModel {
    private Call<MoreYanBean> moreYanBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  MoreYanModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void requestMore(String phone,final IBaseRequestCallBack<MoreYanBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMore(phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MoreYanBean>() {
                    @Override
                    public void accept(MoreYanBean loginBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(moreYanBeanCall!= null && !moreYanBeanCall.isCanceled()){
            moreYanBeanCall.cancel();
        }
    }
}
