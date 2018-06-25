package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.DateAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.TimeAdapter;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.banquet.BanquetBean;
import com.example.administrator.jiayan_project.enity.banquet.CheckFavoriteBean;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetPresenter;
import com.example.administrator.jiayan_project.mvp.banquetDetail.BanquetView;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.vondear.rxtools.RxImageTool;
import com.vondear.rxtools.module.wechat.share.WechatShareModel;
import com.vondear.rxtools.module.wechat.share.WechatShareTools;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 高级宴会菜单
 */

public class BanquetFragment extends AbstractMvpFragment<BanquetView, BanquetPresenter> implements BanquetView {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.qmui_layout)
    QMUILinearLayout mTestLayout;
    @BindView(R.id.twolayout)
    QMUILinearLayout twolayout;
    //现价
    @BindView(R.id.buy_money)
    TextView buyMoney;
    //原价格
    @BindView(R.id.money_before)
    TextView moneyBefore;
    //布草布局
    @BindView(R.id.yanseLayout)
    RelativeLayout yanseLayout;
    //桌数布局
    @BindView(R.id.zhuoshuLayout)
    RelativeLayout zhuoshuLayout;
    //桌数
    @BindView(R.id.zhuoshu)
    TextView Fzhuoshu;
    //每桌人数
    @BindView(R.id.renshu)
    TextView renshu;
    //布草颜色
    @BindView(R.id.bucao)
    TextView bucao;
    //使用积分优惠
    @BindView(R.id.use_jifen)
    TextView useJifen;
    @BindView(R.id.dinggou)
    TextView dinggou;
    @BindView(R.id.baozhang)
    TextView baozhang;
    @BindView(R.id.tuikuan)
    TextView tuikuan;
    @BindView(R.id.saclenum)
    TextView saclenum;
    @BindView(R.id.dishes_name)
    TextView dishesName;
    @BindView(R.id.dishes_share)
    TextView dishesShare;
    //客服
    @BindView(R.id.kefuimg)
    ImageView kefuimg;
    @BindView(R.id.kefu)
    TextView kefu;
    //收藏
    @BindView(R.id.likeimg)
    ImageView likeimg;
    @BindView(R.id.like)
    TextView like;
    @BindView(R.id.tip)
    TextView tip;
    @BindView(R.id.bucao_color)
    TextView bucaoColor;
    //开始时间
    @BindView(R.id.start_time)
    TextView startTime;
    //开始日期
    @BindView(R.id.start_date)
    TextView startDate;
    //结束时间
    @BindView(R.id.end_time)
    TextView endTime;
    //结束日期
    @BindView(R.id.end_date)
    TextView endDate;
    //日期结束布局
    @BindView(R.id.layout_end)
    LinearLayout layoutEnd;
    //日期开始布局
    @BindView(R.id.layout_start)
    LinearLayout layoutStart;
    //添加到购物车，购买
    @BindView(R.id.add_cart)
    Button addCart;
    @BindView(R.id.buy_soon)
    Button  buySoon;

    @BindView(R.id.mainLayout)
    FrameLayout mainFrag;
    String requeid;
    @BindView(R.id.keepsave)
    LinearLayout keepsave;
    private float mShadowAlpha = 0.25f;
    private int mShadowElevationDp = 5;
    private int mRadius;
    List<String> listImage = new ArrayList<>();
    private static final String TAG = "BanquetFragment";
    private List<String> leftData;
    private List<String> rightData;
    //时间dialog
    private DateAdapter mRVLeftAdapter;
    private TimeAdapter mRVRightAdapter;
    private boolean needMove = false;
    private int movePosition;
    private boolean isChangeByLeftClick = false;
    private QMUITipDialog tipDialog;
    private String[] strList = new String[]{"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
            "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
    private List<KeepUserBean> list;
    private String dinnerid;
    private int userid;
    private String imageUrl;
    private QMUIBottomSheet.BottomListSheetBuilder qmuiBottomSheet;
    private List<BanquetBean.SizeBean> sizesList=new ArrayList<>();
    private  int colorId;
    private  String shareTitle,shareDescri;
    private  WechatShareModel mWechatShareModel;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        EventBus.getDefault().register(this);
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 1 个数据
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        userid=list.get(0).getUserId();
        getPresenter().clickRequestBanquet(dinnerid);
        getPresenter().checkGetSaveLove(userid, Integer.parseInt(dinnerid));
        initBanner();
        initQmuiLayout();
//        initTextViewMoney();
//        加载显示今天的数据。已经设置到订单页面
//        String strAA = DateUtils.get7date().get(1) + DateUtils.get7week().get(1);
//        startDate.setText(strAA.substring(5, 10));
//        endDate.setText(strAA.substring(5, 10));
        //放在loading那里，不然加载会卡
        return layout;
    }

    private void initTextViewMoney() {
        String str = bucaoColor.getText().toString();
        if (str.contains("普通")) {
            tip.setVisibility(View.GONE);
        } else {
            tip.setVisibility(View.VISIBLE);
        }
    }

    //初始化QmuiLinearlayout
    private void initQmuiLayout() {

        mRadius = QMUIDisplayHelper.dp2px(getContext(), 10);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(getContext(), mShadowElevationDp),
                mShadowAlpha);
        mTestLayout.setRadiusAndShadow(mRadius,
                QMUIDisplayHelper.dp2px(getActivity(), mShadowElevationDp), mShadowAlpha);
