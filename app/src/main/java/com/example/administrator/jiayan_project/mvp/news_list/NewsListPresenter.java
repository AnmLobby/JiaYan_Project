package com.example.administrator.jiayan_project.mvp.news_list;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class NewsListPresenter extends AbstractMvpPersenter<NewsListView> {
    private NewsModel newsModel;
    public NewsListPresenter(){
        this.newsModel=new NewsModel(MyApplication.getContext());
    }
    public void clickRequestHomeNews(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsModel.getHomeNews(new IBaseRequestCallBack<NewsListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsListBean newsListBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultNewsListSuccess(newsListBean);
                        }
                    }
                });
            }
        }, 10);

    }
    public void clickRequestYanNews(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsModel.getNewsYan(new IBaseRequestCallBack<NewsListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsListBean newsListBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultNewsListSuccess(newsListBean);
                        }
                    }
                });
            }
        }, 10);

    }
    public void clickRequestActivityNews(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsModel.getNewsActivity(new IBaseRequestCallBack<NewsListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsListBean newsListBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultNewsListSuccess(newsListBean);
                        }
                    }
                });
            }
        }, 10);

    }
    public void clickRequestXueNews(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsModel.getNewsXue(new IBaseRequestCallBack<NewsListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsListBean newsListBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultNewsListSuccess(newsListBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void clickRequestVideoNews(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsModel.getNewsVideo(new IBaseRequestCallBack<NewsListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsListBean newsVideoBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultVideoListSuccess(newsVideoBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void interruptHttp(){
        newsModel.interruptHttp();
    }
}
