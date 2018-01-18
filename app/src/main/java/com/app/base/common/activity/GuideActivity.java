package com.app.base.common.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.base.R;
import com.app.base.common.BaseActivity;
import com.app.base.common.ZoomOutPageTransformer;
import com.app.base.common.util.DisplayUtil;
import com.app.base.common.util.FullScreenUtil;
import com.app.base.home.HomeActivity;

/**
 * 引导页
 *
 * @author Haojie.Dai
 */
public class GuideActivity extends BaseActivity {

    final int[] resIds = {R.drawable.guide1, R.drawable.guide2, R.drawable.guide3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreenUtil.fullBaseOnAndroid_K(this);
        mTitleBar.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.GONE);
        mContentLayout.setVisibility(View.VISIBLE);
        ViewPager viewPager = new ViewPager(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        viewPager.setLayoutParams(lp);
        setContentView(viewPager);
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(new GuidePagerAdapter());
    }

    class GuidePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return resIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (position == resIds.length - 1) {
                FrameLayout last = new FrameLayout(GuideActivity.this);

                TextView access = new TextView(GuideActivity.this);
                FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
                p.bottomMargin = DisplayUtil.dp2px(ctx, 60);
                access.setLayoutParams(p);
                access.setText("立即体验");
                access.setBackgroundResource(R.drawable.shape_corner_10dp_pink);
                access.setTextColor(Color.WHITE);
                access.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                access.setPadding(DisplayUtil.dp2px(ctx, 20), DisplayUtil.dp2px(ctx, 10), DisplayUtil.dp2px(ctx, 20), DisplayUtil.dp2px(ctx, 10));
                access.setOnClickListener((v) -> {
                    Intent intent = new Intent();
                    intent.setClass(GuideActivity.this, HomeActivity.class);
                    startActivity(intent);
                    onBackPressed();
                });

                ImageView image = new ImageView(GuideActivity.this);
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageResource(resIds[position]);

                last.addView(image);
                last.addView(access);
                container.addView(last);
                return last;
            } else {
                ImageView image = new ImageView(GuideActivity.this);
                image.setScaleType(ImageView.ScaleType.CENTER_CROP);
                image.setImageResource(resIds[position]);
                container.addView(image);
                return image;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
