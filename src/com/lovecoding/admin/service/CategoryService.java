package com.lovecoding.admin.service;

import com.lovecoding.admin.bean.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> getCategoryList();

    int delCategoryByCid(String cid);

    int addCategory(String cname);

    Category getCategoryByCid(String cid);

    int updateCategoryByCid(Map<String , String[]> map);
}
