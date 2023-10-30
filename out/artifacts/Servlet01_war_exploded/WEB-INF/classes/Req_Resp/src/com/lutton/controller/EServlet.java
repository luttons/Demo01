package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：CServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class EServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

//        获取 站内站外地址
        String uri = req.getRequestURI();
        StringBuffer url = req.getRequestURL();

        out.println("url: " + url + "<hr>");    // 站外地址
        out.println("uri : " + uri + "<hr>");   // 站内地址

//        获取提交方式
        String method = req.getMethod();
        out.println("method:" + method + "<hr>");

//        获取具体的 键所对应的值
        String info = req.getParameter("info");
        out.print("info:" + info + "<hr>");


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
