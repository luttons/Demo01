package com.lutton.controller;

import com.lutton.domain.Stu;
import com.lutton.service.StuService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @ClassName：StuController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Controller  // 将 StuController 放到容器里
@ComponentScan
public class StuController {
//    在当前的 web 的业务层中，一定会使用到后端的 Service 层

//    它可以用于标识一个类或者成员变量，表示需要从容器中获取对应的实例进行注入。
//    @Resource(name = "stuService")
//    private StuService stuService;

    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    StuService stuService = (StuService) app.getBean("stuService");


    /**
     *  查询
     * @param model
     * @return
     */
    @RequestMapping("/selAll")
    public String selAll(Model model){

        // 通过 getList 方法获取到所有的学生信息
        List<Stu> stuList = stuService.getList();

        model.addAttribute("stuList", stuList);

        return "index.jsp";
    }


    /**
     *  添加
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request){
        //        接收前台通过表单传递过来的参数
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        float score = Float.parseFloat(request.getParameter("score"));
        String tel = request.getParameter("tel");
        String classid = request.getParameter("classid");
        Stu stu = new Stu(name, sex, age, score, tel, classid);

        int i = stuService.addStu(stu);
        return "/selAll";
    }

    /**
     * 编辑页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, int id){
//        需要查询到要修改的学生信息，并携带到 edit.jsp中
//        通过 Service 去调用 Dao 层，获取要修改的学生数据
        Stu editStu = stuService.getEditStuById(id);
//        通过 Model 对象将要修改的学生信息带入到页面上
        model.addAttribute("stu", editStu);
        return "edit.jsp";
    }


    /**
     *  更新的动作
     * @param request
     * @param model
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, Model model, int id) throws IOException {
//        接收前台通过表单传递过来的参数
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        float score = Float.parseFloat(request.getParameter("score"));
        String tel = request.getParameter("tel");
        String classid = request.getParameter("classid");
        Stu stu = new Stu(id, name, sex, age, score, tel, classid);

//        判断是否修改成功
        Boolean b = stuService.editStu(stu);
        System.out.println(b.toString());
        if (b) {
            model.addAttribute("updates", "1");
            return "selAll";
        }else
            model.addAttribute("updates", "0");
            return "default.jsp";
    }


    /**
     *  删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del(int id){
        System.out.println("del is running! " +  "       " + id);
        boolean b = stuService.delById(id);
        return "/selAll";
    }


}
