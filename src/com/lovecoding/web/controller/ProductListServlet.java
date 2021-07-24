package com.lovecoding.web.controller;

import com.lovecoding.web.service.ProductService;
import com.lovecoding.web.service.impl.ProductServiceImpl;
import com.lovecoding.web.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService = new ProductServiceImpl();

        req.setCharacterEncoding("utf-8");

        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        Integer maxCount = 12;
        //返给前端的不仅仅是数据了 ； 当前页号、总页数
        PageVo pageVo = productService.getPageVoByCurrentPageAndMaxCount(currentPage , maxCount);
        //List<Product> productList = productService.getProductList();
        req.setAttribute("pageVo" , pageVo);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
