package com.lovecoding.web.dao;

import com.lovecoding.web.bean.User;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;

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
}