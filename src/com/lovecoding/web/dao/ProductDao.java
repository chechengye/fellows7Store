package com.lovecoding.web.dao;

import com.lovecoding.web.bean.Product;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 访问数据库
 */
public class ProductDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public List<Product> getProductList() {
        try {
            List<Product> productList = qr.query("select p.pid , p.pimage , p.pname , p.shop_price as shopPrice from product p ", new BeanListHandler<>(Product.class));
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Product getProductDetailByPid(String pid) {
        try {
            Product product = qr.query("select p.pid , p.pimage ,p.market_price marketPrice,  p.pname , p.shop_price as shopPrice , p.pdesc from product p where pid = ?" , new BeanHandler<>(Product.class) , pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductListByCurrentPageAndMaxCount(String currentPage, Integer maxCount , String cid) {
        try {
            String sql = "select p.pid , p.pimage , p.pname , p.shop_price as shopPrice from product p where 1=1 ";//  LIMIT ? ,?
            List<Object> list = new ArrayList<>();
            if(null != cid && !cid.equals("")){
                sql += "and p.cid = ? ";
                list.add(cid);
            }
            sql += "LIMIT ? ,? ";
            list.add((Integer.valueOf(currentPage) - 1) * maxCount);
            list.add(maxCount);
            List<Product> productList = qr.query(sql , new BeanListHandler<>(Product.class) , list.toArray());

            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Integer getProductCount(String cid) {

        try {
            String sql = "select count(*) from product p where 1=1 ";
            List<Object> list = new ArrayList<>();
            if(null != cid && !cid.equals("")){
                sql+= " and p.cid = ? ";
                list.add(cid);
            }
            Long l = (Long)qr.query(sql , new ScalarHandler() , list.toArray());
            return l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> searchProductByWord(String word) {
        try {
            return qr.query("select p.pid, p.pname from product p where p.pname like ? LIMIT 0 , 8" , new BeanListHandler<>(Product.class) , "%" +word+ "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
