package com.wangdh.basetest;

import com.wangdh.basetest.base.BaseApplication;
import com.wangdh.basetest.dao.GreenDaoManager;
import com.wangdh.basetest.utils.TLog;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/8/22 13:15<br>
 * 描述:  <br>
 */
public class AppContext extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        TLog.l("AppContext");
        initGreenDao();
    }

    //
    private void initGreenDao() {
        GreenDaoManager.getInstance();
    }
}
