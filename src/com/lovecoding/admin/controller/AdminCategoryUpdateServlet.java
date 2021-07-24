package com.lovecoding.admin.controller;

import com.lovecoding.admin.bean.Category;
import com.lovecoding.admin.service.CategoryService;
import com.lovecoding.admin.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminCategoryUpdate")
public class AdminCategoryUpdateServlet extends HttpServlet {

    private CategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        categoryService = new CategoryServiceImpl();
        req.setCharacterEncoding("utf-8");
        int  rows = categoryService.updateCategoryByCid(req.getParameterMap());
        if(rows > 0){
            req.setAttribute("categoryList" ,categoryService.getCategoryList());//刷新
            req.getRequestDispatcher("/admin/category/list.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
