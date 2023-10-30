package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：AServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class AServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);

//        获取前端输出流的资源
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.write("<h3>你好，这是我的响应数据</h3><hr>");

//        小写字母a的 ASCII码 是 97，
//        A = 65
//        "0"  = 48
//        因此把num写到页面上后，会显示 字母 d，而不是100
        int num = 100;
        out.write(num);

//        这次就是 100
        out.println(num);

    }
}
