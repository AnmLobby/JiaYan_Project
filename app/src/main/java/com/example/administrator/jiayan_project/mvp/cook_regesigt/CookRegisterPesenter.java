package com.example.administrator.jiayan_project.mvp.cook_regesigt;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.chef.ChefModel;
import com.example.administrator.jiayan_project.mvp.chef.ChefView;

/**
 * Created by Administrator on 2018/6/14/014.
 */

public class CookRegisterPesenter extends AbstractMvpPersenter<CookRegisterView> {
    private CookRegisterModel chefModel;
    public CookRegisterPesenter() {
        this.chefModel= new CookRegisterModel(MyApplication.getContext());
    }
    public void clickRequestCart(final String id, final String name, final String age, final String sex, final String address, final String mobile, final String cokage) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chefModel.CookRegister(id,name,age,sex,address,mobile,cokage,new IBaseRequestCallBack<FavoritrResultBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(FavoritrResultBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultRegisterSuccess(cartBean);
                        }
                    }
                });

            }
        }, 10);
    }
}