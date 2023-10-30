package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：Login_Servlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Login_Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        告诉前端响应数据的格式
        resp.setContentType("text/html;charset=utf-8");

//        模拟从数据库里拿来用户名和密码
//        userModel.getGetLoginInfo ()  假设通过这个获取到用户名和密码

        String uname = "123";
        String pwsd = "123";

        String username = req.getParameter("userName");
        String password = req.getParameter("password");

//        if (username.equals(uname) && password.equals(pwsd)){
//            System.out.println("欢迎" + username + "回来");
//        }else {
//            System.out.println("用户名或密码错误！~");
//        }

        PrintWriter out = resp.getWriter();
        if (username.equals(uname) && password.equals(pwsd)){
            out.write("<h3>欢迎" + username + "回来</h3>");
        }else {
            out.write("<h3 style='color:red'>用户名或密码错误！~</h3>");
        }





    }



}
