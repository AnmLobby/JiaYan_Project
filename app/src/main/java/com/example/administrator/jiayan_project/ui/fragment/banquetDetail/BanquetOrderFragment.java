package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.DateAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.TimeAdapter;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.example.administrator.jiayan_project.utils.weight.LinedEditText;
import com.example.administrator.jiayan_project.utils.weight.TagCloudView;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.vondear.rxtools.module.alipay.AliPayModel;
import com.vondear.rxtools.module.alipay.AliPayTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 高级接待
 * 提交订单，选择地址，时间，准备支付页面
 */
public class BanquetOrderFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    //名字手机地址
    @BindView(R.id.order_name)
    TextView orderName;
    @BindView(R.id.order_phone)
    TextView orderPhone;
    @BindView(R.id.order_address)
    TextView orderAddress;
    //服务时间
    @BindView(R.id.time_select)
    TextView timeSelect;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.start_date)
    TextView startDate;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.end_date)
    TextView endDate;
    @BindView(R.id.layout_end)
    LinearLayout layoutEnd;
    @BindView(R.id.layout_start)
    LinearLayout layoutStart;
    //菜品名字，价格,桌子人数
    @BindView(R.id.cuisine_name)
    TextView cuisineName;
    @BindView(R.id.xiangqing)
    TextView xiangqing;
    @BindView(R.id.youhuijiage)
    TextView youhuijiage;
    @BindView(R.id.people)
    TextView people;
    @BindView(R.id.cuisine_price)
    TextView cuisine_price;
    @BindView(R.id.allnum)
    TextView allnum;
    @BindView(R.id.bucaocolor)
    TextView bucaocolor;
    //底部价格
    @BindView(R.id.sure_money)
    TextView sureMoney;
    //    @BindView(R.id.cancel_money)
