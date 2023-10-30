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

public class DServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String info = req.getParameter("info");
        PrintWriter out = resp.getWriter();
        out.println("<h3>" + info + " </h3>");
    }
}
