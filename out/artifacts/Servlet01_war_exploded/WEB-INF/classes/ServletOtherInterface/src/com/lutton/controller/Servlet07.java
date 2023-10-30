package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName：Servlet03
 * @Description： TODO        过滤器 针对 .do 文件进行过滤的 测试文件
 * @Author： Lut_Ton@GitHub
 */

public class Servlet07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print("<h1>我是一个标题，如果能中文输出，就表示Filter02生效了</h1>");

    }
}
