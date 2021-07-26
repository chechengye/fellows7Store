package com.lovecoding.web.controller;

import com.lovecoding.web.service.UserService;
import com.lovecoding.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUserInfo")
public class CheckUserInfoServlet extends HttpServlet{

    UserService userService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");

        System.out.println("username = " + username);
        userService = new UserServiceImpl();
        int count = userService.checkUserIsExit(username);
        if(count > 0){
            resp.getWriter().write("此用户名已存在！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req ,resp);
    }
}
