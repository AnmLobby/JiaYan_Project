package com.example.administrator.jiayan_project.ui.fragment.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.db.bean.LikeBean;
import com.example.administrator.jiayan_project.db.bean.LikeBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CartFragment extends BaseFragment {
    @BindView(R.id.one)
    Button one;
    @BindView(R.id.two)
    Button two;
    @BindView(R.id.three)
    Button three;
    @BindView(R.id.four)
    Button four;
    private static final String TAG = "CartFragment";

    @Override
    protected View onCreateView() {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cart, null);
        ButterKnife.bind(this, layout);
        onViewClicked(layout);
        return layout;
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @OnClick({R.id.one, R.id.two, R.id.three, R.id.four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.one:
                LikeBeanDao addressBeanDao=GreenDaoManager.getInstance().getSession().getLikeBeanDao();
                LikeBean addressBean=new LikeBean();
                addressBean.setMoney("东莞市");
                addressBeanDao.insert(addressBean);
                Toast.makeText(MyApplication.getContext(), "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                LikeBeanDao b=GreenDaoManager.getInstance().getSession().getLikeBeanDao();
                b.deleteByKey(Long.valueOf("2"));
                Toast.makeText(MyApplication.getContext(), "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.three:
                List<LikeBean> lis =GreenDaoManager.getInstance().getSession().getLikeBeanDao().queryBuilder().build().list();
                LikeBeanDao bb=GreenDaoManager.getInstance().getSession().getLikeBeanDao();

                for (int i = 0; i < lis.size(); i++) {
                    if (i == 0) {
                        lis.get(0).setMoney("zone==888>");
                        bb.update(lis.get(1));
                    }
                }
                Toast.makeText(MyApplication.getContext(), "3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.four:
                List<LikeBean> list =GreenDaoManager.getInstance().getSession().getLikeBeanDao().queryBuilder()
                        .offset(0)//偏移量，相当于 SQL 语句中的 skip
                        .limit(300)//只获取结果集的前 3 个数据
                        .orderDesc(LikeBeanDao.Properties.Money)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                        .build()
                        .list();
                for (int i = 0; i < list.size(); i++) {
                    Log.d("zoneLog", "studentNumber:-- " +list.get(i).getId()+"--"+list.get(i).getMoney());
                }
                Log.e(TAG, "onViewClicked: "+list.size() );
                Toast.makeText(MyApplication.getContext(), "4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
