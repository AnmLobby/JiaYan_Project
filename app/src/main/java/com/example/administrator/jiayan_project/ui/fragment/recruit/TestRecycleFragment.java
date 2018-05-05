package com.example.administrator.jiayan_project.ui.fragment.recruit;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.DateAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.TimeAdapter;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVLeftAdapter;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightAdapter;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightBaseBean;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightContentBean;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightHeaderBean;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间dialog.已经没用到了.可以取消
 * 代码用在banquetFragment
 */
public class TestRecycleFragment extends BaseFragment {
    @BindView(R.id.rv_left)
    RecyclerView mRvLeft;
    @BindView(R.id.rv_right)
    RecyclerView mRvRight;
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    private static final String TAG = "TestRecycleFragment";
//    private GridLayoutManager mRightGridLayoutManager;
    private DateAdapter mRVLeftAdapter;
    private TimeAdapter mRVRightAdapter;
    private boolean needMove = false;
    private int movePosition;
    private boolean isChangeByLeftClick = false;
    private String[] strList=new String[]{"10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00",
            "16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00"};
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test_recycle, null);
        ButterKnife.bind(this, layout);
        mTopBar.setTitle("选择服务时间");

        mRvLeft.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        List<String> leftData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String str=DateUtils.get7date().get(i)+DateUtils.get7week().get(i);
            leftData.add(str.substring(5,10)+"\n"+str.substring(10,12));
        }
        mRvLeft.setAdapter(mRVLeftAdapter = new DateAdapter(leftData));
        mRVLeftAdapter.setOnLeftItemClickListener(mOnLeftItemClickListener);

//        mRightGridLayoutManager = new GridLayoutManager(MyApplication.getContext(), 3);

//        mRvRight.setLayoutManager(mRightGridLayoutManager);
        //右边的recycleview
        mRvRight.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        List<String> rightData = new ArrayList<>();
        for (int i = 0; i <strList.length ; i++) {
            rightData.add(strList[i]);
        }

        Log.e(TAG, "onCreateView: "+rightData.size() );
        mRvRight.setAdapter(mRVRightAdapter = new TimeAdapter(rightData));
        mRVRightAdapter.setOnLeftItemClickListener(new TimeAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {

            }
        });
//        mRvRight.setAdapter(mRVRightAdapter = new LinkedRVRightAdapter(rightData));
//        mRvRight.addOnScrollListener(mOnRightScrollListener);
//        mRVRightAdapter.setOnLeftItemClickListener(new LinkedRVRightAdapter.OnLeftItemClickListener() {
//            @Override
//            public void onLeftItemClick(int position) {
//                Log.e(TAG, "onLeftItemClick: " +position);
//            }
//        });

        return layout;
    }
    private DateAdapter.OnLeftItemClickListener mOnLeftItemClickListener = new DateAdapter.OnLeftItemClickListener() {
        @Override
        public void onLeftItemClick(int position) {
            String leftSelected = mRVLeftAdapter.getSelectedData();
//            moveToPosition(movePosition = mRVRightAdapter.getPositionForHeader(leftSelected));
        }
    };
}
