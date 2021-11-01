package com.lenovo.feizai.networkframe.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @Author feizai
 * @Date 2021年10月30日 0030  下午 11:19:55
 * @Explain
 */
public class ToastUtil {
    private static Context mContext;

    private ToastUtil() {
    }

    public static ToastUtil getInstance(Context context) {
        if (context != null) {
            mContext = context;
        } else {
            throw new NullPointerException("context is null");
        }
        return ToastUtilHolder.sInstance;
    }

    private static class ToastUtilHolder {
        private final static ToastUtil sInstance = new ToastUtil();
    }

    public void showToast(CharSequence content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }

    public void showToast(CharSequence content, Integer duration) {
        Toast.makeText(mContext, content, duration).show();
    }

}
