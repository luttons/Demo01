package com.lutton.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：Servlet01
 * @Description： TODO   全局作用域对象，获取端
 * @Author： Lut_Ton@GitHub
 */

public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        super.service(req, resp);
            System.out.println(" s02 , 获取全局作用域对象正在执行");

//        可能会出现空指针异常     ctrl alt t  快速选中进行异常处理

        try {
//        获取全局作用域对象
            ServletContext servletContext = req.getServletContext();
//        通过属性键，获取属性的值
            String teacher = servletContext.getAttribute("teacher").toString();
            String student = servletContext.getAttribute("student").toString();

//        将获取到的内容输出到页面
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<p style='color:green'> teacher = " + teacher + " </p>");
            resp.getWriter().println("<p style='color:green'> student = " + student + " </p>");
        } catch (Exception e) {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<p style='color:red'> 全局作用域对象属性不存在 </p>");

        }
    }
}
