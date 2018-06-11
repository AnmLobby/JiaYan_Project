package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 高级宴会菜单切换fragment
 */
public class BlankOneFragment extends BaseFragment {
    @BindView(R.id.pager)
    QMUIViewPager mViewPager;
    @BindView(R.id.tabs)
    QMUITabSegment mTabSegment;
    @BindView(R.id.toolbar)
    ImageView toolbar;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        QMUIStatusBarHelper.setStatusBarLightMode(getBaseFragmentActivity());
        initTabs();
        initPagers();
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        return layout;
    }

    private void initTabs() {
        int normalColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_black);
        int selectColor = QMUIResHelper.getAttrColor(getActivity(), R.attr.qmui_config_color_blue);
        mTabSegment.setDefaultNormalColor(normalColor);
        mTabSegment.setDefaultSelectedColor(selectColor);
        mTabSegment.setHasIndicator(true);
        mTabSegment.setIndicatorPosition(false);
        mTabSegment.setIndicatorWidthAdjustContent(true);
    }

    private void initPagers() {
        QMUIPagerAdapter pagerAdapter = new QMUIPagerAdapter() {
            private FragmentTransaction mCurrentTransaction;
            private Fragment mCurrentPrimaryItem = null;

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == ((Fragment) object).getView();
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "商品";
                    case 1:
                        return "详情";
                    case 2:
                    default:
                        return "评价";
                }
            }

            @Override
            protected Object hydrate(ViewGroup container, int position) {
                switch (position) {
                    case 0:
                        return new BanquetFragment();
                    case 1:
                        return new BanquetDetailFragment();
                    case 2:
                    default:
                        return new BanquetCommentFragment();

                }
            }

            @SuppressLint("CommitTransaction")
            @Override
            protected void populate(ViewGroup container, Object item, int position) {
                String name = makeFragmentName(container.getId(), position);
                if (mCurrentTransaction == null) {
                    mCurrentTransaction = getChildFragmentManager()
                            .beginTransaction();
                }
                Fragment fragment = getChildFragmentManager().findFragmentByTag(name);
                if (fragment != null) {
                    mCurrentTransaction.attach(fragment);
                } else {
                    fragment = (Fragment) item;
                    mCurrentTransaction.add(container.getId(), fragment, name);
                }
                if (fragment != mCurrentPrimaryItem) {
                    fragment.setMenuVisibility(false);
                    fragment.setUserVisibleHint(false);
                }
            }

            @SuppressLint("CommitTransaction")
            @Override
            protected void destroy(ViewGroup container, int position, Object object) {
                if (mCurrentTransaction == null) {
                    mCurrentTransaction = getChildFragmentManager()
                            .beginTransaction();
                }
                mCurrentTransaction.detach((Fragment) object);
            }

            @Override
            public void startUpdate(ViewGroup container) {
                if (container.getId() == View.NO_ID) {
                    throw new IllegalStateException("ViewPager with adapter " + this
                            + " requires a view id");
                }
            }

            @Override
            public void finishUpdate(ViewGroup container) {
                if (mCurrentTransaction != null) {
                    mCurrentTransaction.commitNowAllowingStateLoss();
                    mCurrentTransaction = null;
                }
            }

            @Override
            public void setPrimaryItem(ViewGroup container, int position, Object object) {
                Fragment fragment = (Fragment) object;
                if (fragment != mCurrentPrimaryItem) {
                    if (mCurrentPrimaryItem != null) {
                        mCurrentPrimaryItem.setMenuVisibility(false);
                        mCurrentPrimaryItem.setUserVisibleHint(false);
                    }
                    if (fragment != null) {
                        fragment.setMenuVisibility(true);
                        fragment.setUserVisibleHint(true);
                    }
                    mCurrentPrimaryItem = fragment;
                }
            }

            private String makeFragmentName(int viewId, long id) {
                return "QDFitSystemWindowViewPagerFragment:" + viewId + ":" + id;
            }
        };
        mViewPager.setAdapter(pagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(getBaseFragmentActivity());
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
