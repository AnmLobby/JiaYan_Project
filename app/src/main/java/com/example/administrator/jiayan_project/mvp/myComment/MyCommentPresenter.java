package com.example.administrator.jiayan_project.mvp.myComment;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;

import com.example.administrator.jiayan_project.enity.mine.MyChefCommentBean;
import com.example.administrator.jiayan_project.enity.mine.MyCommentBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteModel;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteView;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class MyCommentPresenter extends AbstractMvpPersenter<MyCommentView> {
    private MyCommentModel myFavoriteModel;

    public MyCommentPresenter() {
        this.myFavoriteModel = new MyCommentModel(MyApplication.getContext());
    }

    public void clickRequestNMyComment(final int id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myFavoriteModel.getMyComment(id, new IBaseRequestCallBack<MyCommentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(MyCommentBean favouriteBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultMyCommentSuccess(favouriteBean);
                        }
                    }
                });
            }
        }, 10);
    }
    public void clickRequestMyChefComment(final int id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                myFavoriteModel.getMyChefComment(id, new IBaseRequestCallBack<MyChefCommentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(MyChefCommentBean favouriteBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultMyChefCommentSuccess(favouriteBean);
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
