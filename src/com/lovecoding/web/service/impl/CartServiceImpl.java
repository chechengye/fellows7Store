package com.lovecoding.web.service.impl;

import com.lovecoding.web.bean.Cart;
import com.lovecoding.web.bean.CartAndProduct;
import com.lovecoding.web.dao.CartDao;
import com.lovecoding.web.service.CartService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {

    private static CartDao cartDao;

    static {
        cartDao = new CartDao();
    }

    /**
     * 加购物车操作
     * @param parameterMap
     * @return
     */
    @Override
    public int addShopCart(Map<String, String[]> parameterMap) {
        Cart cart = new Cart();
        try {
            BeanUtils.populate(cart, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return cartDao.addShopCart(cart);
    }

    /**
     * 获取当前用户购物信息
     * @param uid
     * @return
     */
    @Override
    public List<CartAndProduct> getCartList(String uid) {
        return cartDao.getCartList(uid);
    }
}
