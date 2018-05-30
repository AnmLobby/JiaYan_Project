package com.example.administrator.jiayan_project.ui.fragment.yan_news;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.homepage.HomePresenter;
import com.example.administrator.jiayan_project.mvp.homepage.HomeView;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailPresenter;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsDetailFragment extends AbstractMvpFragment<NewsDetailView, NewsDetailPresenter> implements NewsDetailView  {


    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.contentview)
    TextView contentview;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.wwatch)
    TextView wwatch;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news_detail, null);
        ButterKnife.bind(this, layout);
        initTopBar();

        return layout;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("宴快报详情");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultUserSuccess(NewsDetailBean newsDetailBean) {
        Glide.with(MyApplication.getContext()).load(newsDetailBean.getData().get(0).getNewsimg()).into(image);
    }

    @Override
    public NewsDetailPresenter createPresenter() {
        return new NewsDetailPresenter();
    }
}
