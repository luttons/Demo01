package com.lutton.dao;

import com.lutton.domain.Stu;

import java.util.List;

public interface StuDao {
    List<Stu> selAll();

    Stu getStuById(int id);

    Boolean editStu(Stu stu);

    int addStu(Stu stu);

    boolean delById(int id);
}
