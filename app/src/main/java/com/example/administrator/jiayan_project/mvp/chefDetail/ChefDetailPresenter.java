package com.example.administrator.jiayan_project.mvp.chefDetail;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.chef_classify.ChefClassifyModel;
import com.example.administrator.jiayan_project.mvp.chef_classify.ChefClassifyView;

/**
 * Created by Administrator on 2018/6/15/015.
 */

public class ChefDetailPresenter extends AbstractMvpPersenter<ChefDetailView> {
    private ChefDetailModel chefDetailModel;
    public ChefDetailPresenter() {
        this.chefDetailModel= new ChefDetailModel(MyApplication.getContext());
    }
    public void clickRequestCart(final int id) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                chefDetailModel.getChefDetailBanner(id, new IBaseRequestCallBack<ChefDetailBannerBean>() {
//                    @Override
//                    public void requestError(Throwable throwable) {
//                        if (getmMvpView() != null) {
//                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
//                        }
//                    }
//
//                    @Override
//                    public void requestSuccess(ChefDetailBannerBean cartBean) {
//                        if (getmMvpView() != null) {
//                            getmMvpView().resultChefBannerSuccess(cartBean);
//                        }
//                    }
//                });
//                chefDetailModel.getChefDetailComment(id, new IBaseRequestCallBack<ChefDetailCommentBean>() {
//                    @Override
//                    public void requestError(Throwable throwable) {
//                        if (getmMvpView() != null) {
//                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
//                        }
//                    }
//
//                    @Override
//                    public void requestSuccess(ChefDetailCommentBean cartBean) {
//                        if (getmMvpView() != null) {
//                            getmMvpView().resultChefCommentSuccess(cartBean);
//                        }
//                    }
//                });
                chefDetailModel.getChefDetailMsg(id, new IBaseRequestCallBack<ChefDetailMsgBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ChefDetailMsgBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultChefMsgSuccess(cartBean);
                        }
                    }
                });
            }
        }, 10);
    }
//    public  void  addToMyCart(int userid,int cookerid,int serve) {
//        chefDetailModel.getChefDetailMsg(userid, cookerid, serve, new IBaseRequestCallBack<FavoritrResultBean>() {
//            @Override
//            public void requestError(Throwable throwable) {
//                if (getmMvpView() != null) {
//                    getmMvpView().resultFailure(Log.getStackTraceString(throwable));
//                }
//            }
//
//            @Override
//            public void requestSuccess(FavoritrResultBean cartBean) {
//                if (getmMvpView() != null) {
//                    getmMvpView().resultAddChefSuccess(cartBean);
//                }
//            }
//        });
//    }
public  void  addToMyCart(final int userid, final int cookerid, final int serve) {
    if (getmMvpView() != null) {
        getmMvpView().requestLoading();
    }
    //模拟网络延迟，可以显示出加载中
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            chefDetailModel.addChefCart(userid,cookerid,serve, new IBaseRequestCallBack<FavoritrResultBean>() {
                @Override
                public void requestError(Throwable throwable) {
                    if (getmMvpView() != null) {
                        getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                    }
                }

                @Override
                public void requestSuccess(FavoritrResultBean cartBean) {
                    if (getmMvpView() != null) {
                        getmMvpView().resultAddChefSuccess(cartBean);
                    }
                }
            });
        }
    }, 10);


}
}