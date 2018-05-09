package com.prannmya.sagar.utils;

import android.util.Log;


public final class LogUtils {

    private LogUtils() {
    }

    /**
     * /**
     *
     * @param message
     */
    public static void error(String message) {
        if (null != message) {
            Log.e(Constant.TAG, message);
        }

    }


    public static void errorException(final Exception excetion) {
        Log.e(Constant.TAG, "Exception", excetion);
    }


    /**
     * @param message
     */
    public static void debug(String message) {
        if (null != message) {
            Log.d(Constant.TAG, message);
        }
    }


}
