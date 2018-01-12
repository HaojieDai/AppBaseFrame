package com.app.base.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.app.base.R;
import com.app.base.common.BaseActivity;
import com.app.base.common.JsAndroid;
import com.app.base.common.util.FullScreenUtil;
import com.app.base.common.view.MineWebView;
import com.app.base.common.view.combination.AutoRollBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动页
 *
 * @author Haojie.Dai
 */
public class SplashActivity extends BaseActivity {

    AutoRollBanner mAutoRollBanner;
    MineWebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenUtil.transparentStatusBar(this);
        setContentView(R.layout.activity_splash);
        mTitleBar.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.GONE);
        mContentLayout.setVisibility(View.VISIBLE);
        mAutoRollBanner = (AutoRollBanner) findViewById(R.id.autoRollBanner);

        List<AutoRollBanner.Banner> banners = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            AutoRollBanner.Banner banner = new AutoRollBanner.Banner();
            banners.add(banner);
            if (i == 0) {
                banner.image = "http://img4.imgtn.bdimg.com/it/u=3445958822,3632531790&fm=27&gp=0.jpg";
            } else if (i == 1) {
                banner.image = "http://img0.imgtn.bdimg.com/it/u=3047045095,1422608247&fm=15&gp=0.jpg";
            } else if (i == 2) {
                banner.image = "http://img3.imgtn.bdimg.com/it/u=1747370694,371566551&fm=27&gp=0.jpg";
            } else {
                banner.image = "http://img0.imgtn.bdimg.com/it/u=1584016429,971211395&fm=15&gp=0.jpg";
            }
        }
        mAutoRollBanner.setBanners(banners);

        mWebView = (MineWebView) findViewById(R.id.webView);
        mWebView.loadUrl("https://www.jianshu.com/p/3c94ae673e2a");
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                view.loadUrl("");
            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });

    }
}
