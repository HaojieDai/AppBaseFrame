package com.app.base.home;

import android.view.LayoutInflater;

import com.app.base.common.BaseFragment;
import com.app.base.R;
import com.app.base.common.view.combination.TitleBar;

public class SmsFragment extends BaseFragment {

    @Override
    protected void initializeView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_sms, null, false);
    }

    @Override
    protected void initializeData() {

    }
}
