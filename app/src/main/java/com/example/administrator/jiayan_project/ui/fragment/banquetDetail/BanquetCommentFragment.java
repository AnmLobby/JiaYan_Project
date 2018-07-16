package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.comment.BanquetCommentAdapter;
import com.example.administrator.jiayan_project.adapter.news.SectionedSpanSizeLookup;
import com.example.administrator.jiayan_project.enity.banquet.BanquetComentBean;
import com.example.administrator.jiayan_project.enity.banquet.BanquetNumBean;
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
import butterknife.OnClick;

/**
 * 高级宴会菜单评论
 */
public class BanquetCommentFragment extends AbstractMvpFragment<BanquetCommentView, BanquetCommentPresenter> implements BanquetCommentView {


    @BindView(R.id.recyclerview) RecyclerView recyclerview;
    @BindView(R.id.btnAll) RadioButton btnAll;
    @BindView(R.id.btnHao) RadioButton btnHao;
    @BindView(R.id.btnZhong) RadioButton btnZhong;
    @BindView(R.id.btnCha) RadioButton btnCha;
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
        getPresenter().clickRequestBanquetNum(dinnerid);
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
        Log.e(TAG, "resultFailure: " + result);
    }

    @Override
    public void resultBanquetCommentSuccess(BanquetComentBean banquetDetailBean) {
        classBeans = banquetDetailBean.getData();
        banquetCommentAdapter = new BanquetCommentAdapter(MyApplication.getContext());
        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(banquetCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(banquetCommentAdapter);
        banquetCommentAdapter.setOnCommentItemClickListener(new BanquetCommentAdapter.OnCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                List<String> listImage = new ArrayList<>();
                for (int i = 0; i < banquetCommentAdapter.allTagList.get(section).getImg().size(); i++) {
                    listImage.add(Constants.BaseUrl + banquetCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(), position, listImage).show();
            }
        });
        banquetCommentAdapter.setData(classBeans);
    }

    @Override
    public void resultBanquetCommentGoodSuccess(BanquetComentBean banquetDetailBean) {
        classBeans = banquetDetailBean.getData();
        banquetCommentAdapter = new BanquetCommentAdapter(MyApplication.getContext());
        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(banquetCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(banquetCommentAdapter);
        banquetCommentAdapter.setOnCommentItemClickListener(new BanquetCommentAdapter.OnCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                List<String> listImage = new ArrayList<>();
                for (int i = 0; i < banquetCommentAdapter.allTagList.get(section).getImg().size(); i++) {
                    listImage.add(Constants.BaseUrl + banquetCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(), position, listImage).show();
            }
        });
        banquetCommentAdapter.setData(classBeans);
    }

    @Override
    public void resultBanquetCommentMidSuccess(BanquetComentBean banquetDetailBean) {
        classBeans = banquetDetailBean.getData();
        banquetCommentAdapter = new BanquetCommentAdapter(MyApplication.getContext());
        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(banquetCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(banquetCommentAdapter);
        banquetCommentAdapter.setOnCommentItemClickListener(new BanquetCommentAdapter.OnCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                List<String> listImage = new ArrayList<>();
                for (int i = 0; i < banquetCommentAdapter.allTagList.get(section).getImg().size(); i++) {
                    listImage.add(Constants.BaseUrl + banquetCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(), position, listImage).show();
            }
        });
        banquetCommentAdapter.setData(classBeans);
    }

    @Override
    public void resultBanquetCommentChaSuccess(BanquetComentBean banquetDetailBean) {
        classBeans = banquetDetailBean.getData();
        banquetCommentAdapter = new BanquetCommentAdapter(MyApplication.getContext());
        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(banquetCommentAdapter, manager));
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(banquetCommentAdapter);
        banquetCommentAdapter.setOnCommentItemClickListener(new BanquetCommentAdapter.OnCommentItemClickChefListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                List<String> listImage = new ArrayList<>();
                for (int i = 0; i < banquetCommentAdapter.allTagList.get(section).getImg().size(); i++) {
                    listImage.add(Constants.BaseUrl + banquetCommentAdapter.allTagList.get(section).getImg().get(i));
                }
                new ShowImagesDialog(getActivity(), position, listImage).show();
            }
        });
        banquetCommentAdapter.setData(classBeans);
    }

    @Override
    public void resultBanquetCommentNumSuccess(BanquetNumBean banquetNumBean) {
        btnAll.setText("全部("+banquetNumBean.getTquan()+")");
        btnHao.setText("好评("+banquetNumBean.getThao()+")");
        btnZhong.setText("中评("+banquetNumBean.getTzhong()+")");
        btnCha.setText("差评("+banquetNumBean.getTcha()+")");
    }

    @Override
    public BanquetCommentPresenter createPresenter() {
        return new BanquetCommentPresenter();
    }

    @OnClick({R.id.btnAll, R.id.btnHao, R.id.btnZhong, R.id.btnCha})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAll:
                getPresenter().clickRequestBanquet(dinnerid);
                break;
            case R.id.btnHao:
                getPresenter().clickRequestBanquetGood(dinnerid);
                break;
            case R.id.btnZhong:
                getPresenter().clickRequestBanquetMid(dinnerid);
                break;
            case R.id.btnCha:
                getPresenter().clickRequestBanquetCha(dinnerid);
                break;
        }
    }
}
