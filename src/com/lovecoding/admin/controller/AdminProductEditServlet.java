package com.lovecoding.admin.controller;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.service.CategoryService;
import com.lovecoding.admin.service.ProductService;
import com.lovecoding.admin.service.impl.CategoryServiceImpl;
import com.lovecoding.admin.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminProductEdit")
public class AdminProductEditServlet extends HttpServlet{

    private ProductService productService;
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        productService = new ProductServiceImpl();
        Product product = productService.getProductDetailByPid(req.getParameter("pid"));
        if(null != product){
            categoryService = new CategoryServiceImpl();

            req.setAttribute("product" , product);
            req.setAttribute("categoryList" , categoryService.getCategoryList());

            req.getRequestDispatcher("/admin/product/edit.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
