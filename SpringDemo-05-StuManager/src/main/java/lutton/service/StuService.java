package com.lutton.service;

import com.lutton.domain.Stu;

import java.util.List;

public interface StuService {

    List<Stu> getList();

    Stu getEditStuById(int id);

    Boolean editStu(Stu stu);

    int addStu(Stu stu);

    boolean delById(int id);
}
