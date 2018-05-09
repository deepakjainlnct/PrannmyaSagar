package com.prannmya.sagar.activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.prannmya.sagar.utils.Constant;
import com.prannmya.sagar.utils.LogUtils;
import com.prannmya.sagar.utils.Numbers;

/**
 * Created by Deepak on 08-05-2018.
 */

public class MainActivity  extends AppCompatActivity{
    public static transient Activity context;
    public static String appVersion;
    public static transient Boolean exit = false;

    public MainActivity() {
        // empty constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = this;
            final PackageManager packg = getPackageManager();
            final PackageInfo packageInfo = packg.getPackageInfo(this.getPackageName(), 0);
            appVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.errorException(e);
        }
    }



    public static void onBack(Activity context) {
        try {
            if (exit) {
                exitHandler();
            } else {
                Toast.makeText(context, Constant.BACK_CLICK, Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 2 * Numbers.ONE_THOUSAND);
            }
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }

    public static void exitHandler() {
        try {
            context.finish();
        } catch (Exception e) {
            LogUtils.errorException(e);
        }
    }
}
