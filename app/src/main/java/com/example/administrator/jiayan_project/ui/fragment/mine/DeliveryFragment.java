package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MainActivity;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.AddressAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.AddressListAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.eventbus.AddressEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 查看收货地址
 */
public class DeliveryFragment extends BaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
//    @BindView(R.id.recyclerview)
//    RecyclerView recyclerview;
    @BindView(R.id.lv_address)
    ListView lv_address;
    private Boolean isPause=false;
    private AddressAdapter addressListAdapter;
    private List<AddressBean> addressBeans=new ArrayList<>();
    private static final String TAG = "ClassifyFragment";
    private  List<AddressBean> list;
    @Override
    protected View onCreateView() {
        FrameLayout layout = ( FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_delivery, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
//        EventBus.getDefault().register(this);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(MyApplication.getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(addressListAdapter);
//
        list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(300)//只获取结果集的前 3 个数据
                .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        Log.e(TAG, "onCreateView: "+list.size() );
//        for (int i = 0; i < list.size(); i++) {
//            Log.d("zoneLog", "studentNumber:-- " +list.get(i).getId()+"--"+list.get(i).getUsername());
//        }
//        Log.e(TAG, "onCreateView: "+list.size() +list.get(i));
        addressBeans.addAll(list);
        addressListAdapter =new AddressAdapter(getActivity(),addressBeans);

        lv_address.setAdapter(addressListAdapter);
//        addressListAdapter.setNewData(addressBeans);
//        addressListAdapter.loadMoreComplete();
//
//        addressListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
//
//                //判断id
//                if (view.getId() == R.id.check) {
//                    final CheckBox checkBox=view.findViewById(R.id.check);
//                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                            List<AddressBean> lisu = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder().build().list();
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
        return layout;
    }

    @Override
    public void onPause() {
        super.onPause();
            isPause = true; //记录页面已经被暂停
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isPause){ //判断是否暂停
            isPause = false;
            addressBeans.clear();
            list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                    .offset(0)//偏移量，相当于 SQL 语句中的 skip
                    .limit(300)//只获取结果集的前 3 个数据
                    .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                    .build()
                    .list();
            addressBeans.addAll(list);
            addressListAdapter =new AddressAdapter(getActivity(),addressBeans);
            addressListAdapter.notifyDataSetChanged();
        }

    }

    private void initTopBar() {
        mTopBar.addRightImageButton(R.mipmap.add, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SetAddressFragment());
            }
        });
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.ReceiveLocation);

    }
//    @Subscribe(threadMode = ThreadMode.POSTING, sticky = false)
//    public void ononMoonEvent(AddressEvent addressEvent) {
////        String phone=addressEvent.getPhone().toString().trim();
//        startFragment(new SetAddressFragment());
////        Log.e(TAG, "ononMoonStickyEvent: "+phone );
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
//    }

}
