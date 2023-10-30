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

/**
 *  service 可以接受各种类型的提交方式，覆盖面积很广
 *  如果写了 service 方法，就会屏蔽掉其他接收方式方法
 *  但是在 service 方法中调用 父类 service方法后，会先执行相应的方法，
 *      再执行一次自己写的 service方法
 */

public class BServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("This is BServlet's service()");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("This is BServlet's doGet()");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("This is BServlet's doPost()");
    }





}
