package com.lovecoding.service;

import com.lovecoding.bean.Product;
import com.lovecoding.vo.PageVo;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product getProductDetailByPid(String pid);

    PageVo getPageVoByCurrentPageAndMaxCount(String currentPage, Integer maxCount);
}
