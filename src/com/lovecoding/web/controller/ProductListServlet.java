package com.lovecoding.web.controller;

import com.lovecoding.web.bean.Category;
import com.lovecoding.web.service.CategoryService;
import com.lovecoding.web.service.ProductService;
import com.lovecoding.web.service.impl.CategoryServiceImpl;
import com.lovecoding.web.service.impl.ProductServiceImpl;
import com.lovecoding.web.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService;

    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService = new ProductServiceImpl();

        categoryService = new CategoryServiceImpl();

        req.setCharacterEncoding("utf-8");

        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");

        String cid = req.getParameter("cid") == null ? "" : req.getParameter("cid");
        Integer maxCount = 12;
        //返给前端的不仅仅是数据了 ； 当前页号、总页数
        PageVo pageVo = productService.getPageVoByCurrentPageAndMaxCount(currentPage , maxCount , cid);

        List<Category>  categoryList = categoryService.getCategoryListHasProduct();
        //List<Product> productList = productService.getProductList();
        req.setAttribute("pageVo" , pageVo);
        req.setAttribute("categoryList" , categoryList);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
