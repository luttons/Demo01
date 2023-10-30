package com.lutton.test;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @ClassName：MyJdbcTemplateTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyJdbcTemplateTest {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/qyk_java";
    private final String USER = "root";
    private final String PWD = "toor";


    @Test   // 传统的 jdbc 方式
    public void test01() throws PropertyVetoException {
        System.out.println("test01 is running!");

//        定义一个数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(DRIVER);
        dataSource.setJdbcUrl(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PWD);

//        定义 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

//        插入一条数据
        int rows = jdbcTemplate.update("insert into user(username, password) value(?, ?)", "lutton", "nottul");

        System.out.println(rows + "行 数据受相应!");
    }



    @Test  // IOC(控制反转)模式
    public void test02(){
//        通过配置文件获取容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        通过容器对象获取 一个bean对象
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);

        //        插入一条数据
        int rows = jdbcTemplate.update("insert into user(username, password) value(?, ?)", "lutton01", "nottul10");

        System.out.println(rows + "行 数据受相应!");
    }

}
