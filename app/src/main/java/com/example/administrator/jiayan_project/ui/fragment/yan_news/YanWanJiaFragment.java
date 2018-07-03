package com.example.administrator.jiayan_project.ui.fragment.yan_news;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.NewsAdapter;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.enity.news.NewsVideoBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.news_list.NewsListPresenter;
import com.example.administrator.jiayan_project.mvp.news_list.NewsListView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class YanWanJiaFragment extends AbstractMvpFragment<NewsListView, NewsListPresenter> implements NewsListView{
    @BindView(R.id.easycyclerview)
    EasyRecyclerView easycyclerview;
    private NewsAdapter newsAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<NewsListBean.DataBean> beanList;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_yan_wan_jia, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestYanNews();
        newsAdapter=new NewsAdapter(MyApplication.getContext());
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        easycyclerview.setLayoutManager(staggeredGridLayoutManager);
        easycyclerview.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String id= String.valueOf(newsAdapter.getItem(position).getId());
                NewsDetailFragment newsDetailFragment=new NewsDetailFragment();
                Bundle bundle=new Bundle();
                bundle.putString("id",id);
                newsDetailFragment.setArguments(bundle);
                startFragment(newsDetailFragment);
            }
        });

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
        beanList=newsListBean.getData();
        newsAdapter.addAll(beanList);
    }

    @Override
    public void resultVideoListSuccess(NewsListBean newsVideoBean) {

    }


    @Override
    public NewsListPresenter createPresenter() {
        return new NewsListPresenter();
    }
}
