package com.example.administrator.jiayan_project.mvp.classify;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.cook_regesigt.CookRegisterModel;
import com.example.administrator.jiayan_project.mvp.cook_regesigt.CookRegisterView;

/**
 * Created by Administrator on 2018/6/29/029.
 */

public class MainClassifyPresenter extends AbstractMvpPersenter<MainClassifyView> {
    private MainClassifyModel chefModel;
    public MainClassifyPresenter() {
        this.chefModel= new MainClassifyModel(MyApplication.getContext());
    }
    public void clickRequestClassify() {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chefModel.getClassify(new IBaseRequestCallBack<ClassifyBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(ClassifyBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultRegisterSuccess(cartBean);
                        }
                    }
                });

            }
        }, 10);
    }
}