package com.example.sqlite.rzm.versionV001;

import com.example.sqlite.rzm.db.annotion.DbTable;

/**
 * V001
 */
@DbTable("tb_user")
public class User {

    public String user_id;
    public String name;

    public String password;
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
