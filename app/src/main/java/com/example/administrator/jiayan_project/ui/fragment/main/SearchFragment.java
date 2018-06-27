package com.example.administrator.jiayan_project.ui.fragment.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.jiayan_project.MyApplication;
import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.adapter.adapter.SearchAdapter;
import com.example.administrator.jiayan_project.enity.search.HotSearchBean;
import com.example.administrator.jiayan_project.enity.search.SearchResultBean;
import com.example.administrator.jiayan_project.mvp.base.AbstractMvpFragment;
import com.example.administrator.jiayan_project.mvp.search.SearchRequestPresenter;
import com.example.administrator.jiayan_project.mvp.search.SearchRequestView;
import com.example.administrator.jiayan_project.ui.fragment.banquetDetail.BlankOneFragment;
import com.example.administrator.jiayan_project.utils.eventbus.StartNewsEvent;
import com.example.administrator.jiayan_project.utils.helper.RudenessScreenHelper;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;


public class SearchFragment extends AbstractMvpFragment<SearchRequestView, SearchRequestPresenter> implements SearchRequestView {
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.layout_tag)
    TagContainerLayout layoutTag;
    @BindView(R.id.layout_search)
    RelativeLayout layoutSearch;
    private static final String TAG = "SearchFragment";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<SearchResultBean.DateBean> dateBeans = new ArrayList<>();
    private SearchAdapter searchAdapter;
    private View errorView;
    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_search, null);
        RudenessScreenHelper.resetDensity(MyApplication.getContext(), 1080);
        ButterKnife.bind(this, layout);
        getPresenter().clickRequestList();
        initListener();
        return layout;
    }

    @OnClick({R.id.tv_cancel, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                popBackStack();
                break;
            case R.id.tv_search:

                break;
        }
    }

    private void initListener() {
        layoutTag.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                etSearch.setText(text);
                etSearch.setSelection(text.length());
                getPresenter().clickRequestResult(text);
                closeKeyboard();
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    getPresenter().clickRequestResult(etSearch.getText().toString());
                }

                return false;
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(MyApplication.getContext(), "搜索内容不能为空。", Toast.LENGTH_SHORT).show();
                    return;
                }
                getPresenter().clickRequestResult(etSearch.getText().toString());
                closeKeyboard();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        etSearch.requestFocus();
        InputMethodManager inputManager = (InputMethodManager) etSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(etSearch, 0);
    }

    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSearchSuccess(SearchResultBean searchResultBean) {
        errorView= getLayoutInflater().inflate(R.layout.search_empty, (ViewGroup) recyclerview.getParent(), false);
        layoutSearch.setVisibility(View.GONE);
        int code = searchResultBean.getCode();
        dateBeans = searchResultBean.getDate();
        searchAdapter = new SearchAdapter(dateBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApplication.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
//        recyclerview.setAdapter(searchAdapter);
        switch (code){
            case 200:
                recyclerview.setAdapter(searchAdapter);
                searchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String id= String.valueOf(searchAdapter.getData().get(position).getId());
                        EventBus.getDefault().postSticky(new StartNewsEvent(id));
                        startFragment(new BlankOneFragment());
                    }
                });
                break;
            case 400:
                searchAdapter.setEmptyView(errorView);
                recyclerview.setAdapter(searchAdapter);
        }
    }

    @Override
    public void hotListSuccess(HotSearchBean hotSearchBean) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < hotSearchBean.getDate().size(); i++) {
            stringList.add(hotSearchBean.getDate().get(i).getDinnername());
        }
        layoutTag.setTags(stringList);
    }

    @Override
    public void resultFailure(String result) {

    }

    @Override
    public SearchRequestPresenter createPresenter() {
        return new SearchRequestPresenter();
    }

    private void closeKeyboard() {
        View view = getActivity().getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected boolean canDragBack() {
        return false;
    }
}
