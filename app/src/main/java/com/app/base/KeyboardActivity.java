package com.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.app.base.common.BaseActivity;

import cn.dreamtobe.kpswitch.util.KPSwitchConflictUtil;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import cn.dreamtobe.kpswitch.widget.KPSwitchPanelFrameLayout;

public class KeyboardActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    KPSwitchPanelFrameLayout mPanelRoot;
    ImageView mSwitch;
    EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        mTitleBar.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.GONE);
        mContentLayout.setVisibility(View.VISIBLE);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mPanelRoot = (KPSwitchPanelFrameLayout) findViewById(R.id.panel_root);
        mSwitch = (ImageView) findViewById(R.id.panel_switch);
        mEditText = (EditText) findViewById(R.id.editText);

        mPanelRoot.setIgnoreRecommendHeight(true);
        KeyboardUtil.attach(this, mPanelRoot, (isShowing) -> {
        });
        KPSwitchConflictUtil.attach(mPanelRoot, mSwitch, mEditText, (switchToPanel) -> {
            if (switchToPanel) {
                mEditText.clearFocus();
            } else {
                mEditText.requestFocus();
            }
        });

        mRecyclerView.setOnTouchListener(
                (v, event) -> {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        KPSwitchConflictUtil.hidePanelAndKeyboard(mPanelRoot);
                    }
                    return false;
                });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP &&
                event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mPanelRoot.getVisibility() != View.GONE) {
                KPSwitchConflictUtil.hidePanelAndKeyboard(mPanelRoot);
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

}
