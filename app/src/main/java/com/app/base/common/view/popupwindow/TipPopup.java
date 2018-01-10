package com.app.base.common.view.popupwindow;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.app.base.R;
import com.app.base.common.util.BaseConstant;
import com.app.base.common.util.DisplayUtil;

/**
 * 提示弹窗
 *
 * @author Haojie.Dai
 */
public class TipPopup extends PopupWindow implements BaseConstant {

    /**
     * 提示弹窗显示时长 - ms
     */
    static final int TIP_DELAYED = 1500;

    /**
     * 提示图标尺寸 - dp
     */
    static final int TIP_ICON_SIZE = 32;

    /**
     * 提示文本字体大小 - sp
     */
    static final int TIP_TEXT_SIZE = 14;

    /**
     * 图标与文本的上下间距 - dp
     */
    static final int DIS_ICON_TO_TEXT = 12;

    private Context mCtx;
    private View mParent;
    private LinearLayout mWrapper;
    private ImageView mTipIcon;
    private TextView mTipText;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    public TipPopup(Activity activity) {
        mParent = activity.getWindow().getDecorView();
        mCtx = activity.getBaseContext();
        init();
    }

    public TipPopup(Fragment fragment) {
        mParent = fragment.getActivity().getWindow().getDecorView();
        mCtx = fragment.getContext();
        init();
    }

    private void init() {
        View root = LayoutInflater.from(mCtx).inflate(R.layout.popup_tip, null, false);
        setContentView(root);
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        setAnimationStyle(R.style.popup_scale_fade);
        mWrapper = root.findViewById(R.id.contentWrap);

        mTipIcon = new ImageView(mCtx);
        mTipIcon.setLayoutParams(new LinearLayout.LayoutParams(
                DisplayUtil.dp2px(TIP_ICON_SIZE), DisplayUtil.dp2px(TIP_ICON_SIZE)));
        mTipText = new TextView(mCtx);
        LinearLayout.LayoutParams tvp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvp.topMargin = DisplayUtil.dp2px(DIS_ICON_TO_TEXT);
        mTipText.setLayoutParams(tvp);
        mTipText.setGravity(Gravity.CENTER);
        mTipText.setMaxLines(ONE);
        mTipText.setEllipsize(TextUtils.TruncateAt.END);
        mTipText.setTextColor(Color.WHITE);
        mTipText.setTextSize(TypedValue.COMPLEX_UNIT_SP, TIP_TEXT_SIZE);

        mWrapper.addView(mTipIcon);
        mWrapper.addView(mTipText);
    }

    public void show(TYPE type, String tip) {
        if (type == TYPE.SUCCESS) {
            mTipIcon.setImageResource(R.drawable.tip_icon_success);
        } else if (type == TYPE.FAIL) {
            mTipIcon.setImageResource(R.drawable.tip_icon_fail);
        } else {
            mTipIcon.setImageResource(R.drawable.tip_icon_info);
        }
        mTipText.setText(tip);
        showAtLocation(mParent, Gravity.CENTER, ZERO, ZERO);
        mMainHandler.removeCallbacksAndMessages(null);
        mMainHandler.postDelayed(() -> dismiss(), TIP_DELAYED);
    }

    public enum TYPE {
        SUCCESS, FAIL, INFO
    }

}
