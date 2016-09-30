package com.wangdh.basetest.dao.imp;

import com.wangdh.basetest.dao.GreenDaoManager;
import com.wangdh.basetest.dao.UserDao;
import com.wangdh.basetest.entity.User;

import java.util.List;

/**
 * 作者: wdh <br>
 * 内容摘要: <br>
 * 创建时间:  2016/9/29 15:33<br>
 * 描述:  <br>
 */
public class UserDaoImpl extends BaseDaoImpl {

    public static User updateUser(String prevName, String newName) {
        User findUser = getSession().getUserDao().queryBuilder()
                .where(UserDao.Properties.Name.eq(prevName)).build().unique();
        return findUser;
    }
    public static void delete(){
        getSession().getUserDao().deleteInTx();
    }
    public static List<User> getAll() {
        List<User> list = getSession().getUserDao().queryBuilder().list();
        return list;
    }
    public static void sql(){
        String tablename = getSession().getUserDao().getTablename();
        GreenDaoManager.getSqlLite().execSQL("delete from "+tablename);
    }

    //*************************
    /*
    void    attachEntity(T entity)：

    long    count()：获取数据库中数据的数量

    // 数据删除相关

    void    delete(T entity)：从数据库中删除给定的实体
    void    deleteAll() ：删除数据库中全部数据
    void    deleteByKey(K key)：从数据库中删除给定Key所对应的实体
    void    deleteByKeyInTx(java.lang.Iterable<K> keys)：使用事务操作删除数据库中给定的所有key所对应的实体
    void    deleteByKeyInTx(K... keys)：使用事务操作删除数据库中给定的所有key所对应的实体
    void    deleteInTx(java.lang.Iterable<T> entities)：使用事务操作删除数据库中给定实体集合中的实体
    void    deleteInTx(T... entities)：使用事务操作删除数据库中给定的实体

    // 数据插入相关
    long    insert(T entity)：将给定的实体插入数据库
    void    insertInTx(java.lang.Iterable<T> entities)：使用事务操作，将给定的实体集合插入数据库
    void    insertInTx(java.lang.Iterable<T> entities, boolean setPrimaryKey)：使用事务操作，将给定的实体集合插入数据库，
    并设置是否设定主键
    void    insertInTx(T... entities)：将给定的实体插入数据库
    long    insertOrReplace(T entity)：将给定的实体插入数据库，若此实体类存在，则覆盖
    void    insertOrReplaceInTx(java.lang.Iterable<T> entities)：使用事务操作，将给定的实体插入数据库，若此实体类存在，则覆盖
    void    insertOrReplaceInTx(java.lang.Iterable<T> entities, boolean setPrimaryKey)：使用事务操作，将给定的实体插入数据库，若此实体类存在，则覆盖
            并设置是否设定主键
    void    insertOrReplaceInTx(T... entities)：使用事务操作，将给定的实体插入数据库，若此实体类存在，则覆盖
    long    insertWithoutSettingPk(T entity)：将给定的实体插入数据库,但不设定主键

    // 新增数据插入相关API
    void    save(T entity)：将给定的实体插入数据库，若此实体类存在，则更新
    void    saveInTx(java.lang.Iterable<T> entities)：将给定的实体插入数据库，若此实体类存在，则更新
    void    saveInTx(T... entities)：使用事务操作，将给定的实体插入数据库，若此实体类存在，则更新

    // 加载相关
    T   load(K key)：加载给定主键的实体
    java.util.List<T>     loadAll()：加载数据库中所有的实体
    protected java.util.List<T>   loadAllAndCloseCursor(android.database.Cursor cursor) ：从cursor中读取、返回实体的列表，并关闭该cursor
    protected java.util.List<T>   loadAllFromCursor(android.database.Cursor cursor)：从cursor中读取、返回实体的列表
    T   loadByRowId(long rowId) ：加载某一行并返回该行的实体
    protected T     loadUnique(android.database.Cursor cursor) ：从cursor中读取、返回唯一实体
    protected T     loadUniqueAndCloseCursor(android.database.Cursor cursor) ：从cursor中读取、返回唯一实体，并关闭该cursor

    //更新数据
    void    update(T entity) ：更新给定的实体
    protected void  updateInsideSynchronized(T entity, DatabaseStatement stmt, boolean lock)
    protected void  updateInsideSynchronized(T entity, android.database.sqlite.SQLiteStatement stmt, boolean lock)
    void    updateInTx(java.lang.Iterable<T> entities) ：使用事务操作，更新给定的实体
    void    updateInTx(T... entities)：使用事务操作，更新给定的实体
    */


}
