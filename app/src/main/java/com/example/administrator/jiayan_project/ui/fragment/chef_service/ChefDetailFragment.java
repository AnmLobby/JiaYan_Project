package com.example.administrator.jiayan_project.ui.fragment.chef_service;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailBannerBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailCommentBean;
import com.example.administrator.jiayan_project.enity.chefDetail.ChefDetailMsgBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailPresenter;
import com.example.administrator.jiayan_project.mvp.chefDetail.ChefDetailView;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.weight.FatRecyclerview;
import com.example.administrator.jiayan_project.utils.weight.image_detail.ShowImagesDialog;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefBannerDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefCommentDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.ChefMsgDetailHolder;
import com.example.administrator.jiayan_project.vlayout.chefDetail.MoreHolder;
import com.example.administrator.jiayan_project.vlayout.helper.SectionItemListener;
import com.example.administrator.jiayan_project.vlayout.helper.SectionVlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.helper.VlayoutBaseAdapter;
import com.example.administrator.jiayan_project.vlayout.homepage.ItemListener;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.vondear.rxtools.RxImageTool;
import com.vondear.rxtools.module.wechat.share.WechatShareModel;
import com.vondear.rxtools.module.wechat.share.WechatShareTools;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 选菜预定界面，具有banner 。已验证信息，厨师详情
 */
public class ChefDetailFragment extends AbstractMvpFragment<ChefDetailView, ChefDetailPresenter> implements ChefDetailView {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recycler)
    FatRecyclerview mRecycler;

    @BindView(R.id.bt_service) Button btService;

    private QMUITipDialog tipDialog;
    private Context mContext;
    private DelegateAdapter delegateAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private VlayoutBaseAdapter banneradapter, chefmsgAdapter, moreCommentAdpater, bottonAdapter;
    private SectionVlayoutBaseAdapter commentAdapter;
    private List<ChefDetailMsgBean> msgBeans = new ArrayList<>();
    private int id, userid;
    private String imageUrl;
    private WechatShareModel mWechatShareModel;
    private String shareTitle, shareDescri;
    private List<KeepUserBean> list;
    private int checkid = 1;
    private int price,banNianPrice,quanNianPrice;
    private String lev;
    private String cookname,cookCusine,cookImg,titleName,cookChefImg;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chef_detail, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        getPresenter().clickRequestCart(id);
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)
                .limit(1)
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        userid = list.get(0).getUserId();
        initTopBar();
        initRecycler();
        initDele();
        getDeviceDensity();
        return layout;
    }

    private void initDele() {
        banneradapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailMsgBean>())
                .setLayout(R.layout.vlayout_chefdetail_banner)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefBannerDetailHolder.class)
                .setListener(new ItemListener<ChefDetailMsgBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailMsgBean mData) {

                        List<String> listImage=new ArrayList<>();
                        for (int i = 0; i <mData.getYii().size() ; i++) {
                            listImage.add(Constants.BaseUrl+mData.getYii().get(i));
                        }
                        new ShowImagesDialog(getActivity(),position,listImage).show();
                    }
                });
        chefmsgAdapter = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailMsgBean>())
                .setLayout(R.layout.vlayout_chefdetail_detail)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(ChefMsgDetailHolder.class)
                .setListener(new ItemListener<ChefDetailMsgBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailMsgBean mData) {
                        switch (position) {
                            case R.id.btnone:
                                checkid = 1;
                                lev= "包月服务：¥"+price;
                                break;
                            case R.id.btntwo:
                                checkid = 2;
                                lev= "半年服务：¥"+banNianPrice;
                                break;
                            case R.id.btnthree:
                                checkid = 3;
                                lev= "包年服务：¥"+quanNianPrice;
                                break;
                        }
                    }
                });
        /**
         *  评论布局
         */
        commentAdapter = new SectionVlayoutBaseAdapter(mContext)
                .setSectionData(new ArrayList<ChefDetailCommentBean>())
                .setSectionLayout(R.layout.vlayout_chef_grid)
                .setSectionLayoutHelper(new LinearLayoutHelper())
                .setSectionHolder(ChefCommentDetailHolder.class)
                .setSectionListener(new SectionItemListener<ChefDetailMsgBean>() {
                    @Override
                    public void onSectionItemClick(View view, int section, int position, ChefDetailMsgBean mSectionData) {
                        List<String>  listSectionImage=new ArrayList<>();
                        for (int i = 0; i <mSectionData.getEvaluate().get(section).getImg().size() ; i++) {
                            listSectionImage.add(Constants.BaseUrl+mSectionData.getEvaluate().get(section).getImg().get(i));
                        }
                        new ShowImagesDialog(getActivity(),position,listSectionImage).show();
                        Log.e("888", "onSectionItemClick: "+section+position );
                    }
                });




        moreCommentAdpater = new VlayoutBaseAdapter(mContext)
                .setData(new ArrayList<ChefDetailCommentBean>())
                .setLayout(R.layout.get_moew)
                .setLayoutHelper(new LinearLayoutHelper())
                .setHolder(MoreHolder.class)
                .setListener(new ItemListener<ChefDetailMsgBean>() {
                    @Override
                    public void onItemClick(View view, int position, ChefDetailMsgBean mData) {
                        Toast.makeText(MyApplication.getContext(), "88", Toast.LENGTH_SHORT).show();
                    }
                });
