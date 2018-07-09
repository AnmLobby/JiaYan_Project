package com.example.administrator.jiayan_project.mvp.cart;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.banquet.PostAddCartBean;
import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.enity.cart.ShoppingChefBean;
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
    private Call<FavoritrResultBean> favoritrResultBeanCall;
    private Context context;
    private Api api;
    private Call<CartBean> cartBeanCall;
    public CartModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void CartAll(int userid,final IBaseRequestCallBack<CartBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMyCart(userid)
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

    public void CartAllChef(int userid,final IBaseRequestCallBack<ShoppingChefBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMyChefCart(userid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ShoppingChefBean>() {
                    @Override
                    public void accept(ShoppingChefBean cartBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(cartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }


    public void postAddCart(int userid,int detail,int num,int dinnerid,int ren, final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postDeleteCart(new PostAddCartBean(userid,detail,num,dinnerid,ren))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FavoritrResultBean>() {
                    @Override
                    public void accept(FavoritrResultBean favoritrResultBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(favoritrResultBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void changeCart(int id,int num, final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getChangeMyCart(id,num)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FavoritrResultBean>() {
                    @Override
                    public void accept(FavoritrResultBean favoritrResultBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(favoritrResultBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void deleteChefCart(int id,final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postDeleteMyChefCart(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FavoritrResultBean>() {
                    @Override
                    public void accept(FavoritrResultBean favoritrResultBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(favoritrResultBean);
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
        if(favoritrResultBeanCall != null && !favoritrResultBeanCall.isCanceled()){
            favoritrResultBeanCall.cancel();
        }
    }
}
