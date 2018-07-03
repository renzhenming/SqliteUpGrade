package com.example.sqlite.rzm.versionV001;

import com.example.sqlite.rzm.db.BaseDao;

import java.util.List;


public class UserDao extends BaseDao<User> {
    @Override
    public String createTable() {
        return "create table if not exists tb_user( user_id Text,name TEXT, password TEXT);";
    }

    @Override
    public List<User> query(String sql) {
        return null;
    }
}
