package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @ClassName：CServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

/**
 * req.getParameter("hobby"); --------- 获取单个值
 * req.getParameterValues("hobby");     ---------   获取多个值
 *
 *
*/
public class GServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getMethod().equals("POST"))
            req.setCharacterEncoding("utf-8");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String[] p = req.getParameterValues("hobby");
        for (String s : p) {
            System.out.println(s);
        }


    }
}




    //    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
//
////        获取请求头中所有的参数名称（键）
//        Enumeration<String> key = req.getParameterNames();
//        while (key.hasMoreElements()){
//            String keys = key.nextElement();
////            获取所有参数对应的值
//            String value = req.getParameter(keys);
//            System.out.println("key:" + keys + "   value:" + value);
//
//            resp.getWriter().println("请求参数名：" + keys + "       值为:" + value + "<br>");
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        super.doPost(req, resp);
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//
////        获取请求头中所有的参数名称（键）
//        Enumeration<String> key = req.getParameterNames();
//        while (key.hasMoreElements()){
//            String keys = key.nextElement();
////            获取所有参数对应的值
//            String value = req.getParameter(keys);
//            System.out.println("key:" + keys + "   value:" + value);
//
//            resp.getWriter().println("请求参数名：" + keys + "       值为:" + value + "<br>");
//        }
//    }

