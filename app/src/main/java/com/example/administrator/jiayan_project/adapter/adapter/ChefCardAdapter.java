package com.example.administrator.jiayan_project.adapter.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.enity.cart.ShoppingChefBean;
import com.example.administrator.jiayan_project.enity.cart.ShoppingChefBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.ui.fragment.main.CartFragment;
import com.example.administrator.jiayan_project.utils.util.StringUtil;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import com.vondear.rxtools.view.dialog.RxDialogSureCancel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/7/007.
 */

public class ChefCardAdapter extends BaseAdapter {
    private boolean isShow = true;//是否显示编辑/完成
    private List<ShoppingChefBean.DataBean> chefBeanList;
    private CheckInterfaceChef checkInterface;
    private ModifyCountInterfaceChef modifyCountInterface;
    private Context context;
    private Activity mainActivity;
    private LayoutInflater mInflater;
    private String strChef;
    private int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
    public ChefCardAdapter(Context context) {
        this.context = context;
    }

    public void setShoppingChefBeanList(Activity mainActivity,List<ShoppingChefBean.DataBean> chefBeanList) {
        this.chefBeanList = chefBeanList;
        this.mainActivity = mainActivity;
        mInflater = LayoutInflater.from(mainActivity);
        notifyDataSetChanged();
    }
    /**
     * 单选接口
     *
     * @param checkInterfaceChef
     */
    public void setCheckInterfaceChef(CheckInterfaceChef checkInterface) {
        this.checkInterface = checkInterface;
    }

    /**
     * 改变商品数量接口
     *
     * @param modifyCountInterface
     */
    public void setModifyCountInterface(ModifyCountInterfaceChef modifyCountInterface) {
        this.modifyCountInterface = modifyCountInterface;
    }

    @Override
    public int getCount() {
        return chefBeanList == null ? 0 : chefBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return chefBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /**
     * 是否显示可编辑
     *
     * @param flag
     */
    public void isShow(boolean flag) {
        isShow = flag;
        notifyDataSetChanged();
    }

    public void  setAllCheckFalse(){

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ChefCardAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_shopping_chef_layout, parent, false);
            holder = new ChefCardAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChefCardAdapter.ViewHolder) convertView.getTag();
        }
        final ShoppingChefBean.DataBean shoppingCartBean = chefBeanList.get(position);
        boolean choosed = shoppingCartBean.isChoosed();

        if (choosed){
            holder.ckOneChosechef.setChecked(true);
        }else{
            holder.ckOneChosechef.setChecked(false);
        }
        String attribute =shoppingCartBean.getCuisine();
//        if (!StringUtil.isEmpty(attribute)){
            holder.tvCommodityAttrchef.setText(attribute);
//        }else{
//            holder.tvCommodityAttrchef.setText(shoppingCartBean.getSname()+"");
//        }
        holder.tvCommodityNamechef.setText(shoppingCartBean.getCookname());
        if (shoppingCartBean.getServe()==1){
            strChef= String.valueOf(shoppingCartBean.getPrice());
        }
        switch (shoppingCartBean.getServe()){
            case 1:
                strChef= "包月服务：¥"+String.valueOf(shoppingCartBean.getPrice());
                break;
            case 2:
                strChef= "半年服务：¥"+String.valueOf(shoppingCartBean.getBanprice());
                break;
            case 3:
                strChef= "包年服务：¥"+String.valueOf(shoppingCartBean.getNianprice());
                break;
        }
        holder.peoplechef.setText(strChef);

//        Constants.BaseUrl+
        Glide.with(MyApplication.getContext()).load(Constants.BaseUrl+shoppingCartBean.getCookimg()).into(holder.ivShowPicchef);
//        ImageLoader.getInstance().displayImage(shoppingCartBean.getImageUrl(),holder.ivShowPicchef);
        //单选框按钮
        holder.ckOneChosechef.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        for (int i = 0; i < chefBeanList.size(); i++) {
                            if (position == i) {// 设置已选位置
                                chefBeanList.get(i).setChoosed(true);
                            } else {
                                chefBeanList.get(i).setChoosed(false);
                            }
                        }
//                        .notifyDataSetChanged();

                        shoppingCartBean.setChoosed(((CheckBox) v).isChecked());
                        checkInterface.checkGroupChef(position, ((CheckBox) v).isChecked());//向外暴露接口
                    }
                }
        );
        holder.relativeLayoutChef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifyCountInterface.onItemLayoutClickChef(position);
            }
        });
