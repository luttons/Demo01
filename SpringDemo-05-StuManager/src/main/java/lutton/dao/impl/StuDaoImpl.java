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

    /**
     *  根据 id 查询学生的信息
     * @param id
     * @return  学生对象
     */
    @Override
    public Stu getStuById(int id) {
        Stu stu = jdbcTemplate.queryForObject("select * from stu where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Stu.class));

        return stu;
    }

    /**
     * 修改学生信息
     */
    @Override
    public Boolean editStu(Stu stu) {
        int id = stu.getId();
        String name = stu.getName();
        int age = stu.getAge();
        String sex = stu.getSex();
        float score = stu.getScore();
        String tel = stu.getTel();
        String classid = stu.getClassid();

        int rows = jdbcTemplate.update("update stu set `name`=?,`sex`=?,`age`=?, `score`=?, `tel`=?, `classid`=? where `id`=?", name, sex, age, score, tel, classid, id);

        if (rows > 0)
            return true;
        else
            return false;
    }

    @Override
    public int addStu(Stu stu) {
        int id = stu.getId();
        String name = stu.getName();
        int age = stu.getAge();
        String sex = stu.getSex();
        float score = stu.getScore();
        String tel = stu.getTel();
        String classid = stu.getClassid();

        int rows = jdbcTemplate.update("insert into `stu`(`name`, `sex`, `age`, `score`, `tel`, `classid`) value(?, ?, ?, ?, ?, ?)", name, sex, age, score, tel, classid);

        return rows;
    }

    @Override
    public boolean delById(int id) {
        int rows = jdbcTemplate.update("delete from `stu` where id=?", id);
        if (rows == 0)
            return false;
        else
            return true;
    }

}
