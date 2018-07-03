package com.example.administrator.jiayan_project.ui.fragment.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.MainClassifyAdapter;
import com.example.administrator.jiayan_project.adapter.news.HotelEntityAdapter;
import com.example.administrator.jiayan_project.adapter.news.SectionedSpanSizeLookup;
import com.example.administrator.jiayan_project.enity.classify.ClassifyBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyPresenter;
import com.example.administrator.jiayan_project.mvp.classify.MainClassifyView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.ReceptionFragment;
import com.example.administrator.jiayan_project.ui.fragment.chef_service.WZServiceFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TypeFragment extends AbstractMvpFragment<MainClassifyView, MainClassifyPresenter> implements MainClassifyView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.zhaowu)
    TextView zhaowu;
    @BindView(R.id.yanqing)
    TextView yanqing;
    @BindView(R.id.search)
    LinearLayout search;
    private List<ClassifyBean.TypedataBean> classBeans;
    private List<ClassifyBean.TypedataBean.DetailBean> detailBeans;
    private MainClassifyAdapter mainClassifyAdapter;
    private HotelEntityAdapter hotelEntityAdapter;
    private static final String TAG = "TypeFragment";

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_type, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestClassify();
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

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public void resultRegisterSuccess(final ClassifyBean classifyBean) {
        classBeans = classifyBean.getTypedata();
//        for (int i = 0; i <classifyBean.getTypedata().size() ; i++) {
//            detailBeans=classifyBean.getTypedata().get(1).getDetail();
//        }

        hotelEntityAdapter = new HotelEntityAdapter(MyApplication.getContext());

        GridLayoutManager manager = new GridLayoutManager(MyApplication.getContext(), 3);
        //设置header
        manager.setSpanSizeLookup(new SectionedSpanSizeLookup(hotelEntityAdapter, manager));
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(hotelEntityAdapter);

        hotelEntityAdapter.setOnLeftItemClickListener(new HotelEntityAdapter.OnTypeItemClickListener() {
            @Override
            public void onLeftItemClick(int section, int position) {
                String id = String.valueOf(hotelEntityAdapter.allTagList.get(section).getDetail().get(position).getId());
                EventBus.getDefault().postSticky(new StartNewsEvent(id));
                startFragment(new BlankOneFragment());
            }
        });

        hotelEntityAdapter.setData(classBeans);


//        mainClassifyAdapter = new MainClassifyAdapter(classBeans);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(mainClassifyAdapter);


//        mainClassifyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Log.e(TAG, "onItemClick: 水水水水水水水水水水水水水水" );
//            }
//        });
    }

    @Override
    public MainClassifyPresenter createPresenter() {
        return new MainClassifyPresenter();
    }

    @OnClick({R.id.zhaowu, R.id.yanqing,R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhaowu:
                startFragment(new WZServiceFragment());
                break;
            case R.id.yanqing:
                startFragment(new ReceptionFragment());
                break;
            case  R.id.search:
                startFragment(new SearchFragment());
                break;
        }
    }
}
