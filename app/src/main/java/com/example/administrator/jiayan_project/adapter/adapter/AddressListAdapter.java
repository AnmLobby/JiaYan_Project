package com.example.administrator.jiayan_project.adapter.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.AddressBean;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/17.
 */

public class AddressListAdapter extends BaseQuickAdapter<AddressBean, BaseViewHolder> {
    public AddressListAdapter(List<AddressBean> data) {
        super(R.layout.address_item, data);
        Log.e(TAG, "HomeAdapter: " + data.size());
    }

    @Override
    protected void convert(BaseViewHolder helper, AddressBean item) {
        helper.addOnClickListener(R.id.check);
        helper.setText(R.id.name, item.getUsername());
        helper.setText(R.id.phone, item.getPhone());
        helper.setText(R.id.dizhi, item.getAddress());
        helper.setChecked(R.id.check,item.isdefault);
    }
}