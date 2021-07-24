package com.lovecoding.dao;

import com.lovecoding.bean.Product;
import com.lovecoding.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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
}
