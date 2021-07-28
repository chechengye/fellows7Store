package com.lovecoding.web.controller;

import com.lovecoding.web.bean.CartAndProduct;
import com.lovecoding.web.service.CartService;
import com.lovecoding.web.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet {

    private CartService cartService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cartService = new CartServiceImpl();
        req.setCharacterEncoding("utf-8");
        System.out.println("uid" + req.getParameter("uid"));
        List<CartAndProduct> cartAndProductList = cartService.getCartList(req.getParameter("uid"));
        req.setAttribute("cartAndProductList" , cartAndProductList);
        System.out.println("cartAndProductList" + cartAndProductList);
        req.getRequestDispatcher("/cart.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
