package com.lutton.runTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.lutton.config.SpringConfiguration;
import com.lutton.global.MyDruidDataSource;
import com.lutton.service.StuService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName：c3p0Test01
 * @Description： TODO        手动配置数据源
 * @Author： Lut_Ton@GitHub
 */

public class DataSourceTest {
//    全局变量
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/qyk_java";
    private static final String USER = "root";
    private static final String PWD = "toor";

    @Test // c3p0 的原始注入方式测试
    public void c3p0Test() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(MYSQL_DRIVER);
        dataSource.setJdbcUrl(MYSQL_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PWD);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        conn.close();
    }

    @Test  // drud 的原始注入方式测试
    public void drudTest01() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(MYSQL_DRIVER);
        dataSource.setUrl(MYSQL_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PWD);
        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);

        conn.close();
    }



    @Test     // 通过 配置文件 配置的 drud 数据源测试
    public void drudTest02() throws SQLException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

        conn.close();
    }


    @Test
    public void test04(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        StuService stuService = (StuService) app.getBean("stuService");
        stuService.serviceStuShow();

        app.close();
    }


    @Test    //  MyDruidDataSource 类的测试 （自定义Drud连接池的测试）
    public void test05() throws SQLException {
//        获取容器对象
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        通过容器对象获取 bean 对象（自定义 bean）
        MyDruidDataSource bean = app.getBean(MyDruidDataSource.class);
//        通过 bean 对象获取 DataSource 对象
        DataSource dataSource = bean.getDataSource();  // 自己写的方法
//        通过 DataSource 对象获取 数据库连接
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
        conn.close();
    }


    @Test  // 将所有配置都写入到 Java代码中的 SpringConfigutation 的测试
    public void test06() throws SQLException {
//        新的 获取配置文件的方法
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        DataSource dataSource = (DataSource) app.getBean("dataSource");

        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }


}
