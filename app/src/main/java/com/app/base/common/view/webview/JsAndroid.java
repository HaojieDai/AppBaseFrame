package com.app.base.common.view.webview;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * js交互
 *
 * @author Haojie.Dai
 */
public class JsAndroid {

    public static final String NAME = "JsAndroid";
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private WebView webView;
    private HtmlReceiver htmlReceiver;

    public JsAndroid(WebView webView){
        this.webView = webView;
    }

    @JavascriptInterface
    public void html(String html) {
        if (htmlReceiver != null) {
            mHandler.post(() -> htmlReceiver.onReceive(html));
        }
    }

    /**
     * 设置Html接收器
     *
     * @param htmlReceiver
     */
    public void setHtmlReceiver(HtmlReceiver htmlReceiver) {
        this.htmlReceiver = htmlReceiver;
    }

    /**
     * Html接收器
     *
     * @author Haojie.Dai
     */
    public interface HtmlReceiver {

        /**
         * 处理html内容
         *
         * @param html
         */
        void onReceive(String html);
    }
}