//        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_RIGHT);
//        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_BOTTOM);
        mTestLayout.setRadius(mRadius, QMUILayoutHelper.HIDE_RADIUS_SIDE_NONE);

    }

    //banner图
    private void initBanner() {
//        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
//        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
//        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
//        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
//        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
//        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
//        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
//        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
//        listImage.add(imageUrl);
//        banner.setImages(listImage)
//                .setImageLoader(new GlideImageLoader())
//                .setBannerStyle(BannerConfig.NUM_INDICATOR)
//                .isAutoPlay(false)
//                .start();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /**
     * 各控件的点击事件
     * @param view
     */
    @OnClick({R.id.yanseLayout, R.id.layout_end, R.id.layout_start, R.id.add_cart, R.id.buy_soon,R.id.keepsave,R.id.kefuimg,R.id.dishes_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yanseLayout:
                //选择布草颜色
                showSimpleBottomSheetList();
                break;
            case R.id.layout_end:
                initEndTimeDialog(endDate, endTime);
                break;
            case R.id.layout_start:
                initEndTimeDialog(startDate, startTime);
                break;
            case R.id.add_cart:
                if (bucaoColor.getText().toString().equals("选择你所喜欢的摆设颜色")){
                    Toast.makeText(MyApplication.getContext(), "请选择摆设颜色", Toast.LENGTH_SHORT).show();
                    return;
                }
                int numZhushu= Integer.parseInt(Fzhuoshu.getText().toString());
                int numPeople= Integer.parseInt(renshu.getText().toString());
                getPresenter().AddToCart(userid,colorId,numZhushu, Integer.parseInt(dinnerid),numPeople);
                break;
            case R.id.buy_soon:
                if (bucaoColor.getText().toString().equals("选择你所喜欢的摆设颜色")){
                    Toast.makeText(MyApplication.getContext(), "请选择摆设颜色", Toast.LENGTH_SHORT).show();
                    return;
                }
                BanquetOrderFragment orderFragment=new BanquetOrderFragment();
                Bundle bundle=new Bundle();
                bundle.putString("color", bucaoColor.getText().toString());
                bundle.putString("num", Fzhuoshu.getText().toString());
                bundle.putString("people", renshu.getText().toString());
                bundle.putString("price", buyMoney.getText().toString());
                bundle.putString("name", dishesName.getText().toString());
                bundle.putString("imageurl",imageUrl);
                orderFragment.setArguments(bundle);
                startFragment(orderFragment);
                break;
            case R.id.keepsave:
                getPresenter().clickPostLove(userid, Integer.parseInt(dinnerid));
                break;
            case R.id.kefuimg:
                CallPhone();
                break;
            case R.id.dishes_share:
                showShareDialog();
                break;
        }
    }

    /**
     * 分享选择
     */
    private void showShareDialog() {

        final String url = "http://jiayan.didi0769.com/mobile/Details/details/id/"+dinnerid;//网页链接

//        String description = "工欲善其事必先利其器！";//描述
//
//        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);//获取Bitmap

        Glide.with(MyApplication.getContext()).load(imageUrl).asBitmap().override(60,40).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                byte[] bitmapByte = RxImageTool.bitmap2Bytes(resource, Bitmap.CompressFormat.PNG);//将 Bitmap 转换成 byte[]
                mWechatShareModel = new WechatShareModel(url, shareTitle, shareDescri, bitmapByte);
            }
        });
        //Friend 分享微信好友,Zone 分享微信朋友圈,Favorites 分享微信收藏
        final int TAG_SHARE_WECHAT_FRIEND = 0;
        final int TAG_SHARE_WECHAT_MOMENT = 1;
        QMUIBottomSheet.BottomGridSheetBuilder builder = new QMUIBottomSheet.BottomGridSheetBuilder(getActivity());
        builder.addItem(R.mipmap.icon_more_operation_share_friend, "分享到微信", TAG_SHARE_WECHAT_FRIEND, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .addItem(R.mipmap.icon_more_operation_share_moment, "分享到朋友圈", TAG_SHARE_WECHAT_MOMENT, QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView) {
                        dialog.dismiss();
                        int tag = (int) itemView.getTag();
                        switch (tag) {
                            case TAG_SHARE_WECHAT_FRIEND:
                                Log.e(TAG, "onClick: " );
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Friend);//分享操作
                                break;
                            case TAG_SHARE_WECHAT_MOMENT:
                                WechatShareTools.shareURL(mWechatShareModel, WechatShareTools.SharePlace.Zone);//分享操作
                                break;
                        }
                    }
                }).build().show();

    }

    /**
     * 选择结束时间dialog
     * @param enate
     * @param enime
     */
    private void initEndTimeDialog(final TextView enate, final TextView enime) {
//        HideSoftKeyBoardDialog(getActivity());
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme).create();
        View view = View.inflate(getActivity(), R.layout.endtime_dialog, null);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        //window.setWindowAnimations(R.style.dialogStyle);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        //设置dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        window.setContentView(view);
        //获得window窗口的属性
        WindowManager.LayoutParams params = window.getAttributes();
        //设置窗口宽度为充满全屏
        params.width = WindowManager.LayoutParams.MATCH_PARENT;//如果不设置,可能部分机型出现左右有空隙,也就是产生margin的感觉
        //设置窗口高度为包裹内容
        DisplayMetrics d = MyApplication.getContext().getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        params.height = (int) (d.heightPixels * 0.65);
