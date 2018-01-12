package com.app.base.home;

import android.Manifest;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.app.base.common.BaseActivity;
import com.app.base.common.BaseFragment;
import com.app.base.R;
import com.app.base.common.util.DisplayUtil;
import com.app.base.common.util.SelectorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;
import me.weyye.hipermission.PermissionItem;

/**
 * 主页
 *
 * @author Haojie.Dai
 */
public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup mIndicator;
    RadioButton mSmsTab;
    RadioButton mPhoneTab;
    RadioButton mCameraTab;
    RadioButton mMicroTab;

    FragmentManager fragmentManager;
    BaseFragment[] fragments = new BaseFragment[FOUR];

    static int INDEX_SMS = ZERO;
    static int INDEX_PHONE = ONE;
    static int INDEX_CAMERA = TWO;
    static int INDEX_MICRO = THREE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTitleBar.setVisibility(View.GONE);
        mLoadingLayout.setVisibility(View.GONE);
        mContentLayout.setVisibility(View.VISIBLE);
        fragmentManager = getSupportFragmentManager();

        initializeView();
        initializeData();
    }

    private void initializeView() {
        mIndicator = (RadioGroup) findViewById(R.id.indicator);
        mIndicator.setOnCheckedChangeListener(this);
        mSmsTab = (RadioButton) findViewById(R.id.sms);
        mPhoneTab = (RadioButton) findViewById(R.id.phone);
        mCameraTab = (RadioButton) findViewById(R.id.camera);
        mMicroTab = (RadioButton) findViewById(R.id.micro);
    }

    private void initializeData() {
        ColorStateList colorStateList = SelectorFactory.mkCheckedColorSelector(0xff000000, 0xfffb7299);
        mSmsTab.setTextColor(colorStateList);
        mPhoneTab.setTextColor(colorStateList);
        mCameraTab.setTextColor(colorStateList);
        mMicroTab.setTextColor(colorStateList);
        mSmsTab.setCompoundDrawablesWithIntrinsicBounds(null, SelectorFactory.mkCheckedSelector(R.drawable.permission_ic_contacts, R.drawable.permission_ic_sms), null, null);
        mPhoneTab.setCompoundDrawablesWithIntrinsicBounds(null, SelectorFactory.mkCheckedSelector(R.drawable.permission_ic_contacts, R.drawable.permission_ic_phone), null, null);
        mCameraTab.setCompoundDrawablesWithIntrinsicBounds(null, SelectorFactory.mkCheckedSelector(R.drawable.permission_ic_contacts, R.drawable.permission_ic_camera), null, null);
        mMicroTab.setCompoundDrawablesWithIntrinsicBounds(null, SelectorFactory.mkCheckedSelector(R.drawable.permission_ic_contacts, R.drawable.permission_ic_micro_phone), null, null);
//        使用这种方式设置默认选中，监听方法会执行两次，也就是第一的首页fragment会被创建两次。
//        mIndicator.check(R.id.sms);
//        使用这种方式设置默认选中 页面改变监听方法只会执行一次
        mSmsTab.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.sms:
                showFragment(INDEX_SMS);
                break;
            case R.id.phone:
                showFragment(INDEX_PHONE);
                break;
            case R.id.camera:
                showFragment(INDEX_CAMERA);
                break;
            case R.id.micro:
                showFragment(INDEX_MICRO);
                break;
            default:
                throw new RuntimeException(String.format(Locale.getDefault(), "checkedId %d is not exist", checkedId));
        }
    }

    private void showFragment(int index) {
        if (fragments[index] == null) {
            if (index == INDEX_SMS) {
                fragments[index] = new SmsFragment();
            } else if (index == INDEX_PHONE) {
                fragments[index] = new PhoneFragment();
            } else if (index == INDEX_CAMERA) {
                fragments[index] = new CameraFragment();
            } else if (index == INDEX_MICRO) {
                fragments[index] = new MicroFragment();
            } else {
                throw new RuntimeException(String.format(Locale.getDefault(), "index %d is not defined", index));
            }
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        for (int i = 0; i < fragments.length; i++) {
            if (i == index) {
                if (fragments[i].isAdded()) {
                    transaction.show(fragments[i]);
                } else {
                    transaction.add(R.id.container, fragments[i]);
                }
            } else {
                if (fragments[i] != null && fragments[i].isAdded()) {
                    transaction.hide(fragments[i]);
                }
            }
        }

        transaction.commit();
    }

    private void permission() {
        List<PermissionItem> permissions = new ArrayList<>();
        permissions.add(new PermissionItem(Manifest.permission.READ_PHONE_STATE, "设备信息", me.weyye.hipermission.R.drawable.permission_ic_phone));
        permissions.add(new PermissionItem(Manifest.permission.WRITE_EXTERNAL_STORAGE, "存储空间", me.weyye.hipermission.R.drawable.permission_ic_storage));
        permissions.add(new PermissionItem(Manifest.permission.ACCESS_FINE_LOCATION, "位置信息", me.weyye.hipermission.R.drawable.permission_ic_location));
        HiPermission.create(this)
                .title("权限申请说明")
                .msg("使用以下权限是为了保障您的应用安全，不会涉及对隐私的访问，请允许使用！否则将无法正常使用该应用！")
                .filterColor(0xfffb7299)
                .style(R.style.PermissionStyle)
                .permissions(permissions)
                .checkMutiPermission(new PermissionCallback() {

                    @Override
                    public void onClose() {
                        Log.i("dhj", "onClose");
                    }

                    @Override
                    public void onFinish() {
                        Log.i("dhj", "onFinish = " + DisplayUtil.getScreenWidth(ctx));
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                        Log.i("dhj", "onDeny : " + permission);
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {
                        Log.i("dhj", "onGuarantee : " + permission);
                    }
                });
    }
}