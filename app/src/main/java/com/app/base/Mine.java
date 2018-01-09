package com.app.base;

import android.app.Application;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.app.base.common.util.BaseConstant;
import com.app.base.common.util.SharedPreferencesUtil;

/**
 * 自定义Application类
 *
 * @author Haojie.Dai
 */
public class Mine extends Application implements BaseConstant {

    private static Mine instance;
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        requestQueue = Volley.newRequestQueue(this);

    }

    public static Mine getApplication() {
        return instance;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

}