//        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;//显示dialog的时候,就显示软键盘
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;//就是这个属性导致window后所有的东西都成暗淡
        params.dimAmount = 0.5f;//设置对话框的透明程度背景(非布局的透明度)
        window.setAttributes(params);
        RecyclerView mRvLeft = view.findViewById(R.id.rv_left);
        RecyclerView mRvRight = view.findViewById(R.id.rv_right);
        QMUITopBar mTopBar = view.findViewById(R.id.mtopbar);
        mTopBar.setTitle("选择服务时间");
        mTopBar.addRightImageButton(R.mipmap.dialog_close, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        mTopBar.setBackgroundDividerEnabled(false);//取消设置分割线

        mRvLeft.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));

        mRvLeft.setAdapter(mRVLeftAdapter = new DateAdapter(leftData));
        mRVLeftAdapter.setOnLeftItemClickListener(new DateAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {

                String d_time = mRVLeftAdapter.getData().get(position);
                enate.setText(d_time.substring(0, 5));

            }
        });
        //右边的recycleview
        mRvRight.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        mRvRight.setAdapter(mRVRightAdapter = new TimeAdapter(rightData));
        mRVRightAdapter.setOnLeftItemClickListener(new TimeAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {
                String o_time = mRVRightAdapter.getData().get(position);
                enime.setText(o_time);
                dialog.dismiss();
            }
        });
    }

    /**
     * 选择每桌人数跟总的桌数
     */
    @OnClick(R.id.zhuoshuLayout)
    public void onViewClicked() {
        showCommentDailog();
    }

    /**
     * 选择布草颜色，弹出对话框
     */
    private void showSimpleBottomSheetList() {
//        new QMUIBottomSheet.BottomListSheetBuilder(getActivity())
//                .addItem("普通红色","1")
//                .addItem("普通蓝色","2")
//                .addItem("普通黄色","3")
//                .addItem("豪华红色","4")
//                .addItem("豪华紫色","5")
//                .addItem("豪华蓝色","6")
//                .addItem("豪华黄色","7")
               qmuiBottomSheet.setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        colorId= Integer.parseInt(tag);
                        Log.e(TAG, "onClick: "+colorId);
                        dialog.dismiss();
                        bucaoColor.setText(sizesList.get(Integer.parseInt(tag)-1).getSname());
                        String str = bucaoColor.getText().toString();
                        if (str.contains("豪华")) {
                            tip.setVisibility(View.VISIBLE);
                        } else {
                            tip.setVisibility(View.GONE);
                        }
                    }
                })
                .build()
                .show();
    }

    /**
     * 开始时间选择
     */
    private void showCommentDailog() {
        //R.style.***一定要写，不然不能充满整个屏宽，引用R.style.AppTheme就可以
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme).create();
        View view = View.inflate(getActivity(), R.layout.custom_dialog_zhuoshu, null);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        //window.setWindowAnimations(R.style.dialogStyle);
