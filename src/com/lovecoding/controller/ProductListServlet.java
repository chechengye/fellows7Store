package com.lovecoding.controller;

import com.lovecoding.bean.Product;
import com.lovecoding.service.ProductService;
import com.lovecoding.service.impl.ProductServiceImpl;
import com.lovecoding.util.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productService = new ProductServiceImpl();

        List<Product> productList = productService.getProductList();
        req.setAttribute("productList" , productList);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
