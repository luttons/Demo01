package com.lutton.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName：Filter02
 * @Description： TODO   针对 所有的 *.do(Servlet) 执行过滤器
 * @Author： Lut_Ton@GitHub
 */

public class Filter02 implements Filter {
    /**
     *   没有限制条件，所以在 运行任何 .do 文件的时候，都会执行这个方法
     *   因此，在打开 所有的 .do 文件的时候， 输出的格式都不会是乱码
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }
}
