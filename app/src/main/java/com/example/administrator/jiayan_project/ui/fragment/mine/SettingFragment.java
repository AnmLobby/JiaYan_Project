package com.example.administrator.jiayan_project.ui.fragment.mine;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.app.ContantsName;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.ui.fragment.main.MineFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SettingFragment extends BaseFragment {

    private static final String TAG = "SettingFragment";
    @BindView(R.id.groupListView)
    QMUIGroupListView mGroupListView;
    @BindView(R.id.mtopbar)
    QMUITopBar mTopBar;



    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_setting, null);
        ButterKnife.bind(this, layout);
        initTopBar();
        initList();

        return layout;
    }

    private void initList() {
        View.OnClickListener onClickListener = null;
        QMUICommonListItemView itemWithChevron = mGroupListView.createItemView("安全设置");
        itemWithChevron.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron.setImageDrawable(getResources().getDrawable(R.mipmap.set));
        itemWithChevron.setOrientation(QMUICommonListItemView.VERTICAL);


        QMUICommonListItemView itemWithChevron1 = mGroupListView.createItemView("消息提醒");
        itemWithChevron1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron1.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron1.setImageDrawable(getResources().getDrawable(R.mipmap.notif));
        itemWithChevron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment(new MineFragment());
            }
        });
        QMUICommonListItemView itemWithChevron2 = mGroupListView.createItemView("版本更新");
        itemWithChevron2.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron2.setImageDrawable(getResources().getDrawable(R.mipmap.updata));
        itemWithChevron2.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startFragment(new SettingFragment());
            }
        });
        QMUICommonListItemView itemWithChevron3 = mGroupListView.createItemView("关于我们");
        itemWithChevron3.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron3.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron3.setImageDrawable(getResources().getDrawable(R.mipmap.about));
        itemWithChevron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutFragment aboutFragment=new AboutFragment();
                    startFragment(aboutFragment);
            }
        });
        QMUICommonListItemView itemWithChevron4 = mGroupListView.createItemView("联系我们");
        itemWithChevron4.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron4.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron4.setImageDrawable(getResources().getDrawable(R.mipmap.call));
        itemWithChevron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUICommonListItemView itemWithChevron5 = mGroupListView.createItemView("意见反馈");
        itemWithChevron5.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);
        itemWithChevron5.setOrientation(QMUICommonListItemView.VERTICAL);
        itemWithChevron5.setImageDrawable(getResources().getDrawable(R.mipmap.yijian));
        itemWithChevron5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(itemWithChevron, onClickListener)
                .addTo(mGroupListView);
        QMUIGroupListView.newSection(getContext())
                .addItemView(itemWithChevron1, onClickListener)
                .addItemView(itemWithChevron2, onClickListener)
                .addItemView(itemWithChevron3, onClickListener)
                .addItemView(itemWithChevron4, onClickListener)
                .addTo(mGroupListView);
        QMUIGroupListView.newSection(getContext())
                .setTitle("")
                .addItemView(itemWithChevron5, onClickListener)
                .addTo(mGroupListView);

    }

    private void initTopBar() {
        mTopBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        mTopBar.setTitle(ContantsName.SettingName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView: " );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }
}
