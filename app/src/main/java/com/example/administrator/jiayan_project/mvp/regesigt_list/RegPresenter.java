package com.example.administrator.jiayan_project.mvp.regesigt_list;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteModel;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteView;

/**
 * Created by Administrator on 2018/6/16/016.
 */

public class RegPresenter extends AbstractMvpPersenter<RegView> {
    private RegModel regModel;

    public RegPresenter() {
        this.regModel = new RegModel(MyApplication.getContext());
    }

    public void clickRequestNews() {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                regModel.getRegList(new IBaseRequestCallBack<RegListBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(RegListBean favouriteBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBannerSuccess(favouriteBean);
                        }
                    }
                });
            }
        }, 10);
    }

    public void interruptHttp() {
       regModel.interruptHttp();
    }
}
