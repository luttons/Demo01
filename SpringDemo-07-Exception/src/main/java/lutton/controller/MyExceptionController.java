package com.lutton.controller;

import com.lutton.exceprion.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName：MyExceptionController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Controller
public class MyExceptionController {

    @RequestMapping("/test01")
    public String test01(){
//        空指针异常
        String str = null;
        System.out.println(str.length());
        return "success.jsp";
    }

    @RequestMapping("/test02")
    public String test02(){
//        除零错误
        int num = 0;
        System.out.println(999 / num);
        return "success.jsp";
    }

    @RequestMapping("/test03")
    public String test03() throws MyException {
//        自定义异常
        throw new MyException();
    }

}
