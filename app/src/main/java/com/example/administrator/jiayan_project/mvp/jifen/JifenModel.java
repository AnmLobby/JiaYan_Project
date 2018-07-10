package com.example.administrator.jiayan_project.mvp.jifen;

import android.content.Context;

import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.enity.classify.MainChefClassifyBean;
import com.example.administrator.jiayan_project.enity.mine.JifenMainBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by Administrator on 2018/7/10/010.
 */

public class JifenModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<JifenMainBean> jifenMainBeanCall;
    private Context context;
    private Api api;
    public JifenModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void getJifen(int id,final IBaseRequestCallBack<JifenMainBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getJifen(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<JifenMainBean>() {
                    @Override
                    public void accept(JifenMainBean classifyBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(classifyBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(jifenMainBeanCall!= null && !jifenMainBeanCall.isCanceled()){
            jifenMainBeanCall.cancel();
        }
    }
}
