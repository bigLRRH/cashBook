package com.cashbook.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.cashbook.entity.User;
import com.cashbook.service.UserService;

public class LoginServlet extends HttpServlet {
    private User user;
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user = new User(username, password);
        if (userService.userCheck(user))
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
        else
            response.getWriter().write("<script> alert(\"please check your username or password\"); </script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse resonse)
            throws ServletException, IOException {
        doPost(request, resonse);
    }
}
