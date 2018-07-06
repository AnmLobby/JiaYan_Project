package com.example.administrator.jiayan_project.mvp.changeMsg;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteModel;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteView;

import java.io.File;

import okhttp3.MultipartBody;

/**
 * Created by Administrator on 2018/7/4/004.
 */

public class ChangeMsgPresenter extends AbstractMvpPersenter<ChangeMsgView> {
    private ChangeMsgModel myFavoriteModel;

    public ChangeMsgPresenter() {
        this.myFavoriteModel = new ChangeMsgModel(MyApplication.getContext());
    }

    public void postMineMsg(final int id, final MultipartBody.Part file) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myFavoriteModel.chageMsg(id,file,new IBaseRequestCallBack<FavoritrResultBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(FavoritrResultBean favoritrResultBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultPostSuccess(favoritrResultBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void postMineMsgAll(final int id, final String nickname, final String realname) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myFavoriteModel.chageMsgAll(id,nickname,realname,new IBaseRequestCallBack<FavoritrResultBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }
                    @Override
                    public void requestSuccess(FavoritrResultBean favoritrResultBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultPostMsgSuccess(favoritrResultBean);
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
