package com.example.administrator.jiayan_project.mvp.search;

import android.content.Context;


import com.example.administrator.jiayan_project.enity.search.HotSearchBean;
import com.example.administrator.jiayan_project.enity.search.SearchBodyBean;
import com.example.administrator.jiayan_project.enity.search.SearchResultBean;
import com.example.administrator.jiayan_project.http.Api;
import com.example.administrator.jiayan_project.http.BaseModel;
import com.example.administrator.jiayan_project.mvp.base.IBaseRequestCallBack;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * Created by 鱼握拳 on 2018/3/15.
 */

public class SearchRequestModel  extends BaseModel {
    private Call<SearchResultBean> searchResultBeanCall;
    private Call<HotSearchBean> hotSearchBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    private Call<List<String>> listCall;
    public  SearchRequestModel(Context mContext) {
        super();
        context = mContext;
        api =retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }
    public void RequestQuery(String name, final IBaseRequestCallBack<SearchResultBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getSearchResult(new SearchBodyBean(name))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<SearchResultBean>() {
                    @Override
                    public void accept(SearchResultBean rankListBeann) throws Exception {
                        iBaseRequestCallBack.requestSuccess(rankListBeann);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void  RequestList(final IBaseRequestCallBack<HotSearchBean> iBaseRequestCallBack){
        mcompositeDisposable.add(api.getSearchHot()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<HotSearchBean>() {
                    @Override
                    public void accept(HotSearchBean list) throws Exception {
                            iBaseRequestCallBack.requestSuccess(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public void interruptHttp(){
        if(searchResultBeanCall != null && !searchResultBeanCall.isCanceled()){
            searchResultBeanCall.cancel();
        }
        if(hotSearchBeanCall != null && !hotSearchBeanCall.isCanceled()){
            hotSearchBeanCall.cancel();
        }
    }
}
