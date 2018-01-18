package com.app.base.common.view.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 自定义WebViewClient
 *
 * @author Haojie.Dai
 */
public class X5WebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        view.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        view.loadUrl("javascript:window." + JsAndroid.NAME + ".html(document.body.innerHTML);");
    }
}
