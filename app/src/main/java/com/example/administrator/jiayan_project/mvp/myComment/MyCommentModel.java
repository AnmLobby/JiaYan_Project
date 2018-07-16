package com.example.administrator.jiayan_project.mvp.myComment;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.mine.MyChefCommentBean;
import com.example.administrator.jiayan_project.enity.mine.MyCommentBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class MyCommentModel extends BaseModel {
    private Call<MyCommentBean> favouriteBeanCall;
    private Call<MyChefCommentBean> myChefCommentBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  MyCommentModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void getMyComment(int id, final IBaseRequestCallBack<MyCommentBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getMyBanquetComment(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MyCommentBean>() {
                    @Override
                    public void accept(MyCommentBean favouriteBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(favouriteBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void getMyChefComment(int id, final IBaseRequestCallBack<MyChefCommentBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api. getMyComment(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MyChefCommentBean>() {
                    @Override
                    public void accept(MyChefCommentBean favouriteBean) throws Exception {

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
        if(myChefCommentBeanCall!= null && !myChefCommentBeanCall.isCanceled()){
            myChefCommentBeanCall.cancel();
        }
    }
}
