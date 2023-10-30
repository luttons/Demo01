package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：Servlet03
 * @Description： TODO       设置 cookie
 * @Author： Lut_Ton@GitHub
 */

public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        实例化两个 cookie 对象
        Cookie cookie01 = new Cookie("teacher", "laoxie");
        Cookie cookie02 = new Cookie("student", "xiaosi");

//        设置一下 cookie 的有效时长, 以 秒(s) 为单位
        cookie01.setMaxAge(60);
        cookie02.setMaxAge(20);

//        通过响应对象，将 cookie 对象添加到浏览器端（客户端）
        resp.addCookie(cookie01);
        resp.addCookie(cookie02);

    }
}
