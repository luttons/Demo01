package com.lutton;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.lutton.dao.User;
import com.lutton.mapper01.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName：MyBatisPlusTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class MyBatisPlusTest {
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory build = new MybatisSqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = build.openSession();
    }

    @Test
    public void test01(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void test02(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
