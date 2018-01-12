package com.app.base.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * 封装WebView
 *
 * @author Haojie.Dai
 */
public class MineWebView extends WebView {

    public MineWebView(Context context) {
        this(context, null);
    }

    public MineWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 禁止长按复制功能
        setOnLongClickListener((View v) -> true);
        // 清除网页访问留下的缓存
        clearCache(true);
        // 清除当前WebView访问的历史记录
        clearHistory();
        // 清除自动完成填充的表单数据
        clearFormData();

        WebSettings webSettings = getSettings();

        // 如果访问的页面中要与Javascript交互，则WebView必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合WebView的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        // 缩放操作
        webSettings.setSupportZoom(false); //支持缩放，默认为true。是下面那个的前提。
        // webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        // webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        // 设置缓存模式操作
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        // LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        // LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        // LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        // LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。

        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        // 储存功能
        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);  // 开启 database storage API 功能
        webSettings.setAppCacheEnabled(true); // 开启 Application Caches 功能
        // webSettings.setAppCachePath(""); // 设置 Application Caches 缓存目录

    }
}
