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
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.AddressAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.AddressListAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

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
    private AddressAdapter addressListAdapter;
    private List<AddressBean> addressBeans=new ArrayList<>();
    private static final String TAG = "ClassifyFragment";
    private  List<AddressBean> list;
    @Override
    protected View onCreateView() {
        FrameLayout layout = ( FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_delivery, null);
        ButterKnife.bind(this, layout);
        initTopBar();

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
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber:-- " +list.get(i).getId()+"--"+list.get(i).getUsername());
        }
//        Log.e(TAG, "onCreateView: "+list.size() +list.get(i));
        addressBeans.addAll(list);
        addressListAdapter =new AddressAdapter(MyApplication.getContext(),addressBeans);
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

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.ReceiveLocation);
        mTopBar.addRightImageButton(R.mipmap.add, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SetAddressFragment());
            }
        });
    }


}