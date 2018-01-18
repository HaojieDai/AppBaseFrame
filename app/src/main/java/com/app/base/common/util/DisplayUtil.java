package com.app.base.common.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.app.base.BaseApplication;

/**
 * 关于显示的工具
 *
 * @author Haojie.Dai
 */

public class DisplayUtil {

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param ctx
     * @param pxValue
     * @return
     */
    public static int px2dp(Context ctx, float pxValue) {
        float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp转换成px
     *
     * @param ctx
     * @param dpValue
     * @return
     */
    public static int dp2px(Context ctx, float dpValue) {
        float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param ctx
     * @param pxValue
     * @return
     */
    public static int px2sp(Context ctx, float pxValue) {
        float scale = ctx.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param ctx
     * @param spValue
     * @return
     */
    public static int sp2px(Context ctx, float spValue) {
        float scale = ctx.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * 获取屏幕高度
     *
     * @param ctx
     * @return
     */
    public static int getScreenHeight(Context ctx) {
        WindowManager localWindowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        return localDisplayMetrics.heightPixels;
    }

    /**
     * 获取屏幕宽度
     *
     * @param ctx
     * @return
     */
    public static int getScreenWidth(Context ctx) {
        WindowManager localWindowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
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
            int j = BaseApplication.getApplication().getResources().getDimensionPixelSize(i);
            return j;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return -1;
    }
}
