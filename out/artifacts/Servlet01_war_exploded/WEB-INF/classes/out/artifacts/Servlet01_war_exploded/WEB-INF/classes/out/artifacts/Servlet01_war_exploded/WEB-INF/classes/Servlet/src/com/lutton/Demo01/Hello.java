package com.lutton.Demo01;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @ClassName：Hello
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Hello extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        System.out.println("你好！！！！");
    }
}
