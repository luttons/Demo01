package com.lutton.runTest;

import com.lutton.config.SpringConfiguration;
import com.lutton.dao.StuDao;
import com.lutton.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @ClassName：SpringJunitTest
 * @Description： TODO       Spring 整合 Junit
 * @Author： Lut_Ton@GitHub
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringJunitTest {

    @Resource(name = "stuService")
    private StuService stuService;
    @Resource(name = "dataSource")
    private DataSource dataSource;
    @Resource(name = "stuDao")
    private StuDao stuDao;

    @Test
    public void test() throws SQLException {

        System.out.println("test is running..");
        stuDao.show();
        stuService.serviceStuShow();

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
