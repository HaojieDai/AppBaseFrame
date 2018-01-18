package com.app.base.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.base.BaseApplication;

import java.util.Map;

/**
 * SharedPreferences工具
 *
 * @author Haojie.Dai
 */
public class SharedPreferencesUtil {

    /**
     * 获取SharedPreferences文件
     *
     * @param name 文件名
     * @return
     */
    public static SharedPreferences getSharedPreferences(String name) {
        return BaseApplication.getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    /**
     * 获取文件中的int值，没有则返回0
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static int getInt(String name, String key) {
        return getSharedPreferences(name).getInt(key, 0);
    }

    /**
     * 获取文件中的int值，没有则返回0
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static int getInt(SharedPreferences sp, String key) {
        return sp.getInt(key, 0);
    }

    /**
     * 获取文件中的boolean值，没有则返回false
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static boolean getBoolean(String name, String key) {
        return getSharedPreferences(name).getBoolean(key, false);
    }

    /**
     * 获取文件中的boolean值，没有则返回false
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static boolean getBoolean(SharedPreferences sp, String key) {
        return sp.getBoolean(key, false);
    }

    /**
     * 获取文件中的String值，没有则返回""
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static String getString(String name, String key) {
        return getSharedPreferences(name).getString(key, "");
    }

    /**
     * 获取文件中的String值，没有则返回""
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static String getString(SharedPreferences sp, String key) {
        return sp.getString(key, "");
    }

    /**
     * 获取文件中的float值，没有则返回0
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static float getFloat(String name, String key) {
        return getSharedPreferences(name).getFloat(key, 0);
    }

    /**
     * 获取文件中的float值，没有则返回0
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static float getFloat(SharedPreferences sp, String key) {
        return sp.getFloat(key, 0);
    }

    /**
     * 获取文件中的long值，没有则返回0
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static long getLong(String name, String key) {
        return getSharedPreferences(name).getLong(key, 0);
    }

    /**
     * 获取文件中的long值，没有则返回0
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static long getLong(SharedPreferences sp, String key) {
        return sp.getLong(key, 0);
    }

    /**
     * 清空SharedPreferences文件
     *
     * @param name SharedPreferences文件名
     * @return
     */
    public static void clear(String name) {
        getSharedPreferences(name).edit().clear().apply();
    }

    /**
     * 清空SharedPreferences文件
     *
     * @param sp SharedPreferences对象
     * @return
     */
    public static void clear(SharedPreferences sp) {
        sp.edit().clear().apply();
    }

    /**
     * 移除SharedPreferences文件中的某个键值对
     *
     * @param name SharedPreferences文件名
     * @param key  存储key
     * @return
     */
    public static void remove(String name, String key) {
        getSharedPreferences(name).edit().remove(key).apply();
    }

    /**
     * 移除SharedPreferences文件中的某个键值对
     *
     * @param sp  SharedPreferences对象
     * @param key 存储key
     * @return
     */
    public static void remove(SharedPreferences sp, String key) {
        sp.edit().remove(key).apply();
    }

    /**
     * 向SharedPreferences文件存入int值
     *
     * @param name  SharedPreferences文件名
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putInt(String name, String key, int value) {
        getSharedPreferences(name).edit().putInt(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入int值
     *
     * @param sp    SharedPreferences对象
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putInt(SharedPreferences sp, String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入String值
     *
     * @param name  SharedPreferences文件名
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putString(String name, String key, String value) {
        getSharedPreferences(name).edit().putString(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入String值
     *
     * @param sp    SharedPreferences对象
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putString(SharedPreferences sp, String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入boolean值
     *
     * @param name  SharedPreferences文件名
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putBoolean(String name, String key, boolean value) {
        getSharedPreferences(name).edit().putBoolean(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入boolean值
     *
     * @param sp    SharedPreferences对象
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putBoolean(SharedPreferences sp, String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入float值
     *
     * @param name  SharedPreferences文件名
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putFloat(String name, String key, float value) {
        getSharedPreferences(name).edit().putFloat(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入float值
     *
     * @param sp    SharedPreferences对象
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putFloat(SharedPreferences sp, String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入long值
     *
     * @param name  SharedPreferences文件名
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putLong(String name, String key, long value) {
        getSharedPreferences(name).edit().putLong(key, value).apply();
    }

    /**
     * 向SharedPreferences文件存入long值
     *
     * @param sp    SharedPreferences对象
     * @param key   存储键
     * @param value 存储值
     * @return
     */
    public static void putLong(SharedPreferences sp, String key, long value) {
        sp.edit().putLong(key, value).apply();
    }

    /**
     * 将已有sp文件的内容copy到新sp文件中
     *
     * @param sp      已有sp文件
     * @param newName 新sp文件名
     * @return 返回一个新的sp文件对象
     */
    public static SharedPreferences getSharedPreferences(SharedPreferences sp, String newName) {
        Map<String, ?> all = sp.getAll();
        SharedPreferences newSp = getSharedPreferences(newName);
        for (String key : all.keySet()) {
            Object value = all.get(key);
            if (value instanceof Integer) {
                putInt(newSp, key, (int) value);
            } else if (value instanceof Boolean) {
                putBoolean(newSp, key, (boolean) value);
            } else if (value instanceof String) {
                putString(newSp, key, (String) value);
            } else if (value instanceof Float) {
                putFloat(newSp, key, (float) value);
            } else {
                putLong(newSp, key, (long) value);
            }
        }
        return newSp;
    }
}
