package com.example.administrator.jiayan_project.ui.fragment.banquetDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.example.administrator.jiayan_project.R;
import com.example.administrator.jiayan_project.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * 高级宴会菜单详情
 *
 */
public class BanquetDetailFragment extends BaseFragment {


    @BindView(R.id.webview)
    WebView mWebView;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_blank_detail, null);
        ButterKnife.bind(this, layout);
//        mWebView.loadUrl("https://www.jianshu.com/p/6e5eda3a51af");
        initWebView();
        return layout;
    }

    private void initWebView() {
        mWebView.getSettings().setJavaScriptEnabled(true);//支持javascript
        mWebView.requestFocus();//触摸焦点起作用mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);//取消滚动条
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置允许js弹出alert对话框
        WebSettings webSettings = mWebView.getSettings();
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小 
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
    }


    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebView.clearHistory();
            ((ViewGroup) mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
    @Override
    protected boolean canDragBack() {
        return false;
    }
}