//        window.getDecorView().setPadding(0, 0, 0, 0);
        //设置dialog弹出后会点击屏幕或物理返回键，dialog不消失
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        window.setContentView(view);
        //获得window窗口的属性
        WindowManager.LayoutParams params = window.getAttributes();
        //设置窗口宽度为充满全屏
        params.width = WindowManager.LayoutParams.MATCH_PARENT;//如果不设置,可能部分机型出现左右有空隙,也就是产生margin的感觉
        //设置窗口高度为包裹内容
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;//显示dialog的时候,就显示软键盘
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;//就是这个属性导致window后所有的东西都成暗淡
        params.dimAmount = 0.5f;//设置对话框的透明程度背景(非布局的透明度)
        //将设置好的属性set回去
        window.setAttributes(params);

        EditText people = (EditText) view.findViewById(R.id.num_people);
        EditText zhuoshu = (EditText) view.findViewById(R.id.num_zhuoshu);
        TextView dinnerPs=view.findViewById(R.id.dinnerPs);
        ImageView logoimg= view.findViewById(R.id.logoimg);
        ImageView dialo_close = view.findViewById(R.id.close_dialog);
        TextView dialog_name = view.findViewById(R.id.dialog_name);
        TextView dialog_now = view.findViewById(R.id.dialog_buy_money);
        TextView dialog_before = view.findViewById(R.id.dialog_money_before);
        dialo_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Glide.with(MyApplication.getContext()).load(imageUrl).into(logoimg);
        dinnerPs.setText(dinggou.getText().toString());
        dialog_name.setText(dishesName.getText().toString());
        dialog_now.setText(buyMoney.getText().toString());
        dialog_before.setText(moneyBefore.getText().toString());
        dialog_before.getPaint().setFlags(
                Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
        zhuoshu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Fzhuoshu.setText(editable);
            }
        });
        people.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                renshu.setText(editable);
            }
        });
    }

    /**
     * 加载前的操作
     */
    @Override
    public void requestLoading() {
        Log.e(TAG, "requestLoassssssssssssssssding: ");
        tipDialog = new QMUITipDialog.Builder(getActivity())
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
//        RxDialogShapeLoading rxDialogShapeLoading = new RxDialogShapeLoading(getActivity());
//        rxDialogShapeLoading.show();
//
    }

    /**
     * 加载出错
     * @param result
     */
    @Override
    public void resultFailure(String result) {
        tipDialog.dismiss();
        Log.e(TAG, "resultFailure: " + result);
        Toast.makeText(MyApplication.getContext(), "发生未知错误", Toast.LENGTH_SHORT).show();
        popBackStack();
    }

    /**
     * i详细信息请求完成界面
     * @param banquetBean
     */
    @Override
    public void resultBanquetSuccess(BanquetBean banquetBean) {
        tip.setVisibility(View.GONE);
        shareTitle=banquetBean.getData().get(0).getDinnername();
        shareDescri="现价：¥ "+banquetBean.getData().get(0).getPrice();
        dinggou.setText(banquetBean.getData().get(0).getDinggou());
        baozhang.setText(banquetBean.getData().get(0).getFuwu());
        tuikuan.setText(banquetBean.getData().get(0).getTuikuan());
        buyMoney.setText(String.valueOf(banquetBean.getData().get(0).getPrice()));
        //设置取消textview
        moneyBefore.setText("原价：¥ " + String.valueOf(banquetBean.getData().get(0).getOriginprice()) + " /套");
        moneyBefore.getPaint().setFlags(
                Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
        dishesName.setText(banquetBean.getData().get(0).getDinnername());
        saclenum.setText("已销售：" + banquetBean.getData().get(0).getSalesum() + "笔");
        //轮播图
        imageUrl= Constants.BaseUrl+banquetBean.getData().get(0).getOriginalimg();
        listImage.add(imageUrl);
        banner.setImages(listImage)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .isAutoPlay(false)
                .start();
        mainFrag.setVisibility(View.VISIBLE);
        tipDialog.dismiss();
        sizesList=banquetBean.getSize();
        qmuiBottomSheet= new QMUIBottomSheet.BottomListSheetBuilder(getActivity());
        for (int i = 0; i <banquetBean.getSize().size() ; i++) {
           qmuiBottomSheet.addItem(banquetBean.getSize().get(i).getSname(), String.valueOf(banquetBean.getSize().get(i).getId()));
        }


//选择时间的日期数据
//        leftData = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            String str = DateUtils.get7date().get(i) + DateUtils.get7week().get(i);
//            leftData.add(str.substring(5, 10) + "\n" + str.substring(10, 12));
//        }
//        rightData = new ArrayList<>();
//        for (int i = 0; i < strList.length; i++) {
//            rightData.add(strList[i]);
//        }
    }

    /**
     * 添加到收藏
     * @param favoritrResultBean
     */
    @Override
    public void resultKeepFavoriteSuccess(FavoritrResultBean favoritrResultBean) {
        if (favoritrResultBean.getCode()==200){
            likeimg.setBackgroundResource(R.mipmap.banquet_islike);
        }
        if (favoritrResultBean.getCode()==202){
            likeimg.setBackgroundResource(R.mipmap.banquet_like);
        }
        Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 检测是否收藏
     * @param checkFavoriteBean
     */
    @Override
    public void resultCheckFavoriteSuccess(CheckFavoriteBean checkFavoriteBean) {
        if (checkFavoriteBean.isCode()) {
            likeimg.setBackgroundResource(R.mipmap.banquet_islike);
        } else {
            likeimg.setBackgroundResource(R.mipmap.banquet_like);
        }
    }

    /**
     * 添加到购物车成功
     * @param favoritrResultBean
     */
    @Override
    public void resultAddCartSuccess(FavoritrResultBean favoritrResultBean) {
        Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    /**
     * EventBus获取到dinnerid
     * @return
     */
    @Override
    public BanquetPresenter createPresenter() {
        return new BanquetPresenter();
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void ononMoonStickyEvent(StartNewsEvent startNewsEvent) {
        dinnerid = startNewsEvent.getMessage();
    }
}
