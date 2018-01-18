package com.app.base.common.util;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.app.base.common.BaseActivity;

/**
 * 使界面实现全屏的工具类
 *
 * @author Haojie.Dai
 */
public class FullScreenUtil {

    /**
     * 使状态栏透明
     * <p>
     * 如果使用了自定义键盘请使用{@link #translucentStatusBar(BaseActivity)}
     *
     * @param activity
     */
    public static void transparentStatusBar(BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 5.0以上，状态栏全透明
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 4.4以上，状态栏半透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * Android 4.4以上透明化状态栏
     * <p>
     * 如果使用了自定义键盘请使用该方法而不能使用{@link #transparentStatusBar(BaseActivity)}
     *
     * @param activity
     */
    public static void translucentStatusBar(BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 使状态栏和导航栏透明
     *
     * @param activity
     */
    public static void transparent(BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            activity.getWindow().setNavigationBarColor(Color.TRANSPARENT);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 基于Android 4.4的全屏
     * <p>
     * Android 4.4以上隐藏状态栏和虚拟导航栏，Android 4.4以下只隐藏状态栏
     * <p>
     * 如果使用了自定义键盘，请使用{@link #fullBaseOnAndroidAll(BaseActivity)}
     *
     * @param activity
     */
    public static void fullBaseOnAndroid_K(BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    /**
     * 适用于Android所有版本的全屏方法
     * <p>
     * 该方法只隐藏状态栏，但虚拟导航栏不隐藏
     * <p>
     * 如果使用了自定义键盘请使用该方法而不能使用{@link #fullBaseOnAndroid_K(BaseActivity)}
     *
     * @param activity
     */
    public static void fullBaseOnAndroidAll(BaseActivity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
