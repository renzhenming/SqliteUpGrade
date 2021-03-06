package com.example.sqlite.rzm;

import android.util.Log;

import com.example.sqlite.rzm.db.BaseDao;

import java.util.List;

import static android.content.ContentValues.TAG;

public class UserDao extends BaseDao<User> {
    @Override
    public String createTable() {
        return "create table if not exists tb_user( name TEXT, password TEXT, user_id Text);";
    }

    @Override
    public Long insert(User entity) {
        List<User> list=query(new User());
        User where = null;
        for (User user:list)
        {
            where =new User();
            where.setUser_id(user.getUser_id());
            Log.i(TAG,"用户"+user.getName()+"更改为未登录状态");
            update(user,where);
        }
        Log.i(TAG,"用户"+entity.getName()+"登录");
        return super.insert(entity);
    }

    @Override
    public List<User> query(String sql) {
        return null;
    }

    /**
     * 得到当前登录的User
     * @return
     */
    public User getCurrentUser() {
        User user=new User();
        List<User> list=query(user);
        if(list.size()>0)
        {
            return list.get(0);
        }
        return null;
    }
}
