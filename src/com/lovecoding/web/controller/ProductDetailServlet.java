package com.lovecoding.web.controller;


import com.lovecoding.web.bean.Product;
import com.lovecoding.web.service.ProductService;
import com.lovecoding.web.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productDetail")
public class ProductDetailServlet extends HttpServlet{

    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");
        productService = new ProductServiceImpl();
        Product product = productService.getProductDetailByPid(pid);
        if(null != product){
            req.setAttribute("product" , product);
            req.getRequestDispatcher("/product_info.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
