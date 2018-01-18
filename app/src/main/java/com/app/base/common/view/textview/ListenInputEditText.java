package com.app.base.common.view.textview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.app.base.R;
import com.app.base.common.view.span.AlignMiddleImageSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 监听输入内容的EditText
 *
 * @author Haojie.Dai
 */
public class ListenInputEditText extends EditText {

    public ListenInputEditText(Context context) {
        this(context, null);
    }

    public ListenInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern pattern = Pattern.compile("\\[image]");
                Matcher matcher = pattern.matcher(s);
                Drawable dot = getResources().getDrawable(R.drawable.dot_red);
                dot.setBounds(0, 0, dot.getIntrinsicWidth(), dot.getIntrinsicHeight());
                int start = 0;
                while (matcher.find(start)) {
                    AlignMiddleImageSpan span = new AlignMiddleImageSpan(dot, AlignMiddleImageSpan.ALIGN_MIDDLE);
                    s.setSpan(span, matcher.start(), matcher.start() + matcher.group().length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    start = matcher.start() + matcher.group().length();
                    if (getSelectionStart() >= matcher.start() && getSelectionStart() < start) {
                        setSelection(start);
                    }
                }
            }
        });
    }
}
