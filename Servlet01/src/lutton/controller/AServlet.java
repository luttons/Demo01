package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @ClassName：AServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class AServlet extends HttpServlet {
//    在没有人工设置自动创建 Servlet 对象的情况下，
//    只有收到 servlet 请求后，才会创建 servlet对象
//    并且它的生命周期 只有在tomcat被关闭的时候才会消失
//    因此，它不会被二次创(只能创建一个对象)
    public AServlet() {
        System.out.println("创建了 Servlet 对象");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("这是AServlet!!!!");
    }
}
