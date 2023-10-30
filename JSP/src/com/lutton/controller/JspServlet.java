package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName：JspServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class JspServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "lutton");
        req.setAttribute("job", "程序员");

//        getRequestDispatcher("/test02.jsp")
//        它用于获取一个请求分发器对象。
//        请求分发器对象用于将请求转发到另一个资源（例如，另一个Servlet或JSP页面）进行处理

//        forward() 方法用于将请求和响应对象传递给另一个Servlet或JSP页面，
//        以便在目标资源中处理请求并生成响应。
//        这种转发可以在服务器端内部进行，对客户端是透明的。
//        此时, test02.jsp 可以认为是写入的 Java代码,因此后面的 forward可以带参数
        req.getRequestDispatcher("/test02.jsp").forward(req, resp);
    }
}
