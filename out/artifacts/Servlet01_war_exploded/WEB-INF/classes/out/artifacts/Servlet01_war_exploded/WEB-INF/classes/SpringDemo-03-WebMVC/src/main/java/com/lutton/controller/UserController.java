package com.lutton.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lutton.global.MyValueObject;
import com.lutton.global.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName：UserController
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Controller  // 放到容器里面
//@RequestMapping("/user")   // 访问地址为： /myweb/user/test01
public class UserController {
    // localhost:8080/myweb/test01
    @RequestMapping("/test01")   // 请求响应，取代了 Servlet 中配置xml的操作
    public String test01() {
        System.out.println("UserController is running!");
//        return "success.jsp";  // 返回的就是要访问的页面的地址,默认是转发的方式
//        return "redirect:success.jsp";  // 重定向的方式，地址栏里的地址会改变
        return "/success.jsp";  // 转发的方式，也是默认方式，地址栏里的地址不会改变
    }


    @RequestMapping(value = "/test02", method = {RequestMethod.POST})
    public String test02() {
        System.out.println("这是用 requesatMapping 中的method参数来实现的 post方式的传值");
        return "/success.jsp";
    }


    // 必须有 这两个参数
    @RequestMapping(value = "/test03", params = {"username", "password"})
    public String test03() {
        System.out.println("这是用 requesatMapping 中的params参数。");
        return "/success.jsp";
    }


    //  用相应的请求参数代替 注解中的参数, 原始方式
    @RequestMapping("/test04")
    public String test04(HttpServletRequest request) {
        System.out.println("这是用请求参数获取 相应的参数值");

        System.out.println("name:" + request.getParameter("username"));
        System.out.println("password:" + request.getParameter("password"));
        return "/success.jsp";
    }


    // 模拟原始的请求转发的方式
    @RequestMapping("/test05")
    public void test05(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是用请求参数获取 相应的参数值");

        System.out.println("name:" + request.getParameter("username"));
        System.out.println("password:" + request.getParameter("password"));

//        request.getRequestDispatcher("/success.jsp")  表示获取一个请求调度器         用于将请求转发到指定的目标资源。
//        forward  方法，将当前的请求和响应对象传递给目标资源。
        request.getRequestDispatcher("/success.jsp").forward(request, response);
    }


    // 这种方式可以在 success 用el表达式 获取到相应的参数并显示出来
    @RequestMapping("/test06")
    public ModelAndView test06(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("username", request.getParameter("username"));
        modelAndView.addObject("password", request.getParameter("password"));

//        设置要跳转到的视图. model 就是要携带的数据
        modelAndView.setViewName("/success.jsp");

        return modelAndView;
    }

//    数据的回写,就记住这一种方式就行了
    // 和 test06 有相同的作用, 更简洁。 可以直接把 modelAndview 对象放在方法的参数里面，并直接返回
    @RequestMapping("/test07")
    public ModelAndView test07(ModelAndView modelAndView) {

        modelAndView.addObject("username", "lutton");
        modelAndView.addObject("password", "nottul");

        modelAndView.setViewName("/success.jsp");

        return modelAndView;
    }


    //    把ModelAndView分开写
    @RequestMapping("/test08")
    public String test08(Model model) {

        model.addAttribute("username", "xiaosi");
        model.addAttribute("password", "isoaix");

        return "/success.jsp";  // 必须写字符串的形式了
    }


    @RequestMapping
    public void test09(HttpServletResponse response) throws IOException {
//        解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println("Hello 小肆");
    }



    //    设置乱码问题
    @RequestMapping(value = "/test10", produces = {"text/html;charset=utf-8"})
//使用 @ResponseBody 注解时，返回值会被直接写入HTTP响应的主体中，而不会经过视图解析器。
    @ResponseBody   // 标注当前的映射为 响应体内容的回写（把内容写在页面上）
    public String test10() {
        System.out.println("9999999999999999999999999999");
        return "Hello 小肆";
    }


    @RequestMapping("/test11")
    @ResponseBody   // 加上这个注解之后，返回的内容就会当作 字符串来处理;
    public String test11() {
        System.out.println("test11 is running!");
        return "{\"username\":\"root\", \"password\":\"toor\"}";
    }


    //     返回  引用型数据类型  所对应的Json
//    需要jackson 的依赖, mvc的配置文件也需要加载 mvc 驱动
    @RequestMapping("/test12")
    @ResponseBody   // 加上这个注解之后，返回的内容就会当作 字符串来处理;
    public User test12() {
        System.out.println("test12 is running!");
        return new User("lutton", "nottul");
    }


    //     手动将引用型数据类型转换成 字符串
    @RequestMapping("/test13")
    @ResponseBody   // 加上这个注解之后，返回的内容就会当作 字符串来处理;
    public String test13() throws JsonProcessingException {
        System.out.println("test13 is running!");
        User user = new User("lutton", "nottul");

        ObjectMapper om = new ObjectMapper();
        String userJson = om.writeValueAsString(user);
        return userJson;
    }


    //    获取请求参数中的 普通参数（传统方法）
    @RequestMapping("/test14")
    @ResponseBody
    public void test14(HttpServletRequest request) {
        System.out.println(
                "username；" + " : " +
                        request.getParameter("username")
                        + ";  password : " +
                        request.getParameter("password")
        );
    }


