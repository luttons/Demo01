package com.lutton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName：TestController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Controller
public class TestController {

    @RequestMapping("/runTest")
    public ModelAndView runTest(ModelAndView modelAndView, String username){

        System.out.println("runTest is running!");

//        modelAndView.addObject("username", "lutton");
        modelAndView.addObject("username", username);

        modelAndView.setViewName("success.jsp");

        return modelAndView;

    }
}
