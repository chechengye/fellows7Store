package com.lovecoding.admin.dao;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.vo.Condition;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }

    public List<Product> getProductListByCondition(Condition condition) {

        try {
            String sql = "select p.pid , p.pimage " +
                    ",p.market_price marketPrice,  p.pname " +
                    ", p.shop_price as shopPrice , p.pdesc , p.is_hot isHot from product p where 1=1 ";
            List<Object> param = new ArrayList<>();
            if(null != condition && condition.getCid() != null && !condition.getCid().equals("")){
                sql += " and p.cid = ? ";
                param.add(condition.getCid());
            }

            if(null != condition && condition.getIsHot() != null && !condition.getIsHot().equals("")){
                sql += " and p.is_hot = ? ";
                param.add(condition.getIsHot());
            }
            //sql语句的模糊查询 like '%田' : 以田结尾的匹配上   like '田%'  ： 以田开始的后面任意   like '%田%' ： 包含田的 -- 常用
            if(null != condition && condition.getPname() != null && !condition.getPname().equals("")){
                sql += " and p.pname like ? ";
                param.add("%" + condition.getPname() + "%");
            }
            System.out.println("sql = " + sql);

            List<Product> productList = qr.query(sql , new BeanListHandler<>(Product.class) , param.toArray());
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
