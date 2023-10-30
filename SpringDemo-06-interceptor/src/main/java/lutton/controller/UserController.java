package com.lutton.controller;

import com.lutton.domain.User;
import com.lutton.service.UserService;
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
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/selAll")
    public String selAll(){
        return "show.jsp";
    }

    @RequestMapping("/add")
    public String add(){
        return "add.jsp";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request){
        User user = userService.doLogin(username, password);
        if (null != user){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
        }
        return "selAll";
    }
}
