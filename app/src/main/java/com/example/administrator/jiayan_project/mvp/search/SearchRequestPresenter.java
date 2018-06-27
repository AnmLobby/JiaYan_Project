package com.example.administrator.jiayan_project.mvp.search;

import android.os.Handler;
import android.util.Log;


import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.search.HotSearchBean;
import com.example.administrator.jiayan_project.enity.search.SearchResultBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public class SearchRequestPresenter extends AbstractMvpPersenter<SearchRequestView> {
    private final  SearchRequestModel searchRequestModel;
    public SearchRequestPresenter(){
        searchRequestModel=new SearchRequestModel(MyApplication.getContext());
    }
    public void clickRequestResult(final String name){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchRequestModel.RequestQuery(name, new IBaseRequestCallBack<SearchResultBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(SearchResultBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().resultSearchSuccess(callBack);
                        }
                    }

            });
            }
        },1);
    }
    public void clickRequestList(){
        //获取View
        if(getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                searchRequestModel.RequestList( new IBaseRequestCallBack<HotSearchBean>()  {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(HotSearchBean callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().hotListSuccess(callBack);
                        }
                    }
                });
            }
        },1);
    }
    public void interruptHttp(){
        searchRequestModel.interruptHttp();
    }
}
