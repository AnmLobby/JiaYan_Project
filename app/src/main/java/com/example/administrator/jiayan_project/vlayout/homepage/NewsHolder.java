package com.example.administrator.jiayan_project.vlayout.homepage;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.HotAdapter;
import com.example.administrator.jiayan_project.enity.homepage.HotBean;
import com.example.administrator.jiayan_project.enity.homepage.NewsBean;
import com.example.administrator.jiayan_project.ui.activity.LoginActivity;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/5/10/010.
 */

public class NewsHolder   extends VlayoutBaseHolder<NewsBean> {
    @BindView(R.id.mar)
    MarqueeView marqueeView;
    @BindView(R.id.news)
    TextView textView;
    private static final String TAG = "NewsHolder";
    public NewsHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(int ps, NewsBean hData) {
        super.setData(ps, hData);
        List<String> info = new ArrayList<>();
        for (int i = 0; i <hData.getData().size() ; i++) {
            info.add(hData.getData().get(i).getNewstitle());
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG, "onClick: 啊啊啊啊啊啊啊啊啊啊啊啊" );
            }
        });
//        info.add("1. 大家好，我是孙福生。");
//        info.add("2. 欢迎大家关注我哦！");
//        info.add("3. GitHub帐号：sfsheng0322");
//        info.add("4. 新浪微博：孙福生微博");
//        info.add("5. 个人博客：sunfusheng.com");
//        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                mListener.onItemClick(mView, position, mData);
            }
        });
    }
}
