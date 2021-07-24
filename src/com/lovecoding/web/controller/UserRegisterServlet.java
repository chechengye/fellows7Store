package com.lovecoding.web.controller;

import com.lovecoding.web.service.UserService;
import com.lovecoding.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet{

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        userService = new UserServiceImpl();

        Map<String, String[]> parameterMap = req.getParameterMap();
        int rows = userService.register(parameterMap);

        if(rows > 0){//跳转登录

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
