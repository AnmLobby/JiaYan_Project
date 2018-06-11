package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.greendao.AddressController;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.db.greendao.UserController;
import com.example.administrator.jiayan_project.ui.base.AddressBaseFragment;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.eventbus.AddressEvent;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.youth.picker.PickerView;
import com.youth.picker.entity.PickerData;
import com.youth.picker.listener.OnPickerClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.LoginException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 添加收货地址
 */
public class SetAddressFragment extends AddressBaseFragment {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    private UserController userController;
    private AddressController addressController;

    private EditText et_realname, et_phone, et_address;
    private CheckBox cb_isdefault;
    private Button bt_save;
    private TextView et_area;
    private String username;
    private String realname, phone, street, area, address;
    private boolean isdeafault;
    private RelativeLayout linearLayout;
    private AddressBean addressBean;
    private PickerView pickerView;
    //编辑或添加地址
    private int state;
    private static final String TAG = "SetAddressFragment";


    interface STATE {
        int STATE_ADD = 0x01;
        int STATE_EDIT = 0x02;
    }

    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_set_address, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
//        EventBus.getDefault().register(this);
        initProvinceDatas();
        et_realname = layout.findViewById(R.id.et_realname);
        et_phone = layout.findViewById(R.id.et_phone);
//        et_street = layout.findViewById(R.id.et_street);
        et_area = layout.findViewById(R.id.et_area);
        et_address = layout.findViewById(R.id.et_address);
        cb_isdefault = layout.findViewById(R.id.cb_isdefault);
        bt_save = layout.findViewById(R.id.bt_save);
        PickerData data=new PickerData();
        //设置数据，有多少层级自己确定
        data.setFirstDatas(mProvinceDatas);
        data.setSecondDatas(mCitisDatasMap);
        data.setThirdDatas(mDistrictDatasMap);
        data.setFourthDatas(new HashMap<String, String[]>());
        //设置初始化默认显示的三级菜单(此方法可以选择传参数量1到4个)
//        data.setInitSelectText("河北省","石家庄市","平山县");
        //初始化选择器
        pickerView=new PickerView(getActivity(),data);
        linearLayout=layout.findViewById(R.id.linlayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintKbTwo();
                pickerView.show(linearLayout);
            }
        });
        pickerView.setOnPickerClickListener(new OnPickerClickListener() {
            //选择列表时触发的事件
            @Override
            public void OnPickerClick(PickerData pickerData) {
                //想获取单个选择项 PickerData内也有方法（弹出框手动关闭）

                et_area.setText(pickerData.getSelectText());
                pickerView.dismiss();//关闭选择器
            }
            //点击确定按钮触发的事件（自动关闭）
            @Override
            public void OnPickerConfirmClick(PickerData pickerData) {

                et_area.setText(pickerData.getSelectText());
            }
        });

        userController = UserController.getInstance();
        addressController = AddressController.getInstance();
        initAddressViews();
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.NewLocation);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAddress();
                Log.e(TAG, "onClick: ***" );
            }
        });


        return layout;
    }
    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getActivity().getCurrentFocus()!=null){
            if (getActivity().getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    private void initAddressViews() {
//        addressBean = getIntent().getParcelableExtra("address");

        if (addressBean != null) {
            //编辑状态
            state = STATE.STATE_EDIT;
        } else {
            //添加状态
            state = STATE.STATE_ADD;
        }

        if (state == STATE.STATE_EDIT) {
            et_realname.setText(addressBean.realname);
            et_phone.setText(addressBean.phone);
//            et_street.setText(addressBean.street);
            et_address.setText(addressBean.address);
            et_area.setText(addressBean.area);
            cb_isdefault.setChecked(addressBean.isdefault);
            bt_save.setText("修改");
        }
    }
    public void saveAddress() {
//        username = userController.getUsername();
        isdeafault = cb_isdefault.isChecked();
        realname = et_realname.getText().toString().trim();
        phone = et_phone.getText().toString().trim();
        street="" ;
        area = et_area.getText().toString().trim();
        address = et_address.getText().toString().trim();

        if (TextUtils.isEmpty(realname) || TextUtils.isEmpty(phone)  || TextUtils.isEmpty(area) || TextUtils.isEmpty(address)) {
            Toast.makeText(MyApplication.getContext(), "名字，地址信息或手机不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (phone.length() < 11) {
            Toast.makeText(MyApplication.getContext(), "手机号码格式错误", Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_area.getText().toString().equals("选择地区")){
            Toast.makeText(MyApplication.getContext(), "请选择地区", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isdeafault) {
            //将已经设置为默认地址的选项取消掉
            addressController.updateAddressWithoutDefault(username);
        }

        if (state == STATE.STATE_ADD) {

            List<AddressBean>   list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
                    .offset(0)//偏移量，相当于 SQL 语句中的 skip
                    .limit(300)//只获取结果集的前 3 个数据
                    .orderDesc(AddressBeanDao.Properties.Isdefault)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                    .build()
                    .list();
            if (list.size()==0){
                isdeafault=true;
            }else {
                isdeafault=false;
            }
            //添加到本地数据库
            AddressBean userAddress = new AddressBean(null, username, realname, phone, area, street, address, isdeafault);
            addressController.insert(userAddress);
//            onChangeDataInUI(AddressActivity.class.getName());
            Toast.makeText(MyApplication.getContext(), "保存成功", Toast.LENGTH_SHORT).show();
            popBackStack();
//            finish();
        } else if (state == STATE.STATE_EDIT) {
            //修改本地数据库
            AddressBean userAddress = new AddressBean(addressBean.getId(), username, realname, phone, area, street, address, isdeafault);
            addressController.update(userAddress);
//            onChangeDataInUI(AddressActivity.class.getName());
            Toast.makeText(MyApplication.getContext(), "修改成功", Toast.LENGTH_SHORT).show();
            popBackStack();
//            finish();
        }
    }
//    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
//    public void ononMoonStickyEvent(AddressEvent addressEvent) {
//        state = STATE.STATE_EDIT;
//        String phone=addressEvent.getPhone().toString().trim();
//        Log.e(TAG, "ononMoonStickyEvent: "+phone );
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
//    }
}
