package com.example.sqlite.rzm.versionV002;

import com.example.sqlite.rzm.User;
import com.example.sqlite.rzm.db.BaseDao;

import java.util.List;


public class UserDao extends BaseDao<com.example.sqlite.rzm.versionV002.User> {
    @Override
    public String createTable() {
        return "create table if not exists tb_user( user_id Text,name TEXT, password TEXT, lastLoginTime TEXT);";
    }

    @Override
    public List<com.example.sqlite.rzm.versionV002.User> query(String sql) {
        return null;
    }
}
