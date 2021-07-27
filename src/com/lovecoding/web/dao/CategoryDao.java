package com.lovecoding.web.dao;

import com.lovecoding.web.bean.Category;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryDao {
    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public List<Category> getCategoryListHasProduct() {

        try {
            return qr.query("select pc.cid , pc.cname , pc.count from (select COUNT(p.pname) as count ,c.cid , c.cname from category c  LEFT JOIN product p " +
                    "ON p.cid = c.cid GROUP BY c.cname ) pc where pc.count > 0" , new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
