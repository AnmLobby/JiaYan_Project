package com.example.administrator.jiayan_project.mvp.banquetDetail;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetDetailBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetNumBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

/**
 * Created by Administrator on 2018/7/12/012.
 */

public class BanquetCommentPresenter extends AbstractMvpPersenter<BanquetCommentView> {
    private BanquetCommentModel banquetModel;

    public BanquetCommentPresenter() {
        this.banquetModel = new BanquetCommentModel(MyApplication.getContext());
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
                banquetModel.getBanquetComment(id, new IBaseRequestCallBack<BanquetComentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetComentBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetCommentSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 300);
    }
    public void clickRequestBanquetGood(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                banquetModel.getBanquetCommentGood(id, new IBaseRequestCallBack<BanquetComentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetComentBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetCommentGoodSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 300);
    }
    public void clickRequestBanquetMid(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                banquetModel.getBanquetCommentMid(id, new IBaseRequestCallBack<BanquetComentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetComentBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetCommentMidSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 300);
    }
    public void clickRequestBanquetCha(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                banquetModel.getBanquetCommentCha(id, new IBaseRequestCallBack<BanquetComentBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetComentBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetCommentChaSuccess(banquetBean);
                        }
                    }
                });
            }
        }, 300);
    }

    public void clickRequestBanquetNum(final String id) {
        //获取View
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                banquetModel.getBanquetCommentNum(id, new IBaseRequestCallBack<BanquetNumBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(BanquetNumBean banquetBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultBanquetCommentNumSuccess(banquetBean);
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