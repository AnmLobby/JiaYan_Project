package com.example.administrator.jiayan_project.mvp.news_list;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
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

public class NewsModel extends BaseModel {
    private Call<NewsListBean> newsListBeanCall;
    private Call<NewsVideoBean> newsVideoBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  NewsModel(Context mContext) {
        super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void getHomeNews(final IBaseRequestCallBack<NewsListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswHome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsListBean>() {
                    @Override
                    public void accept(NewsListBean newsListBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(newsListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getNewsActivity(final IBaseRequestCallBack<NewsListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswActivity()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsListBean>() {
                    @Override
                    public void accept(NewsListBean newsListBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(newsListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getNewsXue(final IBaseRequestCallBack<NewsListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswXue()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsListBean>() {
                    @Override
                    public void accept(NewsListBean newsListBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(newsListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getNewsYan(final IBaseRequestCallBack<NewsListBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswYan()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsListBean>() {
                    @Override
                    public void accept(NewsListBean newsListBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(newsListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void getNewsVideo(final IBaseRequestCallBack<NewsVideoBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getNeswVideo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<NewsVideoBean>() {
                    @Override
                    public void accept(NewsVideoBean newsVideoBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(newsVideoBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(newsListBeanCall != null && !newsListBeanCall.isCanceled()){
            newsListBeanCall.cancel();
        }
        if(newsVideoBeanCall!= null && !newsVideoBeanCall.isCanceled()){
            newsVideoBeanCall.cancel();
        }
    }
}
