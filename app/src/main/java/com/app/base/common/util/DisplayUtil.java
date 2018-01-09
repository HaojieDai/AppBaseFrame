package com.app.base.common.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.app.base.Mine;

/**
 * 关于显示的工具
 *
 * @author Haojie.Dai
 */

public class DisplayUtil {

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue
     * @return
     */
    public static int px2dp(float pxValue) {
        float scale = Mine.getApplication().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp转换成px
     *
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        float scale = Mine.getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(float pxValue) {
        float scale = Mine.getApplication().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        float scale = Mine.getApplication().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        WindowManager localWindowManager = (WindowManager) Mine.getApplication().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager localWindowManager = (WindowManager) Mine.getApplication().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.widthPixels;
    }

    /**
     * 获取状态栏的高度
     *
     * @return
     */
    public static int getStatusHeight() {
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object localObject = clazz.newInstance();
            int i = Integer.parseInt(clazz.getField("status_bar_height").get(localObject).toString());
            int j = Mine.getApplication().getResources().getDimensionPixelSize(i);
            return j;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return -1;
    }
}
