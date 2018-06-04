package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailModel;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailView;

/**
 * Created by Administrator on 2018/6/1/001.
 */

public class BanquetPresenter extends AbstractMvpPersenter<BanquetView> {
    private BanquetModel banquetModel;
    public BanquetPresenter(){
        this.banquetModel=new BanquetModel(MyApplication.getContext());
    }
    public void clickRequestBanquet(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                banquetModel.getBanquet(id,new IBaseRequestCallBack<BanquetBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(BanquetBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 1000);
    }
    public void interruptHttp(){
        banquetModel.interruptHttp();
    }
}
