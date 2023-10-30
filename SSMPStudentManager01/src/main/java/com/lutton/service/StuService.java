package com.lutton.service;

import com.lutton.domain.Student;

import java.util.List;

public interface StuService {
    void update(Student stu);

    List<Student> getList();
    void add(Student stu);
    void update();
    void delete(int id);

    void delete();

    Student selByID(int id);
}
