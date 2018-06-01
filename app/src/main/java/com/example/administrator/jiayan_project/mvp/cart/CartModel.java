package com.example.administrator.jiayan_project.mvp.cart;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseListCallBack;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/5/16/016.
 */

public class CartModel extends BaseModel{
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    private Call<CartBean> cartBeanCall;
    public CartModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void CartAll(final IBaseRequestCallBack<CartBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCart()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
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
        if(cartBeanCall != null && !cartBeanCall.isCanceled()){
            cartBeanCall.cancel();
        }
    }
}
