package com.app.base.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.base.R;

/**
 * 页面标题
 *
 * @author Haojie.Dai
 */
public class TitleBar extends FrameLayout {

    private FrameLayout mParentLayout;
    private ImageView mLeftImageView;
    private TextView mLeftTextView;
    private TextView mMiddleTextView;
    private ImageView mRightImageView;
    private TextView mRightTextView;
    private View mDivider;

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_title_bar, this, true);
        mParentLayout = findViewById(R.id.parent_layout);
        mLeftImageView = findViewById(R.id.left_image_view);
        mLeftTextView = findViewById(R.id.left_text_view);
        mMiddleTextView = findViewById(R.id.middle_text_view);
        mRightImageView = findViewById(R.id.right_image_view);
        mRightTextView = findViewById(R.id.right_text_view);
        mDivider = findViewById(R.id.divider);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBar);

        final Drawable leftDrawable = array.getDrawable(R.styleable.TitleBar_left_src);
        if (leftDrawable != null) {
            mLeftImageView.setImageDrawable(leftDrawable);
        }

        final int leftTextColor = array.getColor(R.styleable.TitleBar_left_color, 0);
        if (leftTextColor != 0) {
            mLeftTextView.setTextColor(leftTextColor);
        }

        final int leftTextSize = array.getDimensionPixelOffset(R.styleable.TitleBar_left_size, 0);
        if (leftTextSize != 0) {
            mLeftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
        }

        final String leftText = array.getString(R.styleable.TitleBar_left_text);
        mLeftTextView.setText(leftText);

        final int middleTextColor = array.getColor(R.styleable.TitleBar_middle_color, 0);
        if (middleTextColor != 0) {
            mMiddleTextView.setTextColor(middleTextColor);
        }

        final int middleTextSize = array.getDimensionPixelOffset(R.styleable.TitleBar_middle_size, 0);
        if (middleTextSize != 0) {
            mMiddleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, middleTextSize);
        }

        final String middleText = array.getString(R.styleable.TitleBar_middle_text);
        mMiddleTextView.setText(middleText);

        final Drawable rightDrawable = array.getDrawable(R.styleable.TitleBar_right_src);
        if (rightDrawable != null) {
            mRightImageView.setImageDrawable(rightDrawable);
        }

        final int rightTextColor = array.getColor(R.styleable.TitleBar_right_color, 0);
        if (rightTextColor != 0) {
            mRightTextView.setTextColor(rightTextColor);
        }

        final int rightTextSize = array.getDimensionPixelOffset(R.styleable.TitleBar_right_size, 0);
        if (rightTextSize != 0) {
            mRightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
        }

        final String rightText = array.getString(R.styleable.TitleBar_right_text);
        mRightTextView.setText(rightText);

        final boolean leftShowImage = array.getBoolean(R.styleable.TitleBar_left_show_image, true);
        if (leftShowImage) {
            mLeftTextView.setVisibility(GONE);
        } else {
            mLeftImageView.setVisibility(GONE);
        }

        final boolean rightShowImage = array.getBoolean(R.styleable.TitleBar_right_show_image, true);
        if (rightShowImage) {
            mRightTextView.setVisibility(GONE);
        } else {
            mRightImageView.setVisibility(GONE);
        }

        final boolean showDivider = array.getBoolean(R.styleable.TitleBar_show_divider, true);
        if (!showDivider) {
            mDivider.setVisibility(GONE);
        }

        array.recycle();
    }

    public void setLeftImageResource(int resId) {
        mLeftImageView.setImageResource(resId);
    }

    public void setLeftText(String text) {
        mLeftTextView.setText(text);
    }

    public void setRightImageResource(int resId) {
        mRightImageView.setImageResource(resId);
    }

    public void setRightText(String text) {
        mRightTextView.setText(text);
    }

    public void setMiddleText(String text) {
        mMiddleTextView.setText(text);
    }

    public void setLeftImageViewOnClickListener(OnClickListener onClickListener) {
        mLeftImageView.setOnClickListener(onClickListener);
    }

    public void setRightImageViewOnClickListener(OnClickListener onClickListener) {
        mRightImageView.setOnClickListener(onClickListener);
    }

    public void setRightTextViewOnClickListener(OnClickListener onClickListener) {
        mRightTextView.setOnClickListener(onClickListener);
    }

    public ImageView getLeftImageView() {
        return mLeftImageView;
    }

    public TextView getLeftTextView() {
        return mLeftTextView;
    }

    public ImageView getRightImageView() {
        return mRightImageView;
    }

    public TextView getRightTextView() {
        return mRightTextView;
    }

    public TextView getMiddleTextView() {
        return mMiddleTextView;
    }

    /**
     * 获取TitleBar的父容器布局，自定义标题
     *
     * @return
     */
    public FrameLayout getParentLayout() {
        return mParentLayout;
    }
}
