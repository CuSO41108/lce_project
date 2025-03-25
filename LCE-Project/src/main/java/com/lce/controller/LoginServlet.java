package com.lce.controller;

import com.lce.service.UserService;
import com.lce.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success = userService.login(username, password);

        PrintWriter out = response.getWriter();
        if (success) {
            out.print(JsonUtil.createJsonResponse(200, "登录成功"));
        } else {
            out.print(JsonUtil.createJsonResponse(401, "用户名或密码错误"));
        }
    }
}

