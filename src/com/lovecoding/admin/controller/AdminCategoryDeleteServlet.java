package com.lovecoding.admin.controller;

import com.lovecoding.admin.service.CategoryService;
import com.lovecoding.admin.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminCategoryDelete")
public class AdminCategoryDeleteServlet extends HttpServlet{

    private CategoryService categoryService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("cid"));
        categoryService = new CategoryServiceImpl();
        int rows = categoryService.delCategoryByCid(req.getParameter("cid"));
        if(rows > 0){
            req.setAttribute("categoryList" ,categoryService.getCategoryList());//刷新
            req.getRequestDispatcher("/admin/category/list.jsp").forward(req , resp);
        }
    }
}
