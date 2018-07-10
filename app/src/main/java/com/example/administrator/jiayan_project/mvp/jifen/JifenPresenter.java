package com.example.administrator.jiayan_project.mvp.jifen;

import android.os.Handler;
import android.util.Log;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpPersenter;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyModel;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyView;

/**
 * Created by Administrator on 2018/7/10/010.
 */
public class JifenPresenter extends AbstractMvpPersenter<JifenView> {
    private JifenModel chefModel;
    public JifenPresenter() {
        this.chefModel= new JifenModel(MyApplication.getContext());
    }
    public void clickRequestClassify(final  int id) {
        if (getmMvpView() != null) {
            getmMvpView().requestLoading();
        }
        //模拟网络延迟，可以显示出加载中
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                chefModel.getJifen(id,new IBaseRequestCallBack<JifenMainBean>() {
                    @Override
                    public void requestError(Throwable throwable) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultFailure(Log.getStackTraceString(throwable));
                        }
                    }

                    @Override
                    public void requestSuccess(JifenMainBean cartBean) {
                        if (getmMvpView() != null) {
                            getmMvpView().resultSuccess(cartBean);
                        }
                    }
                });
            }
        }, 100);
    }
    public void inteerHttpl(){
        chefModel.interruptHttp();
    }
}
