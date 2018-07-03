package com.example.sqlite.rzm.versionV001;

import com.example.sqlite.rzm.db.BaseDao;

import java.util.List;

/**
 * V001
 */
public class PhotoDao  extends BaseDao<Photo>{

    @Override
    public List<Photo> query(String sql) {
        return null;
    }

    @Override
    public String createTable() {
        return "create table if not exists tb_photo(path TEXT,time TEXT)";
    }
}
