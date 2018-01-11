package com.app.base.common.view.combination;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.base.R;
import com.app.base.common.util.DisplayUtil;
import com.app.base.common.util.SelectorFactory;

/**
 * 通用ItemView
 *
 * @author Haojie.Dai
 */
public class CommonItem extends RelativeLayout {

    /**
     * 右侧不显示任何东西
     */
    public final static int ACCESSORY_TYPE_NONE = 0;
    /**
     * 右侧显示一个箭头
     */
    public final static int ACCESSORY_TYPE_ARROW = 1;
    /**
     * 右侧显示一个开关
     */
    public final static int ACCESSORY_TYPE_SWITCH = 2;
    /**
     * 自定义右侧显示的 View
     */
    public final static int ACCESSORY_TYPE_CUSTOM = 3;

    /**
     * detail 在 title 文字的下方
     */
    public final static int VERTICAL = 1;
    /**
     * detail 在 item 的右方
     */
    public final static int HORIZONTAL = 0;

    ImageView mItemIcon;
    LinearLayout mTitleContainer;
    TextView mTitleTextView;
    TextView mDetailTextView;
    FrameLayout mItemCustomized;

    ImageView mArrow;
    CheckBox mSwitch;

    private int mAccessoryType;

    public CommonItem(Context context) {
        this(context, null);
    }

    public CommonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_common_item, this, true);
        mItemIcon = findViewById(R.id.common_item_icon);
        mTitleContainer = findViewById(R.id.common_item_title_container);
        mTitleTextView = findViewById(R.id.common_item_title);
        mDetailTextView = findViewById(R.id.common_item_detail);
        mItemCustomized = findViewById(R.id.common_item_customized);

        RelativeLayout.LayoutParams iconLp = (LayoutParams) mItemIcon.getLayoutParams();
        iconLp.addRule(RelativeLayout.CENTER_VERTICAL);
        iconLp.rightMargin = DisplayUtil.dp2px(10);
        mItemIcon.setLayoutParams(iconLp);

        RelativeLayout.LayoutParams containerLp = (LayoutParams) mTitleContainer.getLayoutParams();
        containerLp.addRule(RelativeLayout.CENTER_VERTICAL);
        containerLp.addRule(RelativeLayout.RIGHT_OF, R.id.common_item_icon);
        mTitleContainer.setLayoutParams(containerLp);

        RelativeLayout.LayoutParams customizedLp = (LayoutParams) mItemCustomized.getLayoutParams();
        customizedLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        customizedLp.addRule(RelativeLayout.CENTER_VERTICAL);
        mItemCustomized.setLayoutParams(customizedLp);

        setAccessoryType(ACCESSORY_TYPE_SWITCH);
    }

    public void setAccessoryType(int type) {
        if (type == mAccessoryType){
            return;
        }
        mItemCustomized.removeAllViews();
        mAccessoryType = type;
        switch (type) {
            case ACCESSORY_TYPE_ARROW:
                if (mArrow == null) {
                    mArrow = new ImageView(getContext());
                    mArrow.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
                    mArrow.setScaleType(ImageView.ScaleType.CENTER);
                    mArrow.setImageResource(R.drawable.arrow_right_gray);
                }
                mItemCustomized.addView(mArrow);
                mItemCustomized.setVisibility(VISIBLE);
                break;
            case ACCESSORY_TYPE_SWITCH:
                if (mSwitch == null) {
                    mSwitch = new CheckBox(getContext());
                    mSwitch.setButtonDrawable(SelectorFactory.mkCheckedSelector(R.drawable.switch_open, R.drawable.switch_close));
                    mSwitch.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
                    mSwitch.setClickable(false);
                    mSwitch.setFocusable(false);
                }
                mItemCustomized.addView(mSwitch);
                mItemCustomized.setVisibility(VISIBLE);
                break;
            case ACCESSORY_TYPE_CUSTOM:
                mItemCustomized.setVisibility(VISIBLE);
                break;
            case ACCESSORY_TYPE_NONE:
                mItemCustomized.setVisibility(GONE);
                break;
        }
    }

    public void setOrientation(int orientation){
        if (orientation == mTitleContainer.getOrientation()){
            return;
        }
        mTitleContainer.setOrientation(orientation);
        if (orientation==HORIZONTAL){
            mTitleContainer.setGravity(Gravity.CENTER);
        }else{
            mTitleContainer.setGravity(Gravity.LEFT);
        }
    }

    public FrameLayout getItemCustomized(){
        return  mItemCustomized;
    }

    public ImageView getItemIcon(){
        return  mItemIcon;
    }

    public TextView getItemTitle(){
        return  mTitleTextView;
    }

    public TextView getItemDetail(){
        return mDetailTextView;
    }

    public LinearLayout getTitleContainer(){
        return mTitleContainer;
    }

}
