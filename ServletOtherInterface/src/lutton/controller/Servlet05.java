package com.lutton.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName：Servlet03
 * @Description： TODO        session 对象设置 属性
 * @Author： Lut_Ton@GitHub
 */

/**
 *  .浏览器不关闭的情况下：默认生存周期（最大闲置时间）： 30 min
 *  .只要浏览器关闭， Session 对象就会别销毁
 *  .一个浏览器在启动时，只会有一个 Session 对象
 *      （不管执行了什么不同的文件,Servlet05 和 Servlet06的 Session对象是相同的）
 *  .Session 实际上是依赖于 cookie 的 . cookie 给 session 设置一个 id，
 *      后端根据这个 id来获取 session对象，保证使用的是同一个 session 对象
 *
 */
public class Servlet05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        通过请求对象(req)获取 Session 对象
        HttpSession session01 = req.getSession();

//        设置属性
        session01.setAttribute("teacherName","LaoXie");
        session01.setAttribute("studentName","XiaoSi");


    }
}
