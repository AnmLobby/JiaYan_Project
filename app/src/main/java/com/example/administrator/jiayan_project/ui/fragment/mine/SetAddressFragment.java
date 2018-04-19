package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.greendao.AddressController;
import com.example.administrator.jiayan_project.db.greendao.UserController;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * 添加收货地址
 */
public class SetAddressFragment extends BaseFragment {

    private UserController userController;
    private AddressController addressController;

    private EditText et_realname, et_phone, et_street, et_area, et_address;
    private CheckBox cb_isdefault;
    private Button bt_save;

    private String username;
    private String realname, phone, street, area, address;
    private boolean isdeafault;

    private AddressBean addressBean;

    //编辑或添加地址
    private int state;



    interface STATE {
        int STATE_ADD = 0x01;
        int STATE_EDIT = 0x02;
    }

    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_set_address, null);
        ButterKnife.bind(this, layout);
        et_realname = layout.findViewById(R.id.et_realname);
        et_phone = layout.findViewById(R.id.et_phone);
        et_street = layout.findViewById(R.id.et_street);
        et_area = layout.findViewById(R.id.et_area);
        et_address = layout.findViewById(R.id.et_address);
        cb_isdefault = layout.findViewById(R.id.cb_isdefault);
        bt_save = layout.findViewById(R.id.bt_save);
        userController = UserController.getInstance();
        addressController = AddressController.getInstance();
        initAddressViews();

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyApplication.getContext(), "777", Toast.LENGTH_SHORT).show();
                saveAddress();
            }
        });


        return layout;
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
            et_street.setText(addressBean.street);
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
        street = et_street.getText().toString().trim();
        area = et_area.getText().toString().trim();
        address = et_address.getText().toString().trim();
        if (phone.length() < 11) {

            return;
        }
        if (TextUtils.isEmpty(realname) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(street) || TextUtils.isEmpty(area) || TextUtils.isEmpty(address)) {

            return;
        }
        if (isdeafault) {
            //将已经设置为默认地址的选项取消掉
            addressController.updateAddressWithoutDefault(username);
        }

        if (state == STATE.STATE_ADD) {
            //添加到本地数据库
            AddressBean userAddress = new AddressBean(null, username, realname, phone, area, street, address, isdeafault);
            addressController.insert(userAddress);
//            onChangeDataInUI(AddressActivity.class.getName());
            Toast.makeText(MyApplication.getContext(), "保存", Toast.LENGTH_SHORT).show();
//            finish();
        } else if (state == STATE.STATE_EDIT) {
            //修改本地数据库
            AddressBean userAddress = new AddressBean(addressBean.getId(), username, realname, phone, area, street, address, isdeafault);
            addressController.update(userAddress);
//            onChangeDataInUI(AddressActivity.class.getName());
            Toast.makeText(MyApplication.getContext(), "修改", Toast.LENGTH_SHORT).show();
//            finish();
        }
    }

}
