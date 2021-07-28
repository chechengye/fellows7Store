package com.lovecoding.web.controller;

import com.lovecoding.web.service.CartService;
import com.lovecoding.web.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addShopCart")
public class AddShopCartServlet extends HttpServlet {

    private CartService cartService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cartService = new CartServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int rows = cartService.addShopCart(req.getParameterMap());
        System.out.println(req.getParameter("count"));
        if(rows > 0){//添加或修改成功
            resp.getWriter().write("添加购物车成功！");
        }else{
            resp.getWriter().write("添加购物车失败！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
