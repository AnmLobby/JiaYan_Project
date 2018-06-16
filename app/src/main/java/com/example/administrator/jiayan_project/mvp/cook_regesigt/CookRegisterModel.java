package com.example.administrator.jiayan_project.mvp.cook_regesigt;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.chef.CookRegesigtBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/14/014.
 */

/**
 * 厨师注册
 */
public class CookRegisterModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<FavoritrResultBean> chefMsgBeanCall;
    private Context context;
    private Api api;
    public CookRegisterModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void CookRegister(String id,String name,String age,String sex,String address,String mobile,String cookage,final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postCookRegister(new CookRegesigtBean(id,name,age,sex,address,mobile,cookage))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FavoritrResultBean>() {
                    @Override
                    public void accept(FavoritrResultBean cartBean) throws Exception {
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
