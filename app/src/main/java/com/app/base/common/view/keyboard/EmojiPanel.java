package com.app.base.common.view.keyboard;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.app.base.R;
import com.app.base.common.util.DisplayUtil;

/**
 * 表情面板
 *
 * @author Haojie.Dai
 */
public class EmojiPanel extends LinearLayout {

    ViewPager mViewPager;
    LinearLayout mEmojiIndicator;
    LinearLayout mEmojiTypeSelector;

    public EmojiPanel(Context context) {
        this(context, null);
    }

    public EmojiPanel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        setMinimumHeight(context.getResources().getDimensionPixelOffset(R.dimen.custom_keyboard_min_height));
        LayoutInflater.from(context).inflate(R.layout.panel_emoji, this, true);
        mViewPager = findViewById(R.id.viewPager);
        mEmojiIndicator = findViewById(R.id.emoji_indicator);
        mEmojiTypeSelector = findViewById(R.id.emoji_type_selector);

        LayoutParams P = (LayoutParams) mViewPager.getLayoutParams();
        P.height = 0;
        P.weight = 1;
        mViewPager.setLayoutParams(P);
    }
}
