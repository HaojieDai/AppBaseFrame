package com.app.base.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.app.base.R;
import com.app.base.common.util.BaseConstant;
import com.app.base.common.view.AnimLoadingView;
import com.app.base.common.view.popupwindow.TipPopup;
import com.app.base.common.view.combination.TitleBar;

import java.util.Date;

/**
 * Activity基类
 *
 * @author Haojie.Dai
 */
public class BaseActivity extends AppCompatActivity implements BaseConstant {

    /**
     * 取activity创建时间为hashCode，作为类的唯一标识
     */
    private int hashCode;
    /**
     * 提示弹窗
     */
    private TipPopup tipPopup;

    protected TitleBar mTitleBar;
    protected AnimLoadingView mLoadingLayout;
    protected FrameLayout mContentLayout;
    protected LinearLayout mErrorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hashCode = new Date().hashCode();
        super.setContentView(R.layout.activity_base);
        mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        mLoadingLayout = (AnimLoadingView) findViewById(R.id.loading_layout);
        mContentLayout = (FrameLayout) findViewById(R.id.content_layout);
        mErrorLayout = (LinearLayout) findViewById(R.id.error_layout);
    }


    /**
     * 提示弹窗
     *
     * @param type {@link TipPopup.TYPE}
     * @param tip
     */
    public void showTipPop(TipPopup.TYPE type, String tip) {
        if (tipPopup == null) {
            tipPopup = new TipPopup(this);
        }

        tipPopup.show(type, tip);
    }

    public int getHashCode() {
        return hashCode;
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(getBaseContext()).inflate(layoutResID, mContentLayout, true);
    }

    @Override
    public void setContentView(View view) {
        mContentLayout.addView(view);
    }
}
