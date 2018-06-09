package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.CheckFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.banquet.KeepFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.PostAddCartBean;
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
    private Call<FavoritrResultBean> favoritrResultBeanCall;
    private Call<CheckFavoriteBean> checkFavoriteBeanCall;
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
    public void postKeepFavorite(int userid,int dinnerid, final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postMyFavorite(new KeepFavoriteBean(userid,dinnerid))
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
    public void getChecjFavorite(int userid,int dinnerid, final IBaseRequestCallBack<CheckFavoriteBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCheckFavorite(userid,dinnerid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CheckFavoriteBean>() {
                    @Override
                    public void accept(CheckFavoriteBean checkFavoriteBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(checkFavoriteBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void postAddCart(int userid,int detail,int num,int dinnerid,int ren, final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postAddCart(new PostAddCartBean(userid,detail,num,dinnerid,ren))
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
        if(banquetBeanCall != null && !banquetBeanCall.isCanceled()){
            banquetBeanCall.cancel();
        }
        if(favoritrResultBeanCall != null && !favoritrResultBeanCall.isCanceled()){
            favoritrResultBeanCall.cancel();
        }
        if(checkFavoriteBeanCall != null && !checkFavoriteBeanCall.isCanceled()){
            checkFavoriteBeanCall.cancel();
        }
    }
}
