package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：BServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class BServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String urlNum = req.getParameter("urlNum");
        final String URL01 = "/myweb/a.do";
        final String URL02 = "https://www.itlaoxie.com";

        switch (urlNum) {
            case "1":
//                相应的时候做 重定向，地址栏会变化为重定向之后的 URL 内容
                resp.sendRedirect(URL01);
                break;
            case "2":
                resp.sendRedirect(URL02);
                break;
        }
    }
}

