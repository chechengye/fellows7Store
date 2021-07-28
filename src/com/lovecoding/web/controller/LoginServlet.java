package com.lovecoding.web.controller;


import com.lovecoding.web.bean.User;
import com.lovecoding.web.service.UserService;
import com.lovecoding.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private UserService userService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userService = new UserServiceImpl();
        User user = userService.login(username , password);
        if(null != user){
            //携带用户信息过去
            //session域来存储对象
            HttpSession session = req.getSession();
            Cookie cookie = new Cookie("JSESSIONID" , session.getId());
            cookie.setMaxAge(60*60);//单位s
            resp.addCookie(cookie);
            System.out.println(user);
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            //应该回到login.html 并提示用户名与密码
            req.setAttribute("errMsg" , "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req , resp);//forward:一定要写

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req  , resp);
    }
}
