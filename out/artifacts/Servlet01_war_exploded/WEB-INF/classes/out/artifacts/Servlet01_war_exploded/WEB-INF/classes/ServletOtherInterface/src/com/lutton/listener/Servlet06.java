package com.lutton.listener;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName：Servlet03
 * @Description： TODO     session 对象 获取属性
 * @Author： Lut_Ton@GitHub
 */

public class Servlet06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//      获取 Session 对象
        HttpSession session = req.getSession();
//        通过 Session 对象获取 属性对应的值
        Object teacherName = session.getAttribute("teacherName");
        Object studentName = session.getAttribute("studentName");

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("teacher = " + teacherName + "<hr>");
        resp.getWriter().print("student = " + studentName + "<hr>");

    }
}
