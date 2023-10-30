package com.lutton.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName：MyInterceptor01
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyInterceptor01 implements HandlerInterceptor {
    @Override
//    在执行目标之前运行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle is running!");
        System.out.println(request.getParameter("username"));

        if (request.getParameter("username").equals("root"))
            return true;  // 放行
        else
            request.getRequestDispatcher("/failed.jsp").forward(request, response);
            return false;   // 不放行

    }

    @Override
//    执行目标之后，返回视图之前运行
//    可以添加或覆盖一个 Object， 一般用来做数据的二次加工
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle is running!");

//        将已经存的的 username = lutton 覆盖
//        modelAndView.addObject("username", "XiaoSi");
    }

    @Override
//    返回视图之后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("postHandle is afterCompletion!");
    }
}
