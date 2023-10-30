package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @ClassName：CServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

/**
 * //    get 方式的提交里面，数据都在消息头当中，请求的时候，指定了字符编码，所以不会出现乱码
 * //    post 提交的时候，请求数据 在 请求的数据包体当中，不在头里面
 *
 *  ---------->    解决方案：           <--------------
 *         req.setCharacterEncoding("utf-8");
 *         resp.setContentType("text/html;charset=utf-8");
 */
public class FServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getMethod().equals("POST"))
            req.setCharacterEncoding("utf-8");

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");


//        获取请求头中所有的参数名称（键）
        Enumeration<String> key = req.getParameterNames();

        while (key.hasMoreElements()){
            String keys = key.nextElement();
//            获取所有参数对应的值
            String value = req.getParameter(keys);
            System.out.println("key:" + keys + "   value:" + value);

            resp.getWriter().println("请求参数名：" + keys + "       值为:" + value + "<br>");
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

