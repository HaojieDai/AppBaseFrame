package com.app.base.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

import com.app.base.R;

/**
 * 带自定义动画的加载控件
 *
 * @author Haojie.Dai
 */
public class AnimLoadingView extends AppCompatImageView {

    private int[] drawables;
    private int index;

    public AnimLoadingView(Context context) {
        this(context, null);
    }

    public AnimLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        drawables = new int[]{R.drawable.refresh_1, R.drawable.refresh_2, R.drawable.refresh_3, R.drawable.refresh_4};
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == VISIBLE) {
            start();
        } else {
            stop();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    private void start() {
        setImageResource(drawables[index]);
        mHandler.sendEmptyMessageDelayed(0, 300);
    }

    private void stop() {
        index = 0;
        mHandler.removeMessages(0);
    }

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            index++;
            setImageResource(drawables[index % drawables.length]);
            mHandler.sendEmptyMessageDelayed(0, 300);
        }
    };

}
