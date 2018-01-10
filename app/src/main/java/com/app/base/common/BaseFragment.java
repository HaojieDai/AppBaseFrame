package com.app.base.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.base.common.util.BaseConstant;
import com.app.base.common.view.popupwindow.TipPopup;

import java.util.Date;

/**
 * Fragment基类
 *
 * @author Haojie.Dai
 */
public abstract class BaseFragment extends Fragment implements BaseConstant {

    /**
     * 取fragment创建时间作为类的唯一标识
     */
    private int hashCode;
    /**
     * 提示弹窗
     */
    private TipPopup tipPopup;
    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hashCode = new Date().hashCode();
        Log.i("dhj", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("dhj", "onCreateView");
        initializeView(inflater);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i("dhj", "onViewCreated");
        initializeData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("dhj", "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("dhj", "onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("dhj", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("dhj", "onDestroy");
    }

    public int getHashCode() {
        return hashCode;
    }

    /**
     * 初始化布局
     *
     * @param inflater
     */
    protected abstract void initializeView(LayoutInflater inflater);

    /**
     * 初始化数据
     */
    protected abstract void initializeData();

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
}
