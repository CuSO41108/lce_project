package com.lce.controller;

import com.alibaba.fastjson.JSON;
import com.lce.model.User;
import com.lce.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

    throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        UserService userService = new UserService();
        boolean success = userService.register(user);

        response.setContentType("application/json");
        if (success) {
            response.getWriter().write(JSON.toJSONString("{\"code\":200, \"message\":\"注册成功\"}"));

        }
        else {
            response.getWriter().write(JSON.toJSONString("{\"code\":500, \"message\":\"注册失败\"}"));
        }

    }

}
