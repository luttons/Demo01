package com.lutton.controller;

import com.lutton.controller.global.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName：showStuServlet
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class showStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        模拟从数据库中获取数据
        ArrayList<Student> stuList = getStuInfo();
        req.setAttribute("stuList", stuList);
        req.getRequestDispatcher("/test04.jsp").forward(req, resp);
    }

    /**
     * 模拟数据库查询的动作
     * @return  学生信息集合
     */
    private ArrayList<Student> getStuInfo() {
        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(new Student( "张三", "男", 17, 99));
        stuList.add(new Student( "李四", "女", 16, 93));
        stuList.add(new Student( "王五", "男", 17, 95));
        stuList.add(new Student( "赵六", "男", 18, 99));
        stuList.add(new Student( "牛七", "女", 17, 97));
        stuList.add(new Student( "马八", "男", 19, 90));
        return stuList;
    }
}
