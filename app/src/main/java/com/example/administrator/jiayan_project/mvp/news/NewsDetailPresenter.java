package com.example.administrator.jiayan_project.mvp.news;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.login.UserBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.login.LoginView;

/**
 * Created by Administrator on 2018/5/30/030.
 */

public class NewsDetailPresenter extends AbstractMvpPersenter<NewsDetailView> {
    private NewsDetailModel newsDetailModel;
    public NewsDetailPresenter(){
        this.newsDetailModel=new NewsDetailModel(MyApplication.getContext());
    }
    public void clickRequestNews(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newsDetailModel.getDetailNews(id,new IBaseRequestCallBack<NewsDetailBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(NewsDetailBean newsDetailBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultUserSuccess(newsDetailBean);
                        }
                    }
                });
            }
        }, 10);
    }
}
