package com.lutton.resolver;

import com.lutton.exceprion.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.List;

/**
 * @ClassName：MyExceptionResolver
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("MyExceptionResolver.jsp");

//        instanceof  是 Java 中的一个关键字，用于判断一个对象是否是指定类或其子类的实例。
        if (e instanceof NullPointerException){
            modelAndView.addObject("info", "空指针异常");
        }else if (e instanceof ArithmeticException){
            modelAndView.addObject("info", "算数异常");
        }else if (e instanceof MyException){
            modelAndView.addObject("info", "自定义异常");
        }else {
            modelAndView.addObject("info", "其他异常");
        }

        return modelAndView;
    }
}
