package com.wangdh.basetest.base;

import android.app.Application;

import com.wangdh.basetest.utils.TLog;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/8/22 13:15<br>
 * 描述:  <br>
 */
public class BaseApplication extends Application {
    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        TLog.l("BaseApplication");
        context = this;
    }

    public static Application getContext() {
        return context;
    }
    public static Application getInstance() {
        return context;
    }
}
