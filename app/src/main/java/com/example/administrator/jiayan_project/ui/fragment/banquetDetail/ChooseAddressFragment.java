package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.ChooseAdressAdaptr;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.AddressController;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChooseAddressFragment extends BaseFragment {

    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    EasyRecyclerView recyclerview;
    @BindView(R.id.fraglayout)
    FrameLayout fraglayout;
    private List<AddressBean> addressBeans = new ArrayList<>();
    private List<AddressBean> list;
    private ChooseAdressAdaptr chooseAdressAdaptr;
    private AddressController addressController;
    private Boolean isPause = false;
    private Handler handler = new Handler();
    private static final String TAG = "ChooseAddressFragment";

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_choose_address, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        addressController = AddressController.getInstance();
        list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(300)//只获取结果集的前 3 个数据
                .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        chooseAdressAdaptr = new ChooseAdressAdaptr(MyApplication.getContext());
        recyclerview.setAdapter(chooseAdressAdaptr);
        chooseAdressAdaptr.addAll(list);
        chooseAdressAdaptr.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                for (int i = 0; i < list.size(); i++) {
                    AddressBean address = list.get(i);
                    address.isdefault = (i == position);
                    //升级数据库
                    addressController.update(address);
                }
                popBackStack();
            }
        });
        return layout;
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle("选择地址");
        mTopBar.addRightImageButton(R.mipmap.add, R.id.topbar_right_about_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new SetAddressFragment());
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        isPause = true; //记录页面已经被暂停
    }

    @Override
    public void onResume() {
        super.onResume();
        hideInput(MyApplication.getContext(),fraglayout );
        if (isPause) { //判断是否暂停
            isPause = false;
            list.clear();
//             chooseAdressAdaptr = new ChooseAdressAdaptr(MyApplication.getContext());
            chooseAdressAdaptr.clear();
            list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                    .offset(0)//偏移量，相当于 SQL 语句中的 skip
                    .limit(300)//只获取结果集的前 3 个数据
                    .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                    .build()
                    .list();
            addressBeans.addAll(list);
            chooseAdressAdaptr.addAll(addressBeans);
            addressBeans.clear();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    /**
     * 强制禁止调用键盘
     * @param context
     * @param view
     */
    private void hideInput(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
