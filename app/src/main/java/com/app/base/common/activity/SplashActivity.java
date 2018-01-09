package com.app.base.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.base.BaseActivity;

/**
 * 启动页
 *
 * @author Haojie.Dai
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitleBar.setLeftImageViewOnClickListener((v) -> {
            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, GuideActivity.class);
            startActivity(intent);
            onBackPressed();
        });
    }
}
