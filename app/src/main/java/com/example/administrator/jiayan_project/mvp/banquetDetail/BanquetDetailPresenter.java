package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/6/27/027.
 */

public class BanquetDetailPresenter extends AbstractMvpPersenter<BanquetDetailView> {
    private BanquetDetailModel banquetModel;

    public BanquetDetailPresenter() {
        this.banquetModel = new BanquetDetailModel(MyApplication.getContext());
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
                banquetModel.getBanquetDetail(id, new IBaseRequestCallBack<BanquetDetailBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetDetailBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetDetailSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 300);
    }
    public void interruptHttp(){
        banquetModel.interruptHttp();
    }
}