    //    test14的改进方式, 参数名要与前端参数名相同
    @RequestMapping("/test15")
    @ResponseBody
    public void test15(String username, String password) {
        System.out.println(username + ": " + password);
    }


    //    获取 POJO 类型的参数

    /**
     * POJO是一个缩写，代表"Plain Old Java Object"，意为"普通的旧Java对象"。
     * 它是指一个简单的Java类，没有继承任何特定的框架或类库，也没有实现任何特定的接口。
     *
     * POJO类通常用于表示领域对象或数据传输对象（DTO），用于封装数据和业务逻辑。
     * 它们通常包含私有字段（属性）、公共的getter和setter方法以及其他业务方法。
     */
    @RequestMapping("/test16")
    @ResponseBody
    public void test16(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }



    //    获取 数组  类型的参数
    @RequestMapping("/test17")
    @ResponseBody
//    这个参数就是 页面端， 已经选中的选项的 value， 所构成的集合
    public void test17(String[] hobby) {
        String[] info = {"琴", "棋", "书", "画"};
        for (String index : hobby) {
            System.out.println(info[Integer.parseInt(index)]);
        }
    }



    //    获取 集合 类型的参数(与POJO类型极其类似)
//     需要一个自定义类 MyValueObject 的转换
    @RequestMapping("/test18")
    @ResponseBody
//    这个参数就是 页面端， 已经选中的选项的 value， 所构成的集合
    public void test18(MyValueObject mvo) {
        System.out.println(mvo);
    }

//    AJAX的方式
//    通过注解的方式获取 集合类型的参数， 比上面的常用，因为它不需要 mvo 作为中转
    @RequestMapping(value = "/test19", method = RequestMethod.POST)
    @ResponseBody
    public void test19(@RequestBody List<User> userList) {
        System.out.println(userList);
    }


//    参数绑定，解决前后参数名字不一致的问题， 只要一个注解
    @RequestMapping(value = "/test20" )
    @ResponseBody
    public void test20(@RequestParam(value = "uname", defaultValue = "lutton") String username, @RequestParam("pwd") String password) {

        System.out.println(username + " : " + password);
    }



//    restful 风格的代码，直接吧请求参数写到 url 里面，
//    并且请求参数用 {占位符} 的形式来表示
//    将占位符 的值传递给 @PathVariable 所标识的参数
//    再将参数的值传递给 方法的实际参数 String username

//    @PathVariable  是Spring框架中的一个注解，用于将URL路径中的变量值绑定到方法的参数上。
//    也就是将 username1 的值绑定给 username
    @RequestMapping(value = "/test21/{username1}/{password}" )
    @ResponseBody
    public void test21(@PathVariable("username1") String username, @PathVariable("password") String password) {

        System.out.println(username + " : " + password);
    }



//    获取请求头中的内容. 可以获取 Host 地址, Cookie 等等,只需要跟上相应的参数名即可
    @RequestMapping(value = "/test22" )
    @ResponseBody
    public void test22(@RequestHeader("Host") String host) {
        System.out.println(host);
    }



//    获取 请求头中 jsession 参数中的 某一个键值对 中键所对应的值
    @RequestMapping("/test23")
    @ResponseBody
    public void test23(@CookieValue("JSESSIONID") String jessionId){
        System.out.println(jessionId);
    }


//    spring 框架中会存在一些数据类型的自动转换: String -> int 等等
//    某些特定格式的日期也能自动转换: 2023/9/22 也可以自动转换
//    但 2023-9-22 就无法自动转换
    @RequestMapping("/test24")
    @ResponseBody
    public void test24(Date date){
        System.out.println(date);
    }
    /**
     *  自定义类型转换的方式：
     *  1. 写自己的转换类，并实现 Converter 接口
     *  2. 在 MVC 的配置文件中声明转换器
     *  3. 在 MVC 的配置文件中 <annotation-driven>中引用转换器
     */




//    单文件上传测试
//    MultipartFile uploadFile ：
//      这是一个 Spring 框架提供的特殊类型，用于接收客户端上传的文件。
//      获取文件的原始文件名（ getOriginalFilename() ）、文件内容（ getBytes() ）等。

//    具体步骤:
//    1. pom.xml 中导入两个依赖(fileupload, io)
//    2. MVC 配置文件中 配置文件上传解析器
//    3. 前后端代码: 必须是post方式的提交, 必须有 enctype="multipart/form-data" 属性
//                    提交类型必须是 file
    @RequestMapping(value = "/test25", method = RequestMethod.POST)
    @ResponseBody
    public void test25(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        String fileName = username + "-" + uploadFile.getOriginalFilename();
//        这个存储目录需要自己手动创建
        uploadFile.transferTo(new File("D:\\SpringMVCuploadTest-可删除\\" + fileName));
    }



//    多文件上传，按住shift加选
    @RequestMapping(value = "/test26", method = RequestMethod.POST)
    @ResponseBody
    public void test26(String username, MultipartFile[] uploadFiles ) throws IOException {
        System.out.println(username);

        for (MultipartFile uploadFile : uploadFiles) {
            String filename = username + "-" + uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("D:\\SpringMVCuploadTest-可删除\\" + filename));
        }


    }


}



