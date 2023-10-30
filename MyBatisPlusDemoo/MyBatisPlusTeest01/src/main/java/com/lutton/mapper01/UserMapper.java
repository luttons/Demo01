package com.lutton.mapper01;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lutton.dao.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  注意： BaseMapper<User> 有一个泛型
 */
public interface UserMapper extends BaseMapper<User> {

//    自定义方法
    @Select("select * from user")
    List<User> selAll();
}
