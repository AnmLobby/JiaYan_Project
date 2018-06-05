package com.example.administrator.jiayan_project.mvp.myFavorite;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/6/5/005.
 */

public class MyFavoritePresenter extends AbstractMvpPersenter<MyFavoriteView> {
    private MyFavoriteModel myFavoriteModel;

    public MyFavoritePresenter() {
        this.myFavoriteModel = new MyFavoriteModel(MyApplication.getContext());
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
               myFavoriteModel.getMyFavorite(id, new IBaseRequestCallBack<FavouriteBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(FavouriteBean favouriteBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultMyFavoriteSuccess(favouriteBean);
                        }
                    }
                });
            }
        }, 10);
    }

    public void interruptHttp() {
        myFavoriteModel.interruptHttp();
    }
}
