package com.example.administrator.jiayan_project.mvp.homepage;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.enity.homepage.FestivalBean;
import com.example.administrator.jiayan_project.enity.homepage.FirstChooseBean;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.homepage.RecommendBean;
import com.example.administrator.jiayan_project.enity.homepage.StarBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseListCallBack;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/11.
 */

public class HomePresenter extends AbstractMvpPersenter<HomeView> {
    private HomeModel homeModel;
    public HomePresenter(){
        homeModel=new HomeModel(MyApplication.getContext());
    }
    public void clickRequest(){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                homeModel.RequestBanner(new IBaseRequestCallBack<BannerBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BannerBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successBanner(callBack);
                        }
                    }


                });
                homeModel.RequestFesival(new IBaseRequestCallBack<FestivalBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(FestivalBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successFestival(callBack);
                        }
                    }

                });
                homeModel.RequestFirst(new IBaseRequestCallBack<FirstChooseBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(FirstChooseBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successFirst(callBack);
                        }
                    }
                });
                homeModel.RequestHot(new IBaseRequestCallBack<HotBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(HotBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successHot(callBack);
                        }
                    }
                });
                homeModel.RequestRecom(new IBaseRequestCallBack<RecommendBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(RecommendBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successRecommend(callBack);
                        }
                    }
                });
                homeModel.RequestStar(new IBaseRequestCallBack<StarBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(StarBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successStar(callBack);
                        }
                    }
                });
                homeModel.RequestNews(new IBaseRequestCallBack<NewsBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(NewsBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successNews(callBack);
                        }
                    }
                });
            }
        },1);
    }
    public void interruptHttp(){
        homeModel.interruptHttp();
    }
}
