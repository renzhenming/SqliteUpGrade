package com.example.sqlite.rzm.versionV002;

import com.example.sqlite.rzm.db.BaseDao;

import java.util.List;

/**
 * V002
 */
public class PhotoDao  extends BaseDao<Photo>{

    @Override
    public List<Photo> query(String sql) {
        return null;
    }

    @Override
    public String createTable() {
        return "create table if not exists tb_photo(path TEXT,time TEXT,sendTime TEXT)";
    }
}
