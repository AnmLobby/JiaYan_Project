package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;


import android.graphics.Paint;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.DateAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.TimeAdapter;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.GlideImageLoader;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 高级宴会菜单
 */

public class BanquetFragment extends BaseFragment {
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
    @BindView(R.id.add_cart)
    TextView addCart;
    @BindView(R.id.buy_soon)
    TextView buySoon;
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
    private String[] strList = new String[]{"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
            "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet, null);
        ButterKnife.bind(this, layout);
        initBanner();
        initQmuiLayout();
        initTextViewMoney();
        //放在loading那里，不然加载会卡
        leftData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String str= DateUtils.get7date().get(i)+DateUtils.get7week().get(i);
            leftData.add(str.substring(5,10)+"\n"+str.substring(10,12));
        }
        rightData= new ArrayList<>();
        for (int i = 0; i <strList.length ; i++) {
            rightData.add(strList[i]);
        }
        return layout;
    }

    //设置取消textview
    private void initTextViewMoney() {
        moneyBefore.setText("原价：¥ 666 /套");
        moneyBefore.getPaint().setFlags(
                Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
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
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");
        listImage.add("http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg");
        listImage.add("http://img.kaiyanapp.com/d7186edff72b6a6ddd03eff166ee4cd8.jpeg");
        listImage.add("http://img.kaiyanapp.com/cd74ae49d45ab6999bcd55dbae6d550f.jpeg");

        Log.e(TAG, "initBanner: " + listImage.size());
        banner.setImages(listImage)
                .setImageLoader(new GlideImageLoader())
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .isAutoPlay(false)
                .start();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @OnClick({R.id.yanseLayout, R.id.layout_end, R.id.layout_start,R.id.add_cart, R.id.buy_soon})
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
                break;
            case R.id.buy_soon:
                break;
        }
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
            }
        });
    }

    @OnClick(R.id.zhuoshuLayout)
    public void onViewClicked() {
        showCommentDailog();
    }

    /**
     * 选择布草颜色，弹出对话框
     */
    private void showSimpleBottomSheetList() {
        new QMUIBottomSheet.BottomListSheetBuilder(getActivity())
                .addItem("普通红色")
                .addItem("普通蓝色")
                .addItem("普通黄色")
                .addItem("豪华红色")
                .addItem("豪华紫色")
                .addItem("豪华蓝色")
                .addItem("豪华黄色")
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        dialog.dismiss();
                        bucaoColor.setText(tag);

                        String str = bucaoColor.getText().toString();
                        if (str.contains("普通")) {
                            tip.setVisibility(View.GONE);
                        } else {
                            tip.setVisibility(View.VISIBLE);
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
}
