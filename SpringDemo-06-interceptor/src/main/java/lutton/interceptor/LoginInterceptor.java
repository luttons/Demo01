package com.lutton.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName：MyInterceptor01
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
//    在执行目标之前运行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle is running!");

        HttpSession session = request.getSession();
        if (null != session.getAttribute("username")){
            return true;
        }else{
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return false;
        }

    }

}
