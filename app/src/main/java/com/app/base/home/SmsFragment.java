package com.app.base.home;

import android.view.LayoutInflater;

import com.app.base.common.BaseFragment;
import com.app.base.R;
import com.app.base.common.view.combination.AutoRollBanner;

import java.util.ArrayList;
import java.util.List;

public class SmsFragment extends BaseFragment {

    AutoRollBanner mAutoRollBanner;

    @Override
    protected void initializeView(LayoutInflater inflater) {
        mRootView = inflater.inflate(R.layout.fragment_sms, null, false);
        mAutoRollBanner = mRootView.findViewById(R.id.autoRollBanner);
    }

    @Override
    protected void initializeData() {
        List<AutoRollBanner.Banner> banners = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            AutoRollBanner.Banner banner = new AutoRollBanner.Banner();
            banners.add(banner);
            if (i == 0) {
                banner.image = "http://img4.imgtn.bdimg.com/it/u=3445958822,3632531790&fm=27&gp=0.jpg";
            } else if (i == 1) {
                banner.image = "http://img0.imgtn.bdimg.com/it/u=3047045095,1422608247&fm=15&gp=0.jpg";
            } else if (i == 2) {
                banner.image = "http://img3.imgtn.bdimg.com/it/u=1747370694,371566551&fm=27&gp=0.jpg";
            } else {
                banner.image = "http://img0.imgtn.bdimg.com/it/u=1584016429,971211395&fm=15&gp=0.jpg";
            }
        }
        mAutoRollBanner.setBanners(banners);
    }
}
