package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.weight.LinedEditText;
import com.example.administrator.jiayan_project.utils.weight.TagCloudView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    @BindView(R.id.order_name)
    TextView orderName;
    @BindView(R.id.order_phone)
    TextView orderPhone;
    @BindView(R.id.order_address)
    TextView orderAddress;
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
    @BindView(R.id.cuisine_name)
    TextView cuisineName;
    @BindView(R.id.xiangqing)
    TextView xiangqing;
    @BindView(R.id.youhuijiage)
    TextView youhuijiage;
    @BindView(R.id.sure_money)
    TextView sureMoney;
    @BindView(R.id.cancel_money)
    TextView cancelMoney;
    @BindView(R.id.bg)
    ImageView bg;
    @BindView(R.id.edit_query)
    LinedEditText editQuery;
    @BindView(R.id.xianshilayout)
    RelativeLayout xianshilayout;
    @BindView(R.id.positionsTag)
    TagCloudView  positionsView;
    private HashMap<Integer, Boolean> map = new HashMap<>(0);//记录选择的位置
    private List<String> AllTagsPosition = new ArrayList<>(0);//整个标签存放集合
    private List<String>   aa=new ArrayList<>();
    private static final String TAG = "BanquetOrderFragment";
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_banquet_order, null);
        ButterKnife.bind(this, layout);
        initTopBar();

        Glide.with(MyApplication.getContext())
                .load(R.drawable.bg_people)
                .centerCrop()
                .into(bg);


        initPoView();
        return layout;
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
                if (aa.contains(AllTagsPosition.get(position))){
                    aa.remove(AllTagsPosition.get(position));
                }else {
                    aa.add(AllTagsPosition.get(position));
                }
                for (int i = 0; i <aa.size() ; i++) {
                    Log.e(TAG, "onTagClick: ssssssssss"+aa.get(i).toString() );
                }
                Iterator it = aa.iterator();
                while(it.hasNext()) {
                    Log.e(TAG, "一共aaaaaa有"+it.next());
                }
                Log.e(TAG, "一共有"+aa.size());
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
        mTopBar.setTitle(ContantsName.HighReception);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
