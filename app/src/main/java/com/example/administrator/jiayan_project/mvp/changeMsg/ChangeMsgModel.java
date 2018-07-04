package com.example.administrator.jiayan_project.mvp.changeMsg;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.banquet.KeepFavoriteBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.mine.ChangeMsgBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.io.File;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/7/4/004.
 */

public class ChangeMsgModel extends BaseModel {
        private Call<FavoritrResultBean> favouriteBeanCall;
        private CompositeDisposable mcompositeDisposable;
        private Context context;
        private Api api;
    public  ChangeMsgModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void chageMsg (int userid, MultipartBody.Part  file, final IBaseRequestCallBack<FavoritrResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.postMineMsg(file,userid)
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
        if(favouriteBeanCall!= null && !favouriteBeanCall.isCanceled()){
            favouriteBeanCall.cancel();
        }
    }
}
