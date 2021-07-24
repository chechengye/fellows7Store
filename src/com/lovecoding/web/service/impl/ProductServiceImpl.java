package com.lovecoding.web.service.impl;

import com.lovecoding.web.bean.Product;
import com.lovecoding.web.dao.ProductDao;
import com.lovecoding.web.service.ProductService;
import com.lovecoding.web.vo.PageVo;

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

    /**
     * 根据页号与页数量查询封装PageVo对象
     * @param currentPage
     * @param maxCount
     * @return
     */
    @Override
    public PageVo getPageVoByCurrentPageAndMaxCount(String currentPage, Integer maxCount) {
        PageVo pageVo = new PageVo();
        pageVo.setCurrentPage(Integer.valueOf(currentPage));
        List<Product> productList = productDao.getProductListByCurrentPageAndMaxCount(currentPage, maxCount);
        pageVo.setProductList(productList);
        //总页数 = 总数据条数 / maxCount  Math.ceil() 向上取整 天花板;
        Integer totalCount = productDao.getProductCount();
        pageVo.setTotalPages((int) Math.ceil(totalCount * 1.0 / maxCount));
        return pageVo;
    }
}