//    TextView cancelMoney;
    @BindView(R.id.bg)
    ImageView bg;
    //备注消息
    @BindView(R.id.edit_query)
    LinedEditText editQuery;
    @BindView(R.id.xianshilayout)
    RelativeLayout xianshilayout;
    //云标签
    @BindView(R.id.positionsTag)
    TagCloudView positionsView;
    @BindView(R.id.choose_address)
    RelativeLayout chooseAddress;
    @BindView(R.id.pay_money)
    Button payMoney;
    private DateAdapter mRVLeftAdapter;
    private TimeAdapter mRVRightAdapter;
    private HashMap<Integer, Boolean> map = new HashMap<>(0);//记录选择的位置
    private List<String> AllTagsPosition = new ArrayList<>(0);//整个标签存放集合
    private List<String> aa = new ArrayList<>();
    private static final String TAG = "BanquetOrderFragment";
    private String remark;
    private List<AddressBean> list;
    private String price, color, num, peoplenum, name, imageurl;
    private String[] strList = new String[]{"10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00",
            "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
    private List<String> leftData;
    private List<String> rightData;
    private int  totalPrice;
    private String  orderStartData,orderStartTime,orderEndData,orderEndTime;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet_order, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        /**
         * 初始化获取今天的时间的设置信息
         */
        String strAA = DateUtils.get7date().get(1) + DateUtils.get7week().get(1);
        startDate.setText(strAA.substring(5, 10));
        endDate.setText(strAA.substring(5, 10));
        orderStartData=strAA.substring(5, 10);
        orderEndData=strAA.substring(5, 10);
        orderStartTime="11:00";
        orderEndTime="12:00";
        /**
         * 初始化时间选择数据列表信息
         */
        Observable.timer(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        leftData = new ArrayList<>();
                        for (int i = 0; i < 30; i++) {
                            String str = DateUtils.get7date().get(i) + DateUtils.get7week().get(i);
                            leftData.add(str.substring(5, 10) + "\n" + str.substring(10, 12));
                        }
                        rightData = new ArrayList<>();
                        for (int i = 0; i < strList.length; i++) {
                            rightData.add(strList[i]);
                        }
                    }
                });
        /**
         * 获取传递过来的消息
         */
        Bundle bundle = getArguments();
        imageurl = bundle.getString("imageurl");
        price = bundle.getString("price");
        color = bundle.getString("color");
        num = bundle.getString("num");
        name = bundle.getString("name");
        peoplenum = bundle.getString("people");
        Glide.with(MyApplication.getContext())
                .load(imageurl)
                .centerCrop()
                .into(bg);
        Log.e(TAG, "onCreateView: 图片"+imageurl );
        cuisineName.setText(name);
        cuisine_price.setText("¥ " + price);
        people.setText("规格：" + peoplenum + "人/桌");
        allnum.setText("×" + num);
        bucaocolor.setText("布草摆设：" + color);
        initPoView();
        initOrdername();
         totalPrice +=  Integer.parseInt(num) *  Integer.parseInt(price);
         sureMoney.setText("¥ " +totalPrice+"");
        chooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new ChooseAddressFragment());
            }
        });
        return layout;
    }

    /**
     * 检测且设置地址信息
     */
    private void initOrdername() {
        list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 3 个数据
                .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        if (list.size() == 0) {
            orderAddress.setText("亲，你还没有设置收货地址");
        } else {
            orderName.setText(list.get(0).getRealname());
            orderPhone.setText(list.get(0).getPhone());
            orderAddress.setText(list.get(0).getArea() + list.get(0).getAddress());
        }
    }

    /**
     * 选择结束时间dialog
     *
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
                orderEndData=d_time.substring(0, 5);
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
                orderEndTime=o_time;
            }
        });
    }
    private void initEndTimeDialogg(final TextView enate, final TextView enime) {
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
                orderStartData=d_time.substring(0, 5);
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
                orderStartTime=o_time;
            }
        });
    }


    /**
     * 标签
     */
    private void initPoView() {
        AllTagsPosition.add("口味清淡");
        map.put(1, false);
        AllTagsPosition.add("有忌口");
        map.put(2, false);
        AllTagsPosition.add("不吃辣");
        map.put(3, false);
        AllTagsPosition.add("有孕妇");
        map.put(4, false);
        AllTagsPosition.add("有老人");
        map.put(5, false);
        AllTagsPosition.add("有小孩");
        map.put(0, false);
        positionsView.setTagsByPosition(map, AllTagsPosition);
        for (int i = 0; i < AllTagsPosition.size(); i++) {
            if (map.get(i)) {
                positionsView.getChildAt(i).setBackgroundResource(R.drawable.edit_style_yellow);
            }
        }
        positionsView.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onTagClick(int position) {
                bindPositionView(position);
                if (aa.contains(AllTagsPosition.get(position))) {
                    aa.remove(AllTagsPosition.get(position));
                } else {
                    aa.add(AllTagsPosition.get(position));
                }
                StringBuilder strr = new StringBuilder();
                for (int i = 0; i < aa.size(); i++) {
                    if (i == aa.size() - 1) {
                        strr.append(aa.get(i));
                    } else {
                        strr.append(aa.get(i));
                        strr.append(",");
                    }
                    remark = strr.toString();
                }
            }
        });

    }

    /**
     * 定点标签记录和view变化
     **/
    private void bindPositionView(int position) {
        for (int i = 0; i < AllTagsPosition.size(); i++) {
            if (i == position) {
                if (map.get(i)) {
                    map.put(i, false);
                } else {
                    map.put(i, true);
                }
            } else {
                if (map.get(i)) {
                    map.put(i, true);
                } else {
                    map.put(i, false);
                }
            }
        }
        positionsView.setTagsByPosition(map, AllTagsPosition);
        for (int i = 0; i < AllTagsPosition.size(); i++) {
            if (map.get(i)) {
                positionsView.getChildAt(i).setBackgroundResource(R.drawable.edit_style_yellow);
            }
        }
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("确认宴席订单");
    }


    @Override
    public void onResume() {
        super.onResume();
        initOrdername();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.layout_start, R.id.layout_end, R.id.pay_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_start:
                initEndTimeDialogg(startDate, startTime);
                break;
            case R.id.layout_end:
                initEndTimeDialog(endDate, endTime);
                break;
            case R.id.pay_money:

                break;
        }
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
