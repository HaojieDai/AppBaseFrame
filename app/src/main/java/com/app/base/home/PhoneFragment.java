package com.app.base.home;

import android.view.LayoutInflater;

import com.app.base.BaseFragment;
import com.app.base.R;
import com.app.base.common.view.TitleBar;

public class PhoneFragment extends BaseFragment {

    @Override
    protected void initializeView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.activity_base, null, false);
        TitleBar mTitleBar = mRootView.findViewById(R.id.titleBar);
        mTitleBar.setMiddleText("PHONE");
    }

    @Override
    protected void initializeData() {

    }
}
