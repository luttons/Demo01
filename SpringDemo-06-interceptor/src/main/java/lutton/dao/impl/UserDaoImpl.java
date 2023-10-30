package com.lutton.dao.impl;

import com.lutton.dao.UserDao;
import com.lutton.domain.User;
import com.lutton.service.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName：UserDaoImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User loginCheck(String username, String password) {
//        查询不到会出现异常
        User user = jdbcTemplate.queryForObject("select * from user where username=? and password=?", new BeanPropertyRowMapper<>(User.class), username, password);

        System.out.println(user);

        return user;
    }
}
