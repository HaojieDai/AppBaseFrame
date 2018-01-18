package com.app.base.common.view.combination;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.base.R;
import com.app.base.common.util.DisplayUtil;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 利用{@link RecyclerView}和{@link SnapHelper}实现自动轮播banner
 *
 * @author Haojie.Dai
 */
public class AutoRollBanner extends FrameLayout {

    /**
     * 轮播banner的数据对象
     *
     * @author Haojie.Dai
     */
    public static class Banner {
        public int id;
        public int type;
        public String image;
    }

    final int MESSAGE = 0;
    final int DELAYED = 3000;

    LinearLayoutManager mLinearLayoutManager;
    RecyclerView mRecyclerView;
    LinearLayout mDots;
    List<Banner> banners;
    BannerAdapter mBannerAdapter;
    int current;

    Drawable dot_src_normal;
    Drawable dot_src_select;
    int marginBetweenDots;
    int dotsBottomMargin;
    int dotSize;
    int DP10;

    public AutoRollBanner(@NonNull Context context) {
        this(context, null);
    }

    public AutoRollBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        DP10 = DisplayUtil.dp2px(getContext(), 10);
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.AutoRollBanner);
        dot_src_normal = array.getDrawable(R.styleable.AutoRollBanner_normalDotSrc);
        dot_src_select = array.getDrawable(R.styleable.AutoRollBanner_selectDotSrc);
        marginBetweenDots = array.getDimensionPixelOffset(R.styleable.AutoRollBanner_marginBetweenDots, DP10);
        dotsBottomMargin = array.getDimensionPixelOffset(R.styleable.AutoRollBanner_dotsBottomMargin, DP10);
        dotSize = array.getDimensionPixelOffset(R.styleable.AutoRollBanner_dotSize, DP10);
        array.recycle();

        LayoutInflater.from(context).inflate(R.layout.view_auto_roll_banner, this, true);
        mRecyclerView = findViewById(R.id.recyclerView);
        mDots = findViewById(R.id.dots);
        mLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        new PagerSnapHelper().attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        mHandler.removeMessages(MESSAGE);
                        current = mLinearLayoutManager.findFirstVisibleItemPosition();

                        for (int i = 0; i < mDots.getChildCount(); i++) {
                            ImageView dot = (ImageView) mDots.getChildAt(i);
                            if (i == current % banners.size()) {
                                dot.setImageDrawable(dot_src_select);
                            } else {
                                dot.setImageDrawable(dot_src_normal);
                            }
                        }

                        mHandler.sendEmptyMessageDelayed(MESSAGE, DELAYED);
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        mHandler.removeMessages(MESSAGE);
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }
        });

        LayoutParams lp = (LayoutParams) mDots.getLayoutParams();
        lp.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        lp.bottomMargin = dotsBottomMargin;
        mDots.setLayoutParams(lp);
    }

    Handler mHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(Message msg) {
            if (banners.size() == 0) return;
            current++;
            mRecyclerView.smoothScrollToPosition(current);
            mHandler.sendEmptyMessageDelayed(MESSAGE, DELAYED);
        }
    };

    public void setBanners(List<Banner> banners) {
        if (banners == null || banners.isEmpty()) {
            return;
        }
        mHandler.removeMessages(MESSAGE);
        this.banners = banners;
        mBannerAdapter = new BannerAdapter();
        mRecyclerView.setAdapter(mBannerAdapter);
        initDots();
        current = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % banners.size();
        mRecyclerView.scrollToPosition(current);
        mHandler.sendEmptyMessageDelayed(MESSAGE, DELAYED);
    }

    public void notifyDataSetChanged() {
        if (mBannerAdapter != null) {
            mHandler.removeMessages(MESSAGE);
            mBannerAdapter.notifyDataSetChanged();
            initDots();
            current = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % banners.size();
            mRecyclerView.scrollToPosition(current);
            mHandler.sendEmptyMessageDelayed(MESSAGE, DELAYED);
        }
    }

    private void initDots() {
        mDots.removeAllViews();
        for (int i = 0; i < banners.size(); i++) {
            ImageView dot = new ImageView(getContext());
            mDots.addView(dot);
            LinearLayout.LayoutParams llp = (LinearLayout.LayoutParams) dot.getLayoutParams();
            llp.width = llp.height = dotSize;
            if (i == 0) {
                dot.setImageDrawable(dot_src_select);
            } else {
                dot.setImageDrawable(dot_src_normal);
                llp.leftMargin = marginBetweenDots;
            }
            dot.setLayoutParams(llp);
        }
    }

    class BannerAdapter extends RecyclerView.Adapter<BannerViewHolder> {

        @Override
        public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ImageView itemView = new ImageView(getContext());
            itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return new BannerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(BannerViewHolder holder, int position) {
            final int p = position % banners.size();
            Banner banner = banners.get(p);
            ImageView itemView = (ImageView) holder.itemView;
            Glide.with(getContext()).load(banner.image).into(itemView);
            itemView.setOnClickListener((v) -> {
                Toast.makeText(getContext(), "position = " + p, Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return Integer.MAX_VALUE;
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        public BannerViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.removeMessages(MESSAGE);
    }
}
