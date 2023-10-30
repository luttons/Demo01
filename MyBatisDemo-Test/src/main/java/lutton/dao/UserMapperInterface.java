package com.lutton.dao;

import com.lutton.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapperInterface {
    @Select("select * from user")
    List<User> selAll();

    @Select("select * from user where username=#{username}")
    User selByUserName(String username);

    @Insert("insert into user(username, password, competence) values(#{username}, #{password}, #{competence})")
    void add(User user);

    @Update("update user set password=#{password}, competence=#{competence} where username=#{username}")
    void update(User user);

    @Delete("delete from user where username=#{userName}")
    void deleteByName(String name);

    @Select("<script>" +
            "select * form user" +
            "<where>" +
            "   <if test='username != null'> username=#{username} </if>" +
            "   <if test='password != null'> password=#{password} </if>" +
            "</where>" +
            "</script>")
    List<User> selBySomething(User user);


    List<User> selByNames(List<String> list);
}
