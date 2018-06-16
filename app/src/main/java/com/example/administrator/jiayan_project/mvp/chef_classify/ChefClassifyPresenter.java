package com.example.administrator.jiayan_project.mvp.chef_classify;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.chef.ChefView;
import com.example.administrator.jiayan_project.mvp.cook_regesigt.CookRegisterModel;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class ChefClassifyPresenter extends AbstractMvpPersenter<ChefClassifyView> {
    private ChefClassifyModel chefClassifyModel;
    public ChefClassifyPresenter() {
        this.chefClassifyModel= new ChefClassifyModel(MyApplication.getContext());
    }
    public void clickRequestCart(final int id) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chefClassifyModel.getChefClassify(id, new IBaseRequestCallBack<ChefClassifyBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ChefClassifyBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultChefClassifySuccess(cartBean);
                        }
                    }
                });

            }
        }, 10);
    }
}