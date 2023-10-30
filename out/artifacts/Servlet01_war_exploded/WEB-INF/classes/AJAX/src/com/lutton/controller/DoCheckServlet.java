package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @ClassName：DoCheckServlet
 * @Description： TODO          注册时，检查用户的 id 是否可用
 * @Author： Lut_Ton@GitHub
 */

/**
 *  AJAX 处理的时候，直接重写 service 方法就行了
 */

public class DoCheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        字符集处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        服务器端输出的内容
        System.out.println("前台访问了 doCheck.do 中的 Service 方法");
        String uname = req.getParameter("uname");
        System.out.println("接收到 AJAX 传递过来的 " + uname);


//        客户端（网页端）要做的操作
        PrintWriter out = resp.getWriter();
//        模拟数据库的数据对比, 响应到 AJAX 一端了
//        boolean b = userNameExists(uname);
        if (userNameExists(uname)){
            out.println("用户已存在");
        }else {
            out.println("用户名可用！");
        }

    }

    /**
     *  判断用户名是否存在
     * @param uname 用户名
     * @return true / false
     */
    private boolean userNameExists(String uname) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("admin");
        nameList.add("root");
        nameList.add("laoxie");
        nameList.add("xiaosi");
        nameList.add("lutton");
        return nameList.contains(uname);
    }


}
