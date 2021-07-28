package com.lovecoding.web.service;

import com.lovecoding.web.bean.CartAndProduct;

import java.util.List;
import java.util.Map;

public interface CartService {
    int addShopCart(Map<String, String[]> parameterMap);

    List<CartAndProduct> getCartList(String uid);
}
