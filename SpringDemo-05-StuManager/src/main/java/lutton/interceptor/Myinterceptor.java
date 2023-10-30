package com.lutton.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName：Myinterceptor
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Myinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor is running!");

        HttpSession session = request.getSession();
        if (null != session.getAttribute("username")){
            return true;
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return false;
        }

    }
}
