package com.example.administrator.jiayan_project.ui.fragment.yan_news;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.homepage.HomePresenter;
import com.example.administrator.jiayan_project.mvp.homepage.HomeView;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailPresenter;
import com.example.administrator.jiayan_project.mvp.news.NewsDetailView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsDetailFragment extends AbstractMvpFragment<NewsDetailView, NewsDetailPresenter> implements NewsDetailView  {

    private static final String TAG = "NewsDetailFragment";
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
    @BindView(R.id.time)
    TextView timer;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news_detail, null);
        ButterKnife.bind(this, layout);
        Bundle bundle=getArguments();
        String id=bundle.getString("id");
        Log.e(TAG, "onCreateView: "+id );
        getPresenter().clickRequestNews(id);
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
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void resultUserSuccess(NewsDetailBean newsDetailBean) {
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+newsDetailBean.getData().get(0).getNewsimg()).into(image);
        title.setText(newsDetailBean.getData().get(0).getNewstitle());
        wwatch.setText(newsDetailBean.getData().get(0).getClick()+"人浏览过");
        contentview.setText(newsDetailBean.getData().get(0).getNewscontent());
        author.setText("文章作者："+newsDetailBean.getData().get(0).getNewsauthor());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time=new Long(newsDetailBean.getData().get(0).getCreatetime());
        String d = format.format(time);
        try {
            Date date=format.parse(d);
            String s= String.valueOf(date);
            timer.setText(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NewsDetailPresenter createPresenter() {
        return new NewsDetailPresenter();
    }
}
