package com.lovecoding.web.service.impl;

import com.lovecoding.web.bean.Category;
import com.lovecoding.web.dao.CategoryDao;
import com.lovecoding.web.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    static CategoryDao categoryDao ;
    static {
        categoryDao = new CategoryDao();
    }

    @Override
    public List<Category> getCategoryListHasProduct() {
        return categoryDao.getCategoryListHasProduct();
    }
}
