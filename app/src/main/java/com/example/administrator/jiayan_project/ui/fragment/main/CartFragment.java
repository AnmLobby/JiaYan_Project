package com.example.administrator.jiayan_project.ui.fragment.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.ShoppingCartAdapter;
import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.enity.cart.ShoppingCartBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.cart.CartPresenter;
import com.example.administrator.jiayan_project.mvp.cart.CartView;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 购物车fragment，底部栏第三个
 */
public class CartFragment extends AbstractMvpFragment<CartView, CartPresenter> implements CartView, View.OnClickListener, ShoppingCartAdapter.CheckInterface, ShoppingCartAdapter.ModifyCountInterface {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.list_shopping_cart)
    ListView list_shopping_cart;
   //合计
    @BindView(R.id.tv_show_price)
    TextView tvShowPrice;
    //结算
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    private TextView textView;
    private boolean flag = false;
    private ShoppingCartAdapter shoppingCartAdapter;
    private List<ShoppingCartBean> shoppingCartBeanList = new ArrayList<>();
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cart, null);
        ButterKnife.bind(this, layout);
        textView = new TextView(MyApplication.getContext());
        initTopBar();
        initData();
        return layout;
    }
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
            shoppingCartBean.setShoppingName("上档次的T桖");
            shoppingCartBean.setDressSize(456465414);
            shoppingCartBean.setId(i);
            shoppingCartBean.setPrice(3045454545.6);
            shoppingCartBean.setCount(1);
            shoppingCartBean.setImageUrl("https://img.alicdn.com/bao/uploaded/i2/TB1YfERKVXXXXanaFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
            shoppingCartBeanList.add(shoppingCartBean);
        }
        for (int i = 0; i < 2; i++) {
            ShoppingCartBean shoppingCartBean = new ShoppingCartBean();
            shoppingCartBean.setShoppingName("瑞士正品夜光男女士手表情侣精钢带男表防水石英学生非天王星机械");
            shoppingCartBean.setAttribute("黑白色");
            shoppingCartBean.setPrice(84569);
            shoppingCartBean.setId(i+3);
            shoppingCartBean.setCount(3);
            shoppingCartBean.setImageUrl("https://gd1.alicdn.com/imgextra/i1/2160089910/TB2M_NSbB0kpuFjSsppXXcGTXXa_!!2160089910.jpg");
            shoppingCartBeanList.add(shoppingCartBean);
        }
        shoppingCartAdapter = new ShoppingCartAdapter(MyApplication.getContext());
        shoppingCartAdapter.setCheckInterface(this);
        shoppingCartAdapter.setModifyCountInterface(this);
        list_shopping_cart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setShoppingCartBeanList(getActivity(),shoppingCartBeanList);
    }
    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultUserSuccess(CartBean cartBean) {

    }

    @Override
    public CartPresenter createPresenter() {
        return new CartPresenter();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    private void initTopBar() {
        mTopBar.setBackgroundDividerEnabled(false);
        mTopBar.setTitle("购物车");
        textView.setText("编辑");
        textView.setTextSize(16);
        textView.setPadding(0, 55, 50, 0);
        mTopBar.addRightView(textView, R.id.topbar_right_about_button);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = !flag;
                if (flag) {
                    textView.setText("完成");
                    shoppingCartAdapter.isShow(false);
                } else {
                    textView.setText("编辑");
                    shoppingCartAdapter.isShow(true);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_settlement: //结算
                lementOnder();
                break;
        }
    }
    private void lementOnder() {
        //选中的需要提交的商品清单
        for (ShoppingCartBean bean:shoppingCartBeanList ){
            boolean choosed = bean.isChoosed();
            if (choosed){
                String shoppingName = bean.getShoppingName();
                int count = bean.getCount();
                double price = bean.getPrice();
                int size = bean.getDressSize();
                String attribute = bean.getAttribute();
                int id = bean.getId();
            }
        }
        //跳转到支付界面
    }
    @Override
    public void checkGroup(int position, boolean isChecked) {
        shoppingCartBeanList.get(position).setChoosed(isChecked);
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }

    /**
     * 删减
     *
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */
    @Override
    public void doDecrease(int position, View showCountView, boolean isChecked) {
        ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getCount();
        if (currentCount == 1) {
            return;
        }
        currentCount--;
        shoppingCartBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }

    /**
     * 删除
     *
     * @param position
     */
    @Override
    public void childDelete(int position) {
        //删除条目在这里操作
        shoppingCartBeanList.remove(position);
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    /**
     * 统计操作
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作
     * 3.给底部的textView进行数据填充
     */
    public void statistics() {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < shoppingCartBeanList.size(); i++) {
            ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(i);
            if (shoppingCartBean.isChoosed()) {
                totalCount++;
                totalPrice += shoppingCartBean.getPrice() * shoppingCartBean.getCount();
            }
        }
        tvShowPrice.setText("合计:" + totalPrice);
        tvSettlement.setText("结算(" + totalCount + ")");
    }
    /**
     * 增加
     * @param position      组元素位置
     * @param showCountView 用于展示变化后数量的View
     * @param isChecked     子元素选中与否
     */
    @Override
    public void doIncrease(int position, View showCountView, boolean isChecked) {
        ShoppingCartBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getCount();
        currentCount++;
        shoppingCartBean.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
