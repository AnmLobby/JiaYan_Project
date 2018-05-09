package com.example.administrator.jiayan_project.mvp.homepage;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.homepage.BannerBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseListCallBack;

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
                homeModel.RequestBanner(new IBaseListCallBack<BannerBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if(getmMvpView() != null){
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(List<BannerBean> callBack) {
                        if(getmMvpView() != null){
                            getmMvpView().successBanner(callBack);
                        }
                    }



                });

            }
        },1);
    }
}
