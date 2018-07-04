package com.example.administrator.jiayan_project.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
import com.example.administrator.jiayan_project.ui.base.AddressBaseActivity;
import com.example.administrator.jiayan_project.ui.fragment.mine.SetAddressFragment;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.youth.picker.PickerView;
import com.youth.picker.entity.PickerData;
import com.youth.picker.listener.OnPickerClickListener;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class AddressActivity extends AddressBaseActivity {
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
    protected int getContextViewId() {
        return R.id.qmuidemo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        et_realname = findViewById(R.id.et_realname);
        et_phone = findViewById(R.id.et_phone);
//        et_street = layout.findViewById(R.id.et_street);
        et_area = findViewById(R.id.et_area);
        et_address = findViewById(R.id.et_address);
        cb_isdefault = findViewById(R.id.cb_isdefault);
        bt_save = findViewById(R.id.bt_save);
        linearLayout=findViewById(R.id.linlayout);
        Observable.timer(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        initProvinceDatas();
                        PickerData data=new PickerData();
                        //设置数据，有多少层级自己确定
                        data.setFirstDatas(mProvinceDatas);
                        data.setSecondDatas(mCitisDatasMap);
                        data.setThirdDatas(mDistrictDatasMap);
                        data.setFourthDatas(new HashMap<String, String[]>());
                        //设置初始化默认显示的三级菜单(此方法可以选择传参数量1到4个)
//        data.setInitSelectText("河北省","石家庄市","平山县");
                        //初始化选择器
                        pickerView=new PickerView(AddressActivity.this,data);

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

                    }
                });


        userController = UserController.getInstance();
        addressController = AddressController.getInstance();
        initAddressViews();
//        int result =QMUIStatusBarHelper.getStatusbarHeight(this);
//        mTopBar.setPadding(0,result,0,0);
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTopBar.setTitle("修改收货地址");
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAddress();
                Log.e(TAG, "onClick: ***" );
            }
        });
    }
    private void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }
    private void initAddressViews() {
//        addressBean = getIntent().getParcelableExtra("address");
        addressBean = getIntent().getParcelableExtra("address");


        if (addressBean != null) {
            //编辑状态
            state = STATE.STATE_EDIT;
        } else {
            //添加状态
            state = STATE.STATE_ADD;
        }

        if (state ==STATE.STATE_EDIT) {
            et_realname.setText(addressBean.realname);
            et_phone.setText(addressBean.phone);
//            et_street.setText(addressBean.street);
            et_address.setText(addressBean.address);
            et_area.setText(addressBean.area);
            cb_isdefault.setChecked(addressBean.isdefault);
            overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
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
            Toast.makeText(this, "名字，地址信息或手机不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (phone.length() < 11) {
            Toast.makeText(this, "手机号码格式错误", Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_area.getText().toString().equals("选择地区")){
            Toast.makeText(this, "请选择地区", Toast.LENGTH_SHORT).show();
            return;
        }
//        if (isdeafault) {
//            //将已经设置为默认地址的选项取消掉
//            addressController.updateAddressWithoutDefault(username);
//        }

        if (state == STATE.STATE_ADD) {

            List<AddressBean> list = GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder()
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
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
//            popBackStack();
//            finish();
        } else if (state == STATE.STATE_EDIT) {
            //修改本地数据库
            AddressBean userAddress = new AddressBean(addressBean.getId(), username, realname, phone, area, street, address, isdeafault);
            Log.e(TAG, "saveAddress:ssssssssssssss " );
            addressController.update(userAddress);
//            onChangeDataInUI(AddressActivity.class.getName());
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
//            popBackStack();
            finish();
//            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        finish();
//        overridePendingTransition(R.anim.slide_still, R.anim.slide_out_right);
//        return super.onKeyDown(keyCode, event);
//    }
}
