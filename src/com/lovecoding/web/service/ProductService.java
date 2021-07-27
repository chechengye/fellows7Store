package com.lovecoding.web.service;

import com.lovecoding.web.bean.Product;
import com.lovecoding.web.vo.PageVo;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    Product getProductDetailByPid(String pid);

    PageVo getPageVoByCurrentPageAndMaxCount(String currentPage, Integer maxCount , String cid);

    List<Product> searchProductByWord(String word);
}