//        //增加按钮
//        holder.ivAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                modifyCountInterface.doIncreaseChef(position, holder.tvCommodityShowNum, holder.ckOneChosechef.isChecked());//暴露增加接口
//            }
//        });
//        //删减按钮
//        holder.ivSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                modifyCountInterface.doDecrease(position, holder.tvCommodityShowNum, holder.ckOneChosechef.isChecked());//暴露删减接口
//            }
//        });
        //删除弹窗
        holder.tvCommodityDeletechef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(mainActivity);//提示弹窗
//                rxDialogSureCancel.getContentView().setText("确定要删除该商品吗？");
//                rxDialogSureCancel.getTitleView().setBackgroundResource(R.drawable.logoo);
//                rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        modifyCountInterface.childDeleteChef(position);//删除 目前只是从item中移除
//                        rxDialogSureCancel.cancel();
//                    }
//                });
//                rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        rxDialogSureCancel.cancel();
//                    }
//                });
//                rxDialogSureCancel.show();
                new QMUIDialog.MessageDialogBuilder(mainActivity)
                        .setTitle("提示：")
                        .setMessage("确定要删除该厨师吗？")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .addAction(0, "删除", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                modifyCountInterface.childDeleteChef(position);//删除 目前只是从item中移除
                                dialog.dismiss();
                            }
                        })
                        .create(mCurrentDialogStyle).show();

//                AlertDialog alert = new AlertDialog.Builder(mainActivity).create();
//                alert.setTitle("操作提示");
//                alert.setMessage("您确定要将这些商品从购物车中移除吗？");
//                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                return;
//                            }
//                        });
//                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                modifyCountInterface.childDelete(position);//删除 目前只是从item中移除
//
//                            }
//                        });
//                alert.show();
            }
        });
        //判断是否在编辑状态下
        if (isShow) {
            holder.tvCommodityNamechef.setVisibility(View.VISIBLE);
            holder.tvCommodityDeletechef.setVisibility(View.GONE);
        } else {
            holder.tvCommodityNamechef.setVisibility(View.VISIBLE);
            holder.tvCommodityDeletechef.setVisibility(View.VISIBLE);
        }
        return convertView;
    }




    //初始化控件
    class ViewHolder {
        ImageView ivShowPicchef,tvCommodityDeletechef;
        TextView tvCommodityNamechef, tvCommodityAttrchef, tvCommodityPricechef, tvCommodityNumchef, tvCommodityShowNumchef,peoplechef;
        CheckBox ckOneChosechef;
   
        RelativeLayout relativeLayoutChef;
        public ViewHolder(View itemView) {
            relativeLayoutChef=(RelativeLayout) itemView.findViewById(R.id.rela_layoutchef);
            ckOneChosechef = (CheckBox) itemView.findViewById(R.id.ck_chosechef);
            ivShowPicchef = (ImageView) itemView.findViewById(R.id.iv_show_picchef);
            tvCommodityNamechef = (TextView) itemView.findViewById(R.id.tv_commodity_namechef);
            tvCommodityAttrchef = (TextView) itemView.findViewById(R.id.tv_commodity_attrchef);
            tvCommodityDeletechef = (ImageView) itemView.findViewById(R.id.tv_commodity_deletechef);
            peoplechef= (TextView) itemView.findViewById(R.id.peoplechef);
        }
    }
    /**
     * 复选框接口
     */
    public interface CheckInterfaceChef {
        /**
         * 组选框状态改变触发的事件
         *
         * @param position  元素位置
         * @param isChecked 元素选中与否
         */
        void checkGroupChef(int position, boolean isChecked);
    }


//    /**
//     * 改变数量的接口
//     */
    public interface ModifyCountInterfaceChef {
//        /**
//         * 增加操作
//         *
//         * @param position      元素位置
//         * @param showCountView 用于展示变化后数量的View
//         * @param isChecked     子元素选中与否
//         */
//        void doIncrease(int position, View showCountView, boolean isChecked);
//
//        /**
//         * 删减操作
//         *
//         * @param position      元素位置
//         * @param showCountView 用于展示变化后数量的View
//         * @param isChecked     子元素选中与否
//         */
//        void doDecrease(int position, View showCountView, boolean isChecked);

        /**
         * 删除子item
         *
         * @param position
         */
        void childDeleteChef(int position);

        void onItemLayoutClickChef(int position);
    }
}

