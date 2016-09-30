package com.wangdh.basetest.dao.imp;

import com.wangdh.basetest.dao.DaoSession;
import com.wangdh.basetest.dao.GreenDaoManager;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/9/29 15:38<br>
 * 描述:  <br>
 */
public class BaseDaoImpl {

    public static DaoSession getSession() {
        return GreenDaoManager.getInstance().getSession();
    }

    public static void execSQL(String msg){
        GreenDaoManager.getSqlLite().execSQL(msg);
    }
}
