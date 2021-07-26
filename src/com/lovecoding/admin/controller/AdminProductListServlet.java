package com.lovecoding.admin.controller;

import com.lovecoding.admin.bean.Category;
import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.service.CategoryService;
import com.lovecoding.admin.service.ProductService;
import com.lovecoding.admin.service.impl.CategoryServiceImpl;
import com.lovecoding.admin.service.impl.ProductServiceImpl;
import com.lovecoding.admin.vo.Condition;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/adminProductList")
public class AdminProductListServlet extends HttpServlet{
    private CategoryService categoryService;

    private ProductService productService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        categoryService = new CategoryServiceImpl();
        productService = new ProductServiceImpl();

        List<Category> categoryList = categoryService.getCategoryList();
        req.setAttribute("categoryList" , categoryList);
        Condition condition = new Condition();
        try {
            BeanUtils.populate(condition , req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("condition = " + condition);
        List<Product> productList = productService.getProductListByCondition(condition);
        req.setAttribute("productList",productList);
        req.setAttribute("condition" , condition);

        req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
