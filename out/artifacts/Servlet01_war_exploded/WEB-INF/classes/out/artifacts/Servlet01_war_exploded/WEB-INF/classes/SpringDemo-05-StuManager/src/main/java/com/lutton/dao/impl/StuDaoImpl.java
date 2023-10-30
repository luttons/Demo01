package com.lutton.dao.impl;

import com.lutton.dao.StuDao;
import com.lutton.domain.Stu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName：StuDaoImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class StuDaoImpl implements StuDao {
//    在这里一定会用到数据库相关的内容, jdbcTemplate
    private JdbcTemplate jdbcTemplate;

//     留着在进行配置文件注入的时候使用
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Stu> selAll() {
        List<Stu> stuList = jdbcTemplate.query("select * from stu", new BeanPropertyRowMapper<>(Stu.class));
        return stuList;
    }
}
