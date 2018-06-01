package com.example.administrator.jiayan_project.ui.fragment.yan_news;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.NewsAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.NewsVideoAdapter;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.news_list.NewsListPresenter;
import com.example.administrator.jiayan_project.mvp.news_list.NewsListView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViedeoFragment  extends AbstractMvpFragment<NewsListView, NewsListPresenter> implements NewsListView {
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easycyclerview;
    private NewsVideoAdapter newsVideoAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<NewsVideoBean.DataBean> beanLis;
    private static final String TAG = "ViedeoFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsVideoAdapter=new NewsVideoAdapter(MyApplication.getContext());
    }

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_viedeo, null);
        ButterKnife.bind(this, layout);

        getPresenter().clickRequestVideoNews();



        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easycyclerview.setLayoutManager(staggeredGridLayoutManager);
        easycyclerview.setAdapter(newsVideoAdapter);

        return layout;
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultNewsListSuccess(NewsListBean newsListBean) {

    }

    @Override
    public void resultVideoListSuccess(NewsVideoBean newsVideoBean) {

        beanLis=newsVideoBean.getData();
        newsVideoAdapter.addAll(beanLis);
        newsVideoAdapter.notifyDataSetChanged();
    }

    @Override
    public NewsListPresenter createPresenter() {
        return new NewsListPresenter();
    }
}

