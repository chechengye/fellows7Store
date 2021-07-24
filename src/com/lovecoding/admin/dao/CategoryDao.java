package com.lovecoding.admin.dao;

import com.lovecoding.admin.bean.Category;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CategoryDao {
    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public List<Category> getCategoryList() {

        try {
            List<Category> categoryList = qr.query("select c.cid , c.cname from category c ", new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public int delCategoryByCid(String cid) {
        try {
            int rows = qr.update("delete from category where cid = ?" , cid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int addCategory(Category category) {
        try {
            int rows = qr.update("insert into category values(?,?)" , category.getCid() , category.getCname());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Category getCategoryByCid(String cid) {

        try {
            Category category = qr.query("select c.cid , c.cname from category c where c.cid = ?" ,new BeanHandler<>(Category.class),cid);
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateCategoryByCid(Category category) {
        try {
            int rows = qr.update("update category set cname = ? where cid = ? " , category.getCname() , category.getCid());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
