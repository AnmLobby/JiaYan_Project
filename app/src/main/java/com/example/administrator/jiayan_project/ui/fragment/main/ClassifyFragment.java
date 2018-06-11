package com.example.administrator.jiayan_project.ui.fragment.main;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.AddressListAdapter;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVLeftAdapter;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightAdapter;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightBaseBean;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightContentBean;
import com.example.administrator.jiayan_project.ui.fragment.classify.LinkedRVRightHeaderBean;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品分类，底部栏第二个
 */

public class ClassifyFragment extends BaseFragment {
    @BindView(R.id.rv_left)
    RecyclerView mRvLeft;
    @BindView(R.id.rv_right)
    RecyclerView mRvRight;
    @BindView(R.id.search)
    LinearLayout search;
    private GridLayoutManager mRightGridLayoutManager;
    private LinkedRVLeftAdapter mRVLeftAdapter;
    private LinkedRVRightAdapter mRVRightAdapter;
    private boolean needMove = false;
    private int movePosition;
    private boolean isChangeByLeftClick = false;
    private static final String TAG = "ClassifyFragment";
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_classify, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SearchFragment());
            }
        });
        mRvLeft.setLayoutManager(new LinearLayoutManager(MyApplication.getContext()));
        List<String> leftData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            leftData.add("第 " + i + "开心类");
        }
        mRvLeft.setAdapter(mRVLeftAdapter = new LinkedRVLeftAdapter(leftData));
        mRVLeftAdapter.setOnLeftItemClickListener(mOnLeftItemClickListener);

        mRightGridLayoutManager = new GridLayoutManager(MyApplication.getContext(), 3);

        mRvRight.setLayoutManager(mRightGridLayoutManager);
        List<LinkedRVRightBaseBean> rightData = new ArrayList<>();
        for (int i = 0; i < leftData.size(); i++) {
            LinkedRVRightHeaderBean header = new LinkedRVRightHeaderBean();
            header.type = LinkedRVRightBaseBean.TYPE_HEADER;
            header.header = leftData.get(i);
            rightData.add(header);

            for (int j = 0; j < 1 + new Random().nextInt(9); j++) {
                LinkedRVRightContentBean content = new LinkedRVRightContentBean();
                content.type = LinkedRVRightBaseBean.TYPE_CONTENT;
                content.headerForChild = leftData.get(i);
                content.content = leftData.get(i) + " " + j;
                rightData.add(content);
            }
        }
        mRvRight.setAdapter(mRVRightAdapter = new LinkedRVRightAdapter(rightData));
        mRvRight.addOnScrollListener(mOnRightScrollListener);
        mRVRightAdapter.setOnLeftItemClickListener(new LinkedRVRightAdapter.OnLeftItemClickListener() {
            @Override
            public void onLeftItemClick(int position) {
                Log.e(TAG, "onLeftItemClick: " +position);
            }
        });
        return layout;
    }

    private RecyclerView.OnScrollListener mOnRightScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (needMove) {
                needMove = false;
                //获取要置顶的项在当前屏幕的位置，n是记录的要置顶项在RecyclerView中的位置
                int n = movePosition - mRightGridLayoutManager.findFirstVisibleItemPosition();
                if (0 <= n && n < mRvRight.getChildCount()) {
                    //获取要置顶的项顶部离RecyclerView顶部的距离
                    int top = mRvRight.getChildAt(n).getTop();
                    //最后的移动
                    mRvRight.scrollBy(0, top);
                }
            }
            //当前屏幕内第一个item和最后一个item。
            if (!isChangeByLeftClick) {
//                    int firstVisibleItem = mRightGridLayoutManager.findFirstCompletelyVisibleItemPosition();
                int firstVisibleItem = mRightGridLayoutManager.findFirstVisibleItemPosition();
                String header = mRVRightAdapter.getHeaderForPosition(firstVisibleItem);
                mRVLeftAdapter.notifySelectedPositionByHeader(header);
                mRvLeft.scrollToPosition(mRVLeftAdapter.getSelectedPosition());
            } else {
                isChangeByLeftClick = false;
            }
        }
    };

    private LinkedRVLeftAdapter.OnLeftItemClickListener mOnLeftItemClickListener = new LinkedRVLeftAdapter.OnLeftItemClickListener() {
        @Override
        public void onLeftItemClick(int position) {
            String leftSelected = mRVLeftAdapter.getSelectedData();
            moveToPosition(movePosition = mRVRightAdapter.getPositionForHeader(leftSelected));
        }
    };

    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mRightGridLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mRightGridLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            mRvRight.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            View view = mRvRight.getChildAt(n - firstItem);
            mRvRight.scrollBy(0, view.getTop());
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            mRvRight.scrollToPosition(n);
            movePosition = n;
            needMove = true;
        }

        
        
//        LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(addressListAdapter);
//
//        AddressBeanDao addressBeanDao=GreenDaoManager.getInstance().getSession().getAddressBeanDao();
//        AddressBean addressBean=new AddressBean();
//        addressBean.setName("广州市");
//        addressBean.setCheck(false);
//        addressBean.setNumber("打架好");
//        addressBean.setAddress("哒哒哒好");
//        addressBeanDao.insert(addressBean);
//        Toast.makeText(MyApplication.getContext(), "1", Toast.LENGTH_SHORT).show();

//        AddressBeanDao b=GreenDaoManager.getInstance().getSession().getAddressBeanDao();
//        b.deleteByKey(Long.valueOf("1"));
//        b.deleteByKey(Long.valueOf("2"));
//        b.deleteByKey(Long.valueOf("3"));
//        b.deleteByKey(Long.valueOf("4"));
//        b.deleteByKey(Long.valueOf("5"));

//       list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
//                .offset(0)//偏移量，相当于 SQL 语句中的 skip
//                .limit(300)//只获取结果集的前 3 个数据
//                .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
//                .build()
//                .list();
//        for (int i = 0; i < list.size(); i++) {
//            Log.d("zoneLog", "studentNumber:-- " +list.get(i).getId()+"--"+list.get(i).getUsername());
//        }
//        Log.e(TAG, "onCreateView: "+list.size() +list.get(i));
//                        addressBeans.addAll(list);
//                        addressListAdapter.setNewData(addressBeans);
//                        addressListAdapter.loadMoreComplete();
//
//        addressListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {

//                //判断id
//                if (view.getId() == R.id.check) {
//                    final CheckBox checkBox=view.findViewById(R.id.check);
//                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                            List<AddressBean> lisu =GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder().build().list();
//
//                        }
//                    });
//                }
//            }
//        });
//        addressListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Log.e(TAG, "onItemChildClick:888888" );
//            }
//        });



    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
