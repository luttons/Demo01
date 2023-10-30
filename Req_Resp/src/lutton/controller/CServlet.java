package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：CServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class CServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
//        请求转发的时候，地址栏中的内容不会跟着改变，显示的是当前 Servlet 的URL 地址
//        显示的页面是 转发到的 Servlet 的页面(a.do)
//        req.getRequestDispatcher("/a.do").forward(req, resp);
        req.getRequestDispatcher("/d.do").forward(req, resp);
    }
}
