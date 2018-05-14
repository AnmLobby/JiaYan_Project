package com.example.administrator.jiayan_project.adapter.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/5/14/014.
 */

public class ChoorseAddressViewHolder extends BaseViewHolder<AddressBean> {

    private TextView name,phone,address;
    public ChoorseAddressViewHolder(ViewGroup viewGroup)  {
        super(viewGroup, R.layout.address_banquet_item);
        name=$(R.id.name);
        phone=$(R.id.phone);
        address=$(R.id.address);
        }

    @Override
    public void setData(AddressBean data) {
        super.setData(data);
        name.setText(data.getRealname());
        phone.setText(data.getPhone());
        address.setText(data.getArea()+data.getAddress());
    }
}
