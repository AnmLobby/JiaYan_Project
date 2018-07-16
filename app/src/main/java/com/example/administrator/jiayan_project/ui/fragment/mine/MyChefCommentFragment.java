package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.news.MyChefCommentAdapter;
import com.example.administrator.jiayan_project.adapter.news.SectionedSpanSizeLookup;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.mine.MyChefCommentBean;
import com.example.administrator.jiayan_project.enity.mine.MyCommentBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.myComment.MyCommentPresenter;
import com.example.administrator.jiayan_project.mvp.myComment.MyCommentView;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.ChefDetailFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.image_detail.ShowImagesDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/7/16/016.
 */

public class MyChefCommentFragment extends AbstractMvpFragment<MyCommentView, MyCommentPresenter> implements MyCommentView {

    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.text) TextView text;
    private List<MyChefCommentBean.CookercommentBean> myCommentBeans;
    private MyChefCommentAdapter myCommentAdapter;
    private List<KeepUserBean> list;
    private static final String TAG = "MyCommentDinnerFragment";

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_comment, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);

        getDeviceDensity();
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)
                .limit(1)
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        int id=list.get(0).getUserId();
        getPresenter().clickRequestMyChefComment(id);
        return layout;
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
        Log.e(TAG, "resultFailure: " + result);
    }

    @Override
    public void resultMyCommentSuccess(MyCommentBean myCommentBean) {


    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void resultMyChefCommentSuccess(MyChefCommentBean myChefCommentBean) {
        if (null==myChefCommentBean.getCookercomment()||myChefCommentBean.getCookercomment().size()==0){
            text.setText("暂无");
            text.setVisibility(View.VISIBLE);
        }
        myCommentBeans = myChefCommentBean.getCookercomment();
        myCommentAdapter = new MyChefCommentAdapter(MyApplication.getContext());
        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(myCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(myCommentAdapter);
        myCommentAdapter.setMyChefCommentItemClickListener(new MyChefCommentAdapter.MyChefCommentItemClickListener() {
            @Override
            public void onMyChefItemClick(int section, int position) {
                List<String> listImage = new ArrayList<>();
                for (int i = 0; i < myCommentAdapter.allTagList.get(section).getImg().size(); i++) {
                    listImage.add(Constants.BaseUrl + myCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(), position, listImage).show();
            }

            @Override
            public void onMYChefCommentClick(int position) {
                int id = myCommentAdapter.allTagList.get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putInt("id", id);
                ChefDetailFragment chefDetailFragment = new ChefDetailFragment();
                chefDetailFragment.setArguments(bundle);
                startFragment(chefDetailFragment);
            }
        });
        myCommentAdapter.setData(myCommentBeans);
    }

    @Override
    public MyCommentPresenter createPresenter() {
        return new MyCommentPresenter();
    }
}
