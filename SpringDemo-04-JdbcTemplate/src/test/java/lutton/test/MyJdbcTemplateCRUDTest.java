package com.lutton.test;

import com.lutton.global.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @ClassName：MyJdbcTemplateCRUDTest
 * @Description： TODO    Spring 整合 Junit 测试 crud
 * @Author： Lut_Ton@GitHub
 */

//@RunWith  注解的作用是指定测试类的运行器（Runner）。、
// 它允许我们使用不同的运行器来扩展或修改测试的行为。
// 这个注解告诉JUnit在运行测试时使用Spring的测试运行器。
// 它允许我们在测试中使用Spring的功能。
@RunWith(SpringJUnit4ClassRunner.class)
//指定 Spring 应用程序上下文的配置文件位置。
// 它告诉 Spring 在运行测试之前加载指定的配置文件，并创建应用程序上下文。
@ContextConfiguration("classpath:ApplicationContext.xml")
public class MyJdbcTemplateCRUDTest {
// 可以用于自动将一个 bean 注入到另一个 bean 中，从而实现依赖关系的自动装配。
//    将 配置文件中的 jdbcTemplate 自动装配到 JdbcTemplate.
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void updateTest(){
        int rows = jdbcTemplate.update("update user set username=? where username=?", "lutton11", "lutton");
        System.out.println(rows + " 行受相应 ");
    }

    @Test
    public void deleteTest(){
        int rows = jdbcTemplate.update("delete from user where username=?", "lutton11");
        System.out.println(rows + " 行数据受相应");
    }

    @Test
    public void insertTest(){
        int rows = jdbcTemplate.update("insert into user(username, password) value(?,?)", "lutton22", "22nottul");
        System.out.println(rows + " 行数据受相应");
    }

    @Test
    public void selectAllTest(){
        List<User> userList = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User.class));

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void selByIDTest(){
        Map<String, Object> user = jdbcTemplate.queryForMap("select * from user where id=?", 6);
        System.out.println(user);
        System.out.println("id = " + user.get("id"));
        System.out.println("username = " + user.get("username"));
        System.out.println("password = " + user.get("password"));
        System.out.println("competence = " + user.get("competence"));
    }

    @Test
    public void selByUsernameTest(){
        User user = jdbcTemplate.queryForObject("select * from user where username=?", new BeanPropertyRowMapper<>(User.class), "lutton22");

        System.out.println(user);
        System.out.println("id = " + user.getId());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("competence = " + user.getStatus());
    }

    @Test
    public void selCountTest(){
        Integer count = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);

        System.out.println("一共有 " + count + " 个用户");
    }

}
