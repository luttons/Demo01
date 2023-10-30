package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @ClassName：DoRegist
 * @Description： TODO     做注册成功的操作
 * @Author： Lut_Ton@GitHub
 */

public class DoRegistered extends HttpServlet {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
////        1.注册驱动
//        Class.forName("com.lutton.controller.DoRegistered");
//
////        2.建立连接
//        final String URL = "jdbc:mysql://localhost:3306/qyk_java";
//        final String USER = "root";
//        final String PWD = "toor";
//        Connection conn = DriverManager.getConnection(URL, USER, PWD);
//
////      3.创建执行 sql 语句的对象
//        Statement st = conn.createStatement();
//
////        4.组织并执行 sql语句
//        String sql = "insert into `user`(`username`, `password`) value(`"+ username +"`, ``)";
//
//    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        字符集处理
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("uname");
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");
        System.out.println("username  " + username);
        System.out.println("pwd1  " + pwd1);
        System.out.println("pwd2  " + pwd2);
        System.out.println("pwd的类型：" + pwd1.getClass().getName());

        PrintWriter out = resp.getWriter();
        if (pwd1.equals(pwd2)) {
            out.write("ok");
        } else {
            out.print("两次输入的密码不一样！请重新输入");
        }


//        1
        try {
            Class.forName("com.lutton.controller.DoRegistered");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        2
        final String URL = "jdbc:mysql://localhost:3306/qyk_java";
        final String USER = "root";
        final String PWD = "toor";
        Connection conn;
        try {
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        3
        Statement st;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        4
        String sql = "insert into `user`(`username`, `password`) value('" + username + "', '" + pwd1 + "')";
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        6
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
