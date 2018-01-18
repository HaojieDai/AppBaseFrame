package com.app.base.common.util;

import android.os.Environment;

import com.app.base.BaseApplication;

import java.io.File;

/**
 * 存储卡工具类
 *
 * @author Haojie.Dai
 */
public class SDCardUtil {

    /**
     * 内存卡可用
     *
     * @return
     */
    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 获取外存储File文件夹路径
     *
     * @return
     */
    public static String getSDCardFileDir() {
        return BaseApplication.getApplication().getExternalFilesDir(null).getAbsolutePath();
    }

    /**
     * 获取内存储File文件夹路径
     *
     * @return
     */
    public static String getFilePath() {
        return BaseApplication.getApplication().getFilesDir().getAbsolutePath();
    }

    /**
     * 获取表情文件夹路径
     *
     * @return
     */
    public static String getExpressionPath() {
        return getFilePath() + File.separator + "expression";
    }
}
