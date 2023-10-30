package com.lutton.controller;

import com.lutton.domain.Student;
import com.lutton.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName：StuController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Controller
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping("/selAll")
    public String sellAll(Model model){
        System.out.println("sellAll is running!");

        List<Student> stuList = stuService.getList();

        System.out.println(stuList);

        model.addAttribute("stuList", stuList);

        return "index.jsp";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView modelAndView, Student stu){
        System.out.println(" add is running!");

        stuService.add(stu);
        modelAndView.setViewName("/selAll");

        return modelAndView;
    }

//    更新学生的第一步操作： 查询到要修改的学生数据，并打开编辑页面
    @RequestMapping(value = "edit")
    public ModelAndView edit(ModelAndView modelAndView, int id){
        System.out.println("edit is running!~");

        Student stu = stuService.selByID(id);

        modelAndView.addObject("stu", stu);

        modelAndView.setViewName("edit.jsp");

        return modelAndView;
    }



    //    更新学生的第二步操作：根据用户提交的信息，修改数据库中的数据
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(ModelAndView modelAndView, Student stu){
        System.out.println("update is running!");

        stuService.update(stu);

        modelAndView.setViewName("/selAll");

        return modelAndView;
    }

    @RequestMapping("delete")
    public ModelAndView delete(ModelAndView modelAndView, int id){
        System.out.println("del is running!~");

        stuService.delete(id);

        modelAndView.setViewName("/selAll");

        return modelAndView;
    }

}
