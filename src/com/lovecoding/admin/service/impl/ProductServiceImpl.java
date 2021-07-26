package com.lovecoding.admin.service.impl;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.dao.ProductDao;
import com.lovecoding.admin.service.ProductService;
import com.lovecoding.admin.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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

    @Override
    public Product getProductDetailByPid(String pid) {

        return productDao.getProductDetailByPid(pid);
    }

    /**
     * 根据商品主键修改商品信息
     * @param parameterMap
     * @return
     */
    @Override
    public int updateProductByPid(Map<String, String[]> parameterMap) {
        try {
            Product product = new Product();
            BeanUtils.populate(product ,parameterMap);
            System.out.println("product = " + product);
            return productDao.updateProductByPid(product);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
