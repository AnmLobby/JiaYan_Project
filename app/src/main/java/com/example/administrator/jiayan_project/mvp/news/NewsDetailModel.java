package com.example.administrator.jiayan_project.mvp.news;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.login.UserBean;
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
 * Created by Administrator on 2018/5/30/030.
 */

public class NewsDetailModel extends BaseModel {
    private Call<NewsDetailBean> newsDetailBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  NewsDetailModel(Context mContext) {
        super();
        context = mContext;
        api = loginManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void getDetailNews(String id, final IBaseRequestCallBack<NewsDetailBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswDetail(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsDetailBean>() {
                    @Override
                    public void accept(NewsDetailBean newsDetailBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(newsDetailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(newsDetailBeanCall != null && !newsDetailBeanCall.isCanceled()){
            newsDetailBeanCall.cancel();
        }
    }
}
