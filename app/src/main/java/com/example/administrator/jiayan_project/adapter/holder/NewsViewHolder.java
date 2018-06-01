package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.enity.news.NewsDetailBean;
import com.example.administrator.jiayan_project.enity.news.NewsListBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/5/7/007.
 */

/**
 * 宴快报 -  5页面
 */
public class NewsViewHolder  extends BaseViewHolder<NewsListBean.DataBean> {
    private ImageView imageView;
    private TextView title,author,clicknumber;
    private static final String TAG = "CagViewHolder";

    public NewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.news_item);
        imageView=$(R.id.image);
        title=$(R.id.title);
        author=$(R.id.author);
        clicknumber=$(R.id.clicknumber);
    }

    @Override
    public void setData(NewsListBean.DataBean data) {
        super.setData(data);
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+data.getNewsimg()).centerCrop().into(imageView);
        title.setText(data.getNewstitle());
        clicknumber.setText(data.getClick()+"  人浏览过");
        author.setText("文章作者："+data.getNewsauthor());
    }
}