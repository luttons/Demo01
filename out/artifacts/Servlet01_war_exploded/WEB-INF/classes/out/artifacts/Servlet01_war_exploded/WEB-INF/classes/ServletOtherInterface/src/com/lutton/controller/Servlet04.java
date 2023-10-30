package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：Servlet03
 * @Description： TODO     获取 cookie
 * @Author： Lut_Ton@GitHub
 */

public class Servlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        设置请求与相应的字符编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

//        获取相应输出对象
        PrintWriter out = resp.getWriter();

//        获取 cookie
        Cookie[] cookies = req.getCookies();

//        判断是否存在 cookie， 并输出 cookie
        if (cookies != null){
            for (Cookie cookie : cookies) {
                String keyName = cookie.getName();
                String value = cookie.getValue();
                out.print( "<p>" + "keyName:" + keyName + "value:" + value + "</p>");
            }
        }else {
            out.println("没有任何 Cookie");
        }

    }
}
