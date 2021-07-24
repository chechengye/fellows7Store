package com.lovecoding.admin.service.impl;

import com.lovecoding.admin.bean.Category;
import com.lovecoding.admin.dao.CategoryDao;
import com.lovecoding.admin.service.CategoryService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService {

    private static CategoryDao categoryDao;
    static {
        categoryDao = new CategoryDao();
    }

    /**
     * 获取所有分类信息
     * @return
     */
    @Override
    public List<Category> getCategoryList() {
        return categoryDao.getCategoryList();
    }

    /**
     * 删除分类根据分类主键
     * @param cid
     * @return
     */
    @Override
    public int delCategoryByCid(String cid) {
        return categoryDao.delCategoryByCid(cid);
    }

    /**
     * 添加分类信息
     * @param cname
     * @return
     */
    @Override
    public int addCategory(String cname) {
        Category category = new Category();
        category.setCname(cname);
        category.setCid(UUID.randomUUID().toString().replaceAll("-",""));
        return categoryDao.addCategory(category);
    }

    /**
     * 根据主键查询分类详情信息
     * @param cid
     * @return
     */
    @Override
    public Category getCategoryByCid(String cid) {
        return categoryDao.getCategoryByCid(cid);
    }

    @Override
    public int updateCategoryByCid(Map<String , String[]> map) {
        Category category = new Category();
        try {
            BeanUtils.populate(category , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return categoryDao.updateCategoryByCid(category);
    }
}
