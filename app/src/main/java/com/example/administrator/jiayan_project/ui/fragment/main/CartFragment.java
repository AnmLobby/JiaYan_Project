package com.example.administrator.jiayan_project.ui.fragment.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.ShoppingCartAdapter;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.cart.CartBean;
import com.example.administrator.jiayan_project.enity.cart.CartBean.DataBean;
import com.example.administrator.jiayan_project.http.Constants;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.cart.CartPresenter;
import com.example.administrator.jiayan_project.mvp.cart.CartView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetOrderFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.example.administrator.jiayan_project.utils.util.DateUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * 购物车fragment，底部栏第三个
 */
public class CartFragment extends AbstractMvpFragment<CartView, CartPresenter> implements CartView, View.OnClickListener, ShoppingCartAdapter.CheckInterface, ShoppingCartAdapter.ModifyCountInterface{
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
    private List<CartBean.DataBean> shoppingCartBeanList = new ArrayList<>();
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    private int userid;
    private List<KeepUserBean> list;
    private static final String TAG = "CartFragment";
    private Boolean isPause = false;
    private String order_people,order_num,order_price,order_dinnerid,order_color,order_url,order_name;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cart, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        textView = new TextView(MyApplication.getContext());
        shoppingCartAdapter = new ShoppingCartAdapter(MyApplication.getContext());
        initTopBar();
        initData();
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 1 个数据
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
        userid=list.get(0).getUserId();
        getPresenter().clickRequestCart(userid);

        return layout;
    }
    protected void initData() {
//        for (int i = 0; i < 3; i++) {
//            CartBean.DataBean shoppingCartBean = new CartBean.DataBean();
//            shoppingCartBean.setShoppingName("上档次的T桖");
//            shoppingCartBean.setDressSize(456465414);
////            shoppingCartBean.setId(i);
//            shoppingCartBean.setPrice(3045454545.6);
//            shoppingCartBean.setCount(1);
//            shoppingCartBean.setImageUrl("https://img.alicdn.com/bao/uploaded/i2/TB1YfERKVXXXXanaFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg");
//            shoppingCartBeanList.add(shoppingCartBean);
//        }
//        for (int i = 0; i < 2; i++) {
//            CartBean.DataBean shoppingCartBean = new CartBean.DataBean();
//            shoppingCartBean.setShoppingName("瑞士正品夜光男女士手表情侣精钢带男表防水石英学生非天王星机械");
//            shoppingCartBean.setAttribute("黑白色");
//            shoppingCartBean.setPrice(84569);
////            shoppingCartBean.setId(i+3);
//            shoppingCartBean.setCount(3);
//            shoppingCartBean.setImageUrl("https://gd1.alicdn.com/imgextra/i1/2160089910/TB2M_NSbB0kpuFjSsppXXcGTXXa_!!2160089910.jpg");
//            shoppingCartBeanList.add(shoppingCartBean);
//        }

    }
    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void onPause() {
        super.onPause();
        isPause = true; //记录页面已经被暂停
    }

    @Override
    public void onResume() {
        super.onResume();

        if (isPause) { //判断是否暂停
            isPause = false;

            Observable.timer(100, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                            getPresenter().clickRequestCart(userid);
                        }
                    });


            tvShowPrice.setText("¥  0.0"  );
            tvSettlement.setText("结算(" + 0 + ")");
        }

    }
    @Override
    public void resultUserSuccess(CartBean cartBean) {
        shoppingCartBeanList=cartBean.getData();
        shoppingCartAdapter.setCheckInterface(this);
        shoppingCartAdapter.setModifyCountInterface(this);
        list_shopping_cart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setShoppingCartBeanList(getActivity(),shoppingCartBeanList);
    }

    @Override
    public void resultDeleteSuccess(FavoritrResultBean favoritrResultBean) {
                Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
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
        for (CartBean.DataBean bean:shoppingCartBeanList ){
            boolean choosed = bean.isChoosed();
            if (choosed){
                String shoppingName = bean.getDinnername();
                int count = bean.getNum();
                double price = bean.getPrice();
                int size = bean.getRen();
                String attribute = bean.getSubname();
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
        CartBean.DataBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getPrice();
        if (currentCount == 1) {
            return;
        }
        currentCount--;
        shoppingCartBean.setPrice(currentCount);
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
//        删除条目在这里操作
//        Log.e(TAG, "childDelete: 删除"+   shoppingCartBeanList.get(position).getId());
        getPresenter().deleteToCart(userid, Integer.parseInt(shoppingCartBeanList.get(position).getDetail()),shoppingCartBeanList.get(position).getNum(),shoppingCartBeanList.get(position).getId(),shoppingCartBeanList.get(position).getRen());
        shoppingCartBeanList.remove(position);
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }

    /**
     * 条目点击
     * @param position
     */
    @Override
    public void onItemLayoutClick(int position) {
        String id = String.valueOf(shoppingCartBeanList.get(position).getId());
        EventBus.getDefault().postSticky(new StartNewsEvent(id));
        startFragment(new BlankOneFragment());
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
            CartBean.DataBean shoppingCartBean = shoppingCartBeanList.get(i);
            if (shoppingCartBean.isChoosed()) {
                totalCount++;
                totalPrice += shoppingCartBean.getPrice() * shoppingCartBean.getNum();
                order_color=shoppingCartBean.getSname();
                order_people= String.valueOf(shoppingCartBean.getRen());
                order_num= String.valueOf(shoppingCartBean.getNum());
                order_dinnerid= String.valueOf(shoppingCartBean.getId());
                order_price= String.valueOf(shoppingCartBean.getPrice());
                order_url= Constants.BaseUrl+shoppingCartBean.getOriginalimg();
                order_name=shoppingCartBean.getDinnername();
                tvSettlement.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BanquetOrderFragment orderFragment=new BanquetOrderFragment();
                        Bundle bundle=new Bundle();
                        bundle.putString("color", order_color);
                        bundle.putString("num", order_num);
                        bundle.putString("people", order_people);
                        bundle.putString("price", order_price);
                        bundle.putString("name", order_name);
                        bundle.putString("imageurl",order_url);
                        orderFragment.setArguments(bundle);
                        startFragment(orderFragment);
                    }
                });
            }
        }
        tvShowPrice.setText("¥ " + totalPrice);
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
        CartBean.DataBean shoppingCartBean = shoppingCartBeanList.get(position);
        int currentCount = shoppingCartBean.getNum();
        currentCount++;
        shoppingCartBean.setNum(currentCount);
        ((TextView) showCountView).setText(currentCount + "");
        shoppingCartAdapter.notifyDataSetChanged();
        statistics();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
