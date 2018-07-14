package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.comment.BanquetCommentAdapter;
import com.example.administrator.jiayan_project.adapter.news.HotelEntityAdapter;
import com.example.administrator.jiayan_project.adapter.news.SectionedSpanSizeLookup;
import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetCommentPresenter;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetCommentView;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.image_detail.ShowImagesDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 高级宴会菜单评论
 */
public class BanquetCommentFragment extends AbstractMvpFragment<BanquetCommentView, BanquetCommentPresenter> implements BanquetCommentView {


    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    private String dinnerid;
    private List<BanquetComentBean.DataBean> classBeans;
    private BanquetCommentAdapter banquetCommentAdapter;
    private static final String TAG = "BanquetCommentFragment";
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_comment, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        EventBus.getDefault().register(this);
        getPresenter().clickRequestBanquet(dinnerid);
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void ononMoonStickyEvent(StartNewsEvent startNewsEvent) {
        dinnerid = startNewsEvent.getMessage();
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {
        Log.e(TAG, "resultFailure: "+result );
    }

    @Override
    public void resultBanquetCommentSuccess(BanquetComentBean banquetDetailBean) {
        classBeans = banquetDetailBean.getData();
//        for (int i = 0; i <classifyBean.getTypedata().size() ; i++) {
//            detailBeans=classifyBean.getTypedata().get(1).getDetail();
//        }
        Log.e(TAG, "resultBanquetCommentSuccess: "+classBeans.size() );
       banquetCommentAdapter = new BanquetCommentAdapter(MyApplication.getContext());

        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(banquetCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(banquetCommentAdapter);
        banquetCommentAdapter.setOnCommentItemClickListener(new BanquetCommentAdapter.OnCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                List<String> listImage=new ArrayList<>();
                for (int i = 0; i <banquetCommentAdapter.allTagList.get(section).getImg().size() ; i++) {
                    listImage.add(Constants.BaseUrl+banquetCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(),position,listImage).show();
            }
        });

        banquetCommentAdapter.setData(classBeans);

    }

    @Override
    public BanquetCommentPresenter createPresenter() {
        return new BanquetCommentPresenter();
    }
}
