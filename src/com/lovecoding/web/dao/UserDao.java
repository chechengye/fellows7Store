package com.lovecoding.web.dao;

import com.lovecoding.web.bean.User;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public int register(User user) {

        try {
            int rows = qr.update("insert into user values(?,?,?,?,?,?,?,?,?,?)" ,
                    user.getUid(),
                    user.getUsername(),
                    user.getPassword() ,
                    user.getName() ,
                    user.getEmail() ,
                    user.getTelephone() ,
                    user.getBirthday() ,
                    user.getSex() ,
                    0 ,
                    user.getCode());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int checkUserIsExit(String username) {
        try {
            Long l = (Long)qr.query("select count(*) from user u where u.username = ?" , new ScalarHandler() , username);
            return l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User login(String username, String password) {
        try {
            return qr.query("select u.name , u.uid from user u where username = ? and password = ? " , new BeanHandler<>(User.class) , username , password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
