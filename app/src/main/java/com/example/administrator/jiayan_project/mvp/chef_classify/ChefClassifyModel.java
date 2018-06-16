package com.example.administrator.jiayan_project.mvp.chef_classify;

/**
 * Created by Administrator on 2018/6/14/014.
 */

import android.content.Context;

import com.example.administrator.jiayan_project.enity.chef.ChefClassifyBean;
import com.example.administrator.jiayan_project.enity.chef.ChefMsgBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * 厨师分类列表详情
 */
public class ChefClassifyModel extends BaseModel {
    private CompositeDisposable mcompositeDisposable;
    private Call<ChefClassifyBean> chefClassifyBeanCall;
    private Context context;
    private Api api;
    public ChefClassifyModel(Context mContext){
        super();
        context=mContext;
        api=retrofitManager.getService();
        mcompositeDisposable=new CompositeDisposable();
    }
    public void getChefClassify(int id,final IBaseRequestCallBack<ChefClassifyBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getCookClassifyMsg(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ChefClassifyBean>() {
                    @Override
                    public void accept(ChefClassifyBean cartBean) throws Exception {
                        iBaseRequestCallBack.requestSuccess(cartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){

        if(chefClassifyBeanCall != null && !chefClassifyBeanCall.isCanceled()){
            chefClassifyBeanCall.cancel();
        }
    }
}
