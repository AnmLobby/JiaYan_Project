package com.example.administrator.jiayan_project.mvp.chef;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.cart.CartView;

/**
 * Created by Administrator on 2018/6/11/011.
 */

public class ChefPresenter  extends AbstractMvpPersenter<ChefView> {
    private ChefModel chefModel;
    public ChefPresenter() {
        this.chefModel= new ChefModel(MyApplication.getContext());
    }
    public void clickRequestCart() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chefModel.ChefAll( new IBaseRequestCallBack<ChefMsgBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ChefMsgBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultChefSuccess(cartBean);
                        }
                    }
                });

            }
        }, 10);
    }
}