package com.wangdh.basetest.dao;

import android.database.sqlite.SQLiteDatabase;

import com.wangdh.basetest.AppContext;
import com.wangdh.basetest.base.BaseApplication;
import com.wangdh.basetest.utils.TLog;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/9/28 17:59<br>
 * 描述: 管理greendao的一个类 <br>
 */
public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private SQLiteDatabase writableDatabase;

    private static final String dburl = "notes-db";
    public static final String dbFileName = AppContext.getContext().getPackageName();
    private static final boolean issd = true;

    /**
     * 初始化调用
     */
    public GreenDaoManager() {
        if (BaseApplication.getContext() == null) {
            TLog.l("上下文为null");
        } else {
            TLog.l("上下文不为null");
        }
        if (issd) {
            DaoMasterSD.DevOpenHelper devOpenHelper = new DaoMasterSD.DevOpenHelper(BaseApplication.getContext(), dburl, null);
            writableDatabase = devOpenHelper.getWritableDatabase();
        }else{
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getContext(), dburl, null);
            writableDatabase = devOpenHelper.getWritableDatabase();
        }
        DaoMaster mDaoMaster = new DaoMaster(writableDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    public static SQLiteDatabase getSqlLite() {
        if (mInstance == null) {
            mInstance = new GreenDaoManager();
        }
        if (mInstance.writableDatabase == null) {
            mInstance = new GreenDaoManager();
        }
        return mInstance.writableDatabase;
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            mInstance = new GreenDaoManager();
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

    //**********************************************************************************************
    //QueryBuilder、Query
    //        基本查询
    //使用QueryBuilder自定义查询实体


}
