package com.lutton.controller;

import com.lutton.domain.User;
import com.lutton.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName：UserController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
//    @RequestMapping("/selAll")
//    public String selAll(){
//        return "show.jsp";
//    }
//
//    @RequestMapping("/add")
//    public String add(){
//        return "add.jsp";
//    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){

        User user = userService.doLogin(username, password);

        System.out.println(user);
        if (null != user){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        return "selAll";
    }
}
