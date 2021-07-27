package com.lovecoding.web.controller;

import com.alibaba.fastjson.JSON;
import com.lovecoding.web.bean.Product;
import com.lovecoding.web.service.ProductService;
import com.lovecoding.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchProduct")
public class SearchProductServlet extends HttpServlet {

    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        productService = new ProductServiceImpl();
        List<Product> productList =  productService.searchProductByWord(req.getParameter("word"));
        String productListJsonStr = JSON.toJSONString(productList);
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("productListJsonStr = " + productListJsonStr);
        resp.getWriter().write(productListJsonStr);
    }
}
