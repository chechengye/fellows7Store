package com.lovecoding.controller;

import com.lovecoding.bean.Product;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //应该查询数据库里面的商品表信息获取数据
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            List<Product> productList = qr.query("select p.pimage , p.pname , p.shop_price as shopPrice from product p ", new BeanListHandler<>(Product.class));
            req.setAttribute("productList" , productList);
            req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
