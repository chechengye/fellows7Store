package com.lovecoding.web.dao;

import com.lovecoding.web.bean.Cart;
import com.lovecoding.web.bean.CartAndProduct;
import com.lovecoding.web.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CartDao {

    private static QueryRunner qr;

    static {
        qr = new QueryRunner(C3p0Pool.getDataSource());
    }
    public int addShopCart(Cart cart) {

        try {
            Long l = (Long)qr.query("select count(*) from t_cart c where uid = ? and pid = ? " , new ScalarHandler(), cart.getUid() , cart.getPid());

            if(l > 0){//存在了
                return qr.update("update t_cart set count = count + ? where uid = ? and pid = ? " , cart.getCount(), cart.getUid() , cart.getPid());
            }else{
                return qr.update("insert into t_cart(uid , pid , count) values (? ,? ,? )" , cart.getUid() , cart.getPid() , cart.getCount());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CartAndProduct> getCartList(String uid) {
        try {
            return qr.query("select c.id, p.pname , p.pimage , p.shop_price shopPrice , c.count  from t_cart c , product p where c.pid = p.pid and c.uid = ? " , new BeanListHandler<>(CartAndProduct.class) , uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
