package com.lovecoding.admin.service.impl;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.dao.ProductDao;
import com.lovecoding.admin.service.ProductService;
import com.lovecoding.admin.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static ProductDao productDao;

    static {
        productDao = new ProductDao();
    }

    /**
     * 根据搜索条件获取商品列表
     * @return
     */
    @Override
    public List<Product> getProductListByCondition(Condition condition) {
        return productDao.getProductListByCondition(condition);
    }
}