//        bottonAdapter= new VlayoutBaseAdapter(mContext)
//                .setData(new ArrayList<ChefDetailCommentBean>())
//                .setLayout(R.layout.chef_bootn)
//                .setLayoutHelper(new LinearLayoutHelper())
//                .setHolder(BottmHolder.class)
//                .setListener(new ItemListener<ChefDetailMsgBean>() {
//                    @Override
//                    public void onItemClick(View view, int position, ChefDetailMsgBean mData) {
//                        Toast.makeText(MyApplication.getContext(), "855668", Toast.LENGTH_SHORT).show();
//                    }
//                });
        delegateAdapter.addAdapter(banneradapter);
        delegateAdapter.addAdapter(chefmsgAdapter);
        delegateAdapter.addAdapter(commentAdapter);
        delegateAdapter.addAdapter(moreCommentAdpater);
//        delegateAdapter.addAdapter(bottonAdapter);
        mRecycler.setAdapter(delegateAdapter);

    }

    private void initRecycler() {
        virtualLayoutManager = new VirtualLayoutManager(mContext);
        mRecycler.setLayoutManager(virtualLayoutManager);
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(5, 20);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("厨师预定");
        // 动态修改效果按钮
        mTopBar.addRightImageButton(R.mipmap.icon_topbar_overflow, R.id.topbar_right_change_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showShareChefDialog();
                    }
                });
    }

    /**
     * 分享选择
     */
    private void showShareChefDialog() {

//        final String url = "http://jiayan.didi0769.com/mobile/Cook/cookdetails/id/" + id;//网页链接

//        String description = "工欲善其事必先利其器！";//描述
//
//        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);//获取Bitmap

        Glide.with(MyApplication.getContext()).load(imageUrl).asBitmap().override(60, 40).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                 String urll = "http://jiayan.didi0769.com/mobile/Cook/cookdetails/id/" + id;//网页链接
                byte[] bitmapByte = RxImageTool.bitmap2Bytes(resource, Bitmap.CompressFormat.PNG);//将 Bitmap 转换成 byte[]
                mWechatShareModel = new WechatShareModel(urll, shareTitle, shareDescri, bitmapByte);
            }
        });
        //Friend 分享微信好友,Zone 分享微信朋友圈,Favorites 分享微信收藏
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        final int TAG_ADD_CART = 2;
        QMUIBottomSheet.BottomGridSheetBuilder builder = new QMUIBottomSheet.BottomGridSheetBuilder(getActivity());
        builder.addItem(R.mipmap.icon_more_operation_share_friend, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_moment, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.add_cart, "添加到购物车", TAG_ADD_CART, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Friend);//分享操作
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Zone);//分享操作
                                break;
                            case TAG_ADD_CART:
                                getPresenter().addToMyCart(userid,id,checkid);
                                break;
                        }
                    }
                }).build().show();

    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void requestLoading() {
        tipDialog = new QMUITipDialog.Builder(getActivity())
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
    }

    @Override
    public void resultFailure(String result) {
        Toast.makeText(MyApplication.getContext(), "后台发生未知错误", Toast.LENGTH_SHORT).show();
        popBackStack();
        tipDialog.show();
    }

    @Override
    public void resultChefBannerSuccess(ChefDetailBannerBean chefDetailBannerBean) {

    }

    @Override
    public void resultChefMsgSuccess(ChefDetailMsgBean chefDetailMsgBean) {

        imageUrl = Constants.BaseUrl + chefDetailMsgBean.getChefData().get(0).getCookimg();
        shareTitle = chefDetailMsgBean.getChefData().get(0).getCookname();
        shareDescri = chefDetailMsgBean.getChefData().get(0).getCuisine();
        price=chefDetailMsgBean.getChefData().get(0).getPrice();
        banNianPrice=chefDetailMsgBean.getChefData().get(0).getBanprice();
        quanNianPrice=chefDetailMsgBean.getChefData().get(0).getNianprice();
        cookname=chefDetailMsgBean.getChefData().get(0).getCookname();
        cookCusine=chefDetailMsgBean.getChefData().get(0).getCuisine();
        cookImg=chefDetailMsgBean.getCook().get(0).getCookerimg();
        titleName=chefDetailMsgBean.getCook().get(0).getTitlename();
        cookChefImg=chefDetailMsgBean.getChefData().get(0).getCookimg();
        lev= "包月服务：¥"+price;
        msgBeans.add(chefDetailMsgBean);
        chefmsgAdapter.setData(msgBeans);
        chefmsgAdapter.notifyDataSetChanged();

        banneradapter.setData(msgBeans);
        banneradapter.notifyDataSetChanged();

        commentAdapter.setSectionData(msgBeans);
        commentAdapter.notifyDataSetChanged();

        if (chefDetailMsgBean.getEvaluate().isEmpty()) {

        } else {
            moreCommentAdpater.setData(msgBeans);
            moreCommentAdpater.notifyDataSetChanged();
        }
        tipDialog.dismiss();

//        bottonAdapter.setData(msgBeans);
//        bottonAdapter.notifyDataSetChanged();
    }

    @Override
    public void resultChefCommentSuccess(ChefDetailCommentBean chefDetailCommentBean) {

    }

    @Override
    public void resultAddChefSuccess(FavoritrResultBean favoritrResultBean) {
        tipDialog.dismiss();
        Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public ChefDetailPresenter createPresenter() {
        return new ChefDetailPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tipDialog.dismiss();
    }

    @OnClick(R.id.bt_service)
    public void onViewClicked() {
        ChefOrderFragment chefOrderFragment=new ChefOrderFragment();
        Bundle bundle=new Bundle();
        bundle.putString("name",cookname);
        bundle.putString("cookimg",cookChefImg);
        bundle.putString("caixi",cookCusine);
        bundle.putInt("id",id);
        bundle.putString("cookerimg",cookImg);
        bundle.putString("level",titleName);
        bundle.putString("service",lev);
        bundle.putInt("price",price);
        chefOrderFragment.setArguments(bundle);
        startFragment(chefOrderFragment);
    }
}
