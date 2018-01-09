package com.app.base.common.util;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * OkHttp工具
 *
 * @author Haojie.Dai
 */
public class OkHttpUtil {

    private static OkHttpClient mOkHttpClient = new OkHttpClient();
    private static Handler mMainHandler = new Handler(Looper.getMainLooper());

    public static void get(String url, final OnOkHttpResult onOkHttpResult) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                mMainHandler.post(() -> {
                    if (onOkHttpResult != null) {
                        onOkHttpResult.onFailure();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mMainHandler.post(() -> {
                    if (onOkHttpResult != null) {
                        onOkHttpResult.onSuccess(response);
                    }
                });
            }
        });
    }

    public static void post(String url, RequestBody requestBody, final OnOkHttpResult onOkHttpResult) {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                mMainHandler.post(() -> {
                    if (onOkHttpResult != null) {
                        onOkHttpResult.onFailure();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mMainHandler.post(() -> {
                    if (onOkHttpResult != null) {
                        onOkHttpResult.onSuccess(response);
                    }
                });
            }
        });
    }


    public static RequestBody getFormBody(String path, String param) {
        // TODO 获取签名等操作
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("signature", "signature");
        return builder.build();
    }

    public interface OnOkHttpResult {

        void onSuccess(Response response);

        void onFailure();
    }

}
