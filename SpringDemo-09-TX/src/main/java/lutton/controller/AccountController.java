package com.lutton.controller;

import com.lutton.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName：AccountController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

/**
 *  当执行 transfer 方法的时候，
 *  如果 在 out方法 和 in 方法之间出现一个异常，
 *  那么 out 被执行， in 没有被执行
 *  这就导致只有钱减少，没有钱增加。
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("L2X500")
    public String L2X500(Model model){
        accountService.transfer("LaoXie", "XiaoSi", 500);
        model.addAttribute("info", "老邪成功向小肆转账500！");
        System.out.println("老邪成功向小肆转账500！");
        return "success.jsp";
    }

    @RequestMapping("X2L500")
    public String X2L500(Model model){
        accountService.transfer("XiaoSi","LaoXie",  500);
        model.addAttribute("info", "小肆成功向老邪转账500！");
        System.out.println("小肆成功向老邪转账500！");
        return "success.jsp";
    }



}
