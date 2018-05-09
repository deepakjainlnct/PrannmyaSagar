package com.prannmya.sagar.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prannmya.sagar.R;
import com.prannmya.sagar.fragment.DashboardFragment;
import com.prannmya.sagar.utils.Constant;
import com.prannmya.sagar.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuguJIActivity extends MainActivity {

    public static Fragment fragment;
    FragmentManager fragmentManager;
    public Fragment selectedFragment;
    public Constant constant;
    public transient String path;
    @BindView(R.id.ll_include)
    public RelativeLayout rlHeader;
    @BindView(R.id.imageViewback)
    public ImageView imageViewback;
    @BindView(R.id.tv_header)
    public TextView headerTxt;


    public GuguJIActivity() {
        // empty constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_guruji);
            ButterKnife.bind(this);
            fragmentManager = getSupportFragmentManager();
            DashboardFragment introFragment = new DashboardFragment();
            if (introFragment != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, introFragment);
                fragmentTransaction.commit();
            }
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }

    public void closeKeyboard(Context context) {
        try {
            InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            View v = ((Activity) context).getCurrentFocus();
            if (v == null) {
                return;
            }
            inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }

    @Override
    public void onBackPressed() {
        try {

        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }

    /**
     * onActivityResult
     */
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

}
