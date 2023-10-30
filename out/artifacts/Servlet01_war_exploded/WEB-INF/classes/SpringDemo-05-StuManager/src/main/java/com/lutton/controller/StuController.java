package com.lutton.controller;

import com.lutton.domain.Stu;
import com.lutton.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName：StuController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Controller  // 将 StuController 放到容器里
public class StuController {
//    在当前的 web 的业务层中，一定会使用到后端的 Service 层

//    它可以用于标识一个类或者成员变量，表示需要从容器中获取对应的实例进行注入。
    @Resource(name="stuService")
    private StuService stuService;


    @RequestMapping("/selAll")
    public String selAll(Model model){

        // 通过 getList 方法获取到所有的学生信息
        List<Stu> stuList = stuService.getList();

        model.addAttribute("stuList", stuList);

        return "index.jsp";
    }
}
