package com.app.base.common.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import com.app.base.Mine;

/**
 * 制造Selector的工厂
 *
 * @author Haojie.Dai
 */
public class SelectorFactory {

    public static StateListDrawable mkPressedSelector(int pressedResId, int unPressedResId) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable pressed = Mine.getApplication().getResources().getDrawable(pressedResId);
        Drawable unPressed = Mine.getApplication().getResources().getDrawable(unPressedResId);
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, unPressed);
        return drawable;
    }

    public static StateListDrawable mkCheckedSelector(int checkedResId, int unCheckedResId) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable checked = Mine.getApplication().getResources().getDrawable(checkedResId);
        Drawable unChecked = Mine.getApplication().getResources().getDrawable(unCheckedResId);
        drawable.addState(new int[]{android.R.attr.state_checked}, checked);
        drawable.addState(new int[]{-android.R.attr.state_checked}, unChecked);
        return drawable;
    }

    public static StateListDrawable mkSelectedSelector(int selectedResId, int unSelectedResId) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable selected = Mine.getApplication().getResources().getDrawable(selectedResId);
        Drawable unSelected = Mine.getApplication().getResources().getDrawable(unSelectedResId);
        drawable.addState(new int[]{android.R.attr.state_selected}, selected);
        drawable.addState(new int[]{-android.R.attr.state_selected}, unSelected);
        return drawable;
    }

    public static StateListDrawable mkEnablededSelector(int enabledResId, int unEnabledResId) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable selected = Mine.getApplication().getResources().getDrawable(enabledResId);
        Drawable unSelected = Mine.getApplication().getResources().getDrawable(unEnabledResId);
        drawable.addState(new int[]{android.R.attr.state_enabled}, selected);
        drawable.addState(new int[]{-android.R.attr.state_enabled}, unSelected);
        return drawable;
    }

    public static ColorStateList mkCheckedColorSelector(int normal, int checked) {
        int[] colors = new int[]{checked, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_checked};
        states[1] = new int[]{-android.R.attr.state_checked};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public static ColorStateList mkSelectedColorSelector(int normal, int selected) {
        int[] colors = new int[]{selected, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_selected};
        states[1] = new int[]{-android.R.attr.state_selected};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public static ColorStateList mkPressedColorSelector(int normal, int pressed) {
        int[] colors = new int[]{pressed, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{-android.R.attr.state_pressed};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public static ColorStateList mkEnabledColorSelector(int normal, int enabled) {
        int[] colors = new int[]{enabled, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_enabled};
        states[1] = new int[]{-android.R.attr.state_enabled};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
}
