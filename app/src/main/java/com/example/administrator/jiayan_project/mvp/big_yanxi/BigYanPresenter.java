package com.example.administrator.jiayan_project.mvp.big_yanxi;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.big.BigYanBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.news_list.NewsModel;

/**
 * Created by Administrator on 2018/6/4/004.
 */

public class BigYanPresenter extends AbstractMvpPersenter<BigYanView> {

    private BigYanModel bigYanModel;
    public BigYanPresenter(){
        this.bigYanModel=new BigYanModel(MyApplication.getContext());
    }
    public void clickRequestBigYan(){
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bigYanModel.getBigYan(new IBaseRequestCallBack<BigYanBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(BigYanBean bigYanBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultYanListSuccess(bigYanBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void clickPostLove(final int userid,final int dinnerid) {
        bigYanModel.postKeepFavorite(userid,dinnerid,new IBaseRequestCallBack<FavoritrResultBean>() {
            @Override
            public void requestError(Throwable throwable) {
                if (getmMvpView() != null) {
                    getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                }
            }
            @Override
            public void requestSuccess(FavoritrResultBean favoritrResultBean) {
                if (getmMvpView() != null) {
                    getmMvpView().resultKeepFavoriteSuccess(favoritrResultBean);
                }
            }
        });
    }
}
