package com.lutton.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：Servlet01
 * @Description： TODO   全局作用域对象，设置端
 * @Author： Lut_Ton@GitHub
 */

/**
 *  全局作用域对象：
 *  在不同的 Servlet 里进行设置， 所有的 Servlet 都可以进行访问。
 *  生存周期：随着 Tomcat 启动而生成，随着 Servlet 的关闭而销毁
 */

public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println("s01, 设置全局作用域对象正在执行");

//        通过 request 请求对象获取 全局作用域对象
        ServletContext servletContext = req.getServletContext();
//        为全局作用域对象设置键值对属性
        servletContext.setAttribute("student","xiaosi");
        servletContext.setAttribute("teacher","lutton");



    }

}
