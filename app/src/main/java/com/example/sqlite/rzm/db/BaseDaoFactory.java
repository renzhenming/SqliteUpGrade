package com.example.sqlite.rzm.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class BaseDaoFactory {
    private String sqliteDatabasePath;

    private SQLiteDatabase sqLiteDatabase;
    //-------------添加-------------
    private SQLiteDatabase userDatabase;
    private Map<String, BaseDao> map = Collections.synchronizedMap(new HashMap<String, BaseDao>());

    private static BaseDaoFactory instance = new BaseDaoFactory();

    private BaseDaoFactory() {
        File file = new File(Environment.getExternalStorageDirectory(), "update");
        if (!file.exists()) {
            file.mkdirs();
        }
        sqliteDatabasePath = file.getAbsolutePath() + "/user.db";
        openDatabase();
    }

    public synchronized <T extends BaseDao<M>, M> T
    getDataHelper(Class<T> clazz, Class<M> entityClass) {
        BaseDao baseDao = null;
        if (map.get(clazz.getSimpleName()) != null) {
            return (T) map.get(clazz.getSimpleName());
        }
        try {
            baseDao = clazz.newInstance();
            baseDao.init(entityClass, sqLiteDatabase);
            map.put(clazz.getSimpleName(), baseDao);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T) baseDao;
    }

    public synchronized <T extends BaseDao<M>, M> T
    getUserHelper(Class<T> clazz, Class<M> entityClass) {
        userDatabase = SQLiteDatabase.openOrCreateDatabase(PrivateDataBaseEnums.database.getValue(), null);
        BaseDao baseDao = null;
        try {
            baseDao = clazz.newInstance();
            baseDao.init(entityClass, userDatabase);
            map.put(clazz.getSimpleName(), baseDao);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) baseDao;
    }

    private void openDatabase() {
        try {
            this.sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(sqliteDatabasePath, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static BaseDaoFactory getInstance() {
        return instance;
    }

}
