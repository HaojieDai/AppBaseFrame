package com.app.base;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.app.base.common.util.BaseConstant;

/**
 * 自定义Application类
 *
 * @author Haojie.Dai
 */
public class BaseApplication extends Application implements BaseConstant {

    private static BaseApplication instance;
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        requestQueue = Volley.newRequestQueue(this);

    }

    public static BaseApplication getApplication() {
        return instance;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

}
