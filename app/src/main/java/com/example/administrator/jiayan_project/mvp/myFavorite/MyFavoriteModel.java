package com.example.administrator.jiayan_project.mvp.myFavorite;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/6/5/005.
 */

public class MyFavoriteModel extends BaseModel {
    private Call<FavouriteBean> favouriteBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  MyFavoriteModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void getMyFavorite(String username, final IBaseRequestCallBack<FavouriteBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMyFavorite(username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FavouriteBean>() {
                    @Override
                    public void accept(FavouriteBean favouriteBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(favouriteBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(favouriteBeanCall!= null && !favouriteBeanCall.isCanceled()){
            favouriteBeanCall.cancel();
        }
    }
}
