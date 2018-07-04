package com.example.administrator.jiayan_project.adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.greendao.AddressController;
import com.example.administrator.jiayan_project.ui.activity.TwoActivity;
import com.example.administrator.jiayan_project.utils.eventbus.AddressEvent;
import com.example.administrator.jiayan_project.utils.helper.FragmentController;
import com.example.administrator.jiayan_project.utils.util.AlertUtils;
import com.qmuiteam.qmui.arch.QMUIFragmentActivity;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


/**
 * Created by handsome on 2016/4/8.
 */
public class AddressAdapter extends BaseAdapter implements View.OnClickListener {

    private AddressController addressController;
    private FragmentController activityController;

    private List<AddressBean> addressList;
    private LayoutInflater mInflater;
    private Context context;
    private QMUIDialog qmuiDialog;
    private QMUIFragmentActivity mainActivity;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
    //选中条目
    private int position;

    public AddressAdapter(Context context,QMUIFragmentActivity mainActivity, List<AddressBean> addressList) {
        this.addressList = addressList;
        this.mainActivity = mainActivity;
        this.context=context;
        mInflater = LayoutInflater.from(mainActivity);
        addressController = AddressController.getInstance();
        activityController = FragmentController.getInstance();
    }

    @Override
    public int getCount() {
        return addressList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_address, parent, false);
        }
        ViewHolder holder = getViewHolder(convertView);
        AddressBean address = addressList.get(position);
        holder.tv_realname.setText(address.realname);
        holder.tv_address.setText(address.area + " " + address.street + " " + address.address);
        holder.tv_phone.setText(address.phone);
        holder.cb_isdefault.setOnClickListener(this);
        holder.cb_isdefault.setTag(position);
        //删除和编辑按钮
        holder.ly_edit.setOnClickListener(this);
        holder.ly_edit.setTag(position);
        holder.ly_delete.setOnClickListener(this);
        holder.ly_delete.setTag(position);
        boolean isdefault = address.isdefault;
        if (isdefault) {
            holder.cb_isdefault.setChecked(true);
            holder.tv_isdefault.setTextColor(Color.parseColor("#FF6622"));
            holder.tv_isdefault.setText("默认地址");
        } else {
            holder.cb_isdefault.setChecked(false);
            holder.tv_isdefault.setTextColor(Color.parseColor("#333333"));
            holder.tv_isdefault.setText("设为默认");
        }
        return convertView;
    }

    /**
     * 获得控件管理对象
     *
     * @param view
     * @return
     */
    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb_isdefault:
                position = (int) v.getTag();
                selectDefaultAddress(position);
                break;
            case R.id.ly_edit:
                position = (int) v.getTag();
                Log.e("88", "onClick:999** " );
//                activityController.startEditAddressActivityWithAddress(MyApplication.getContext(), addressList.get(position));
//                activityController.startEditAddressActivity(mainActivity, addressList.get(position));
                activityController.startDeliFragment(mainActivity,addressList.get(position));
//                EventBus.getDefault().postSticky(new AddressEvent(addressList.get(position).getId(),addressList.get(position).getPhone(),addressList.get(position).getRealname(),addressList.get(position).getArea(),addressList.get(position).getAddress(),addressList.get(position).getIsdefault()));
//                activityController.startEditAddressActivityWithAddress(mainActivity, addressList.get(position));
                break;
            case R.id.ly_delete:
                position = (int) v.getTag();
                deleteAddress(position);
                break;
        }
    }

    /**
     * 控件管理类
     */
    private class ViewHolder {
        private TextView tv_realname, tv_phone, tv_address, tv_isdefault;
        private CheckBox cb_isdefault;
        private LinearLayout ly_edit, ly_delete;

        ViewHolder(View view) {
            tv_realname = (TextView) view.findViewById(R.id.tv_realname);
            tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            tv_address = (TextView) view.findViewById(R.id.tv_address);
            tv_isdefault = (TextView) view.findViewById(R.id.tv_isdefault);
            cb_isdefault = (CheckBox) view.findViewById(R.id.cb_isdefault);
            ly_edit = (LinearLayout) view.findViewById(R.id.ly_edit);
            ly_delete = (LinearLayout) view.findViewById(R.id.ly_delete);
//            ly_edit.setVisibility(View.GONE);
        }
    }


    /**
     * 设置默认地址
     *
     * @param position
     */
    private void selectDefaultAddress(int position) {
        for (int i = 0; i < addressList.size(); i++) {
            AddressBean address = addressList.get(i);
            address.isdefault = (i == position);
            //升级数据库
            addressController.update(address);
        }
        notifyDataSetChanged();
    }

    /**
     * 删除地址
     *
     * @param position
     */
    private void deleteAddress(int position) {
       final AddressBean address = addressList.get(position);
        new QMUIDialog.MessageDialogBuilder(mainActivity)
                .setTitle("提示")
                .setMessage("确定要删除该地址吗？")
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "删除", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        addressController.delete(address.id);
                        addressList.remove(address);
                            notifyDataSetChanged();
                        Toast.makeText(MyApplication.getContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })

               .show();

//       final CustomDialog selfDialog = new CustomDialog(MyApplication.getContext());
//        selfDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
//        selfDialog.setTitle("");
//        selfDialog.setMessage("确定要删除地址吗");
//        selfDialog.setYesOnclickListener("确定", new CustomDialog.onYesOnclickListener() {
//            @Override
//            public void onYesClick() {
//                addressController.delete(address.id);
//                        addressList.remove(address);
//                            notifyDataSetChanged();
//                        Toast.makeText(MyApplication.getContext(), "删除成功", Toast.LENGTH_SHORT).show();
//                selfDialog.dismiss();
//            }
//        });
//        selfDialog.setNoOnclickListener("取消", new CustomDialog.onNoOnclickListener() {
//            @Override
//            public void onNoClick() {
//
//                selfDialog.dismiss();
//            }
//        });
//        selfDialog.show();

//        final AddressBean address = addressList.get(position);

//        AlertUtils.showAlert(mainActivity, "确定删除" + address.realname + "这条地址吗？", "删除", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //删除数据库
//                addressController.delete(address.id);
//                addressList.remove(address);
//                notifyDataSetChanged();
//            }
//        }, "取消", null);
    }
}
