package com.example.administrator.jiayan_project.ui.fragment.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.BigYanAdapter;
import com.example.administrator.jiayan_project.adapter.adapter.MyFavoriteAdapter;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;
import com.example.administrator.jiayan_project.db.greendao.GreenDaoManager;
import com.example.administrator.jiayan_project.enity.banquet.FavoritrResultBean;
import com.example.administrator.jiayan_project.enity.favourite.FavouriteBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanPresenter;
import com.example.administrator.jiayan_project.mvp.big_yanxi.BigYanView;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoritePresenter;
import com.example.administrator.jiayan_project.mvp.myFavorite.MyFavoriteView;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BanquetFragment;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我所喜欢的，收藏fragment
 */
public class MyFavoriteFragment extends AbstractMvpFragment<MyFavoriteView, MyFavoritePresenter> implements MyFavoriteView {
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private List<KeepUserBean> list;
    private static final String TAG = "MyFavoriteFragment";
    private List<FavouriteBean.DataBean> dataBeans;
    private MyFavoriteAdapter myFavoriteAdapter;
    int UserId;
    private View errorView;
    @Override
    protected View onCreateView() {
        FrameLayout layout = ( FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_my_favorite, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        initTopBar();
        list = GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder()
                .offset(0)//偏移量，相当于 SQL 语句中的 skip
                .limit(1)//只获取结果集的前 3 个数据
                .orderDesc(KeepUserBeanDao.Properties.Id)//通过 StudentNum 这个属性进行正序排序  Desc倒序
                .build()
                .list();
         UserId=list.get(0).getUserId();
        getPresenter().clickRequestNews(String.valueOf(UserId));
        return layout;
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultMyFavoriteSuccess(FavouriteBean favouriteBean) {
        errorView= getLayoutInflater().inflate(R.layout.empty_love, (ViewGroup) recyclerView.getParent(), false);
        int code=favouriteBean.getCode();
        dataBeans=favouriteBean.getData();
        myFavoriteAdapter = new MyFavoriteAdapter(dataBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myFavoriteAdapter);
        switch (code){
            case 200:
//                if (dataBeans.size()==0){
//                    myFavoriteAdapter.setEmptyView(getView());
//                }
                myFavoriteAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        FavouriteBean.DataBean sta = (FavouriteBean.DataBean) adapter.getItem(position);
                        switch (view.getId()) {
                            case R.id.cancel:
                                int  content = sta.getId();
                                myFavoriteAdapter.remove(position);
                          if (dataBeans.size()==0){
                              myFavoriteAdapter.setEmptyView(errorView);
                          }
                                getPresenter().clickDeleteLove(UserId,content);
                                break;
//                            case R.id.buy:
//
//                                break;

                        }
                    }
                });
                myFavoriteAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String id= String.valueOf(myFavoriteAdapter.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
                break;
            case 404:
                myFavoriteAdapter.setEmptyView(errorView);
        }

    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
    @Override
    public void resultDeleteMyFavoriteSuccess(FavoritrResultBean favoritrResultBean) {
        Toast.makeText(MyApplication.getContext(), favoritrResultBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.MyFavorite);
    }

    @Override
    public MyFavoritePresenter createPresenter() {
        return new MyFavoritePresenter();
    }
}
