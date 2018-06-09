package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.weight.LinedEditText;
import com.example.administrator.jiayan_project.utils.weight.TagCloudView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private HashMap<Integer, Boolean> map = new HashMap<>(0);//记录选择的位置
    private List<String> AllTagsPosition = new ArrayList<>(0);//整个标签存放集合
    private List<String> aa = new ArrayList<>();
    private static final String TAG = "BanquetOrderFragment";
    private String remark;
    private List<AddressBean> list;
    private String price,color,num,peoplenum,name,imageurl;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet_order, null);
        ButterKnife.bind(this, layout);
        initTopBar();
        Bundle bundle=getArguments();
        imageurl=bundle.getString("imageurl");
        price =bundle.getString("price");
        color=bundle.getString("color");
        num=bundle.getString("num");
        name=bundle.getString("name");
        peoplenum=bundle.getString("people");
        Glide.with(MyApplication.getContext())
                .load(imageurl)
                .centerCrop()
                .into(bg);

        Log.e(TAG, "看看吧"+peoplenum+people+price+num+name );
        cuisineName.setText(name);
        cuisine_price.setText("¥ "+price);
        people.setText("规格："+peoplenum+"人/桌");
        allnum.setText("×"+num);
        bucaocolor.setText("布草摆设："+color);
        initPoView();
        initOrdername();
        chooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new ChooseAddressFragment());
            }
        });
        return layout;
    }

    private void initOrdername() {
        list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 3 个数据
                .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        if (list.size()==0){
            orderAddress.setText("亲，你还没有设置收货地址");
        }else {
            orderName.setText(list.get(0).getRealname());
            orderPhone.setText(list.get(0).getPhone());
            orderAddress.setText(list.get(0).getArea() + list.get(0).getAddress());
        }
    }

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
        mTopBar.setTitle("确认订单");
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
}
