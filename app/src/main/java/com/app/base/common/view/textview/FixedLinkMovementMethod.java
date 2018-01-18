package com.app.base.common.view.textview;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 配合 {@link LinkTouchDecorHelper} 使用
 *
 * @author cginechen
 * @date 2017-03-20
 */
public class FixedLinkMovementMethod extends LinkMovementMethod {

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        return sHelper.onTouchEvent(widget, buffer, event)
                || Touch.onTouchEvent(widget, buffer, event);
    }

    public static MovementMethod getInstance() {
        if (sInstance == null)
            sInstance = new FixedLinkMovementMethod();

        return sInstance;
    }

    private static FixedLinkMovementMethod sInstance;
    private static LinkTouchDecorHelper sHelper = new LinkTouchDecorHelper();

}
