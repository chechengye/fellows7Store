package com.lovecoding.service.impl;

import com.lovecoding.bean.Product;
import com.lovecoding.dao.ProductDao;
import com.lovecoding.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    //正常情况下ProductDao也是一个接口
    private static ProductDao productDao;

    static {
        productDao = new ProductDao();
    }

    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<Product> getProductList() {
        //业务代码编写，根据不同应用场景

        return productDao.getProductList();
    }

    /**
     * 根据商品主键获取商品详情信息
     * @param pid
     * @return
     */
    @Override
    public Product getProductDetailByPid(String pid) {

        return productDao.getProductDetailByPid(pid);
    }
}
