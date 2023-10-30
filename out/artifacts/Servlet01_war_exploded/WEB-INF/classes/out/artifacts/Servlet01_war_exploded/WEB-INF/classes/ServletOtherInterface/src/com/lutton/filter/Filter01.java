package com.lutton.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName：Filter01
 * @Description： TODO             针对 特定的图片 执行 过滤器
 * @Author： Lut_Ton@GitHub
 */

/**
 *  这里的 Filter 是实现的 javax.servlet 里面的 Filter 接口，不是 java.util.logging 里面的的接口
 */
public class Filter01 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("meinv Filter is running.......");
        String age = request.getParameter("age");

        if ( age.isEmpty()){    // 判断是否 输入的内容为 null ，拦截，并给出提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("不是我说，你连输入姓名都没看见，就直接点美女了？这么心急？");
            System.out.println("不是我说，你连输入姓名都没看见，就直接点美女了？这么心急？");
        } else if (Integer.valueOf(age) < 18){   // 小于18，拦截，并给出提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("你小子还没成年，不利于身心健康！还是不给你看了.....");
            System.out.println("你小子还没成年，不利于身心健康！还是不给你看了.....");
        }else if (Integer.valueOf(age) > 80){    // 大于90，拦截，并给出提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("小老头，你都多大了还看这个？小心血脉喷张，惜命把！");
            System.out.println("小老头，你都多大了还看这个？小心血脉喷张，惜命把！");
        }else {
            filterChain.doFilter(request, response);   // 放行，让看
        }


//        filterChain.doFilter(request, response); // 放行
    }
}

