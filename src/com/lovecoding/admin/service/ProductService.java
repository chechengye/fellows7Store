package com.lovecoding.admin.service;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.vo.Condition;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProductListByCondition(Condition condition);

    Product getProductDetailByPid(String pid);

    int updateProductByPid(Map<String, String[]> parameterMap);

}
