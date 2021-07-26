package com.lovecoding.admin.controller;

import com.lovecoding.admin.bean.Product;
import com.lovecoding.admin.service.ProductService;
import com.lovecoding.admin.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminProductUpdate")
public class AdminProductUpdateServlet extends HttpServlet {

    private ProductService productService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        productService = new ProductServiceImpl();
        int rows = productService.updateProductByPid(req.getParameterMap());
        if(rows > 0){
            List<Product> productList = productService.getProductListByCondition(null);
            req.setAttribute("productList" , productList);
            req.getRequestDispatcher("/admin/product/list.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
