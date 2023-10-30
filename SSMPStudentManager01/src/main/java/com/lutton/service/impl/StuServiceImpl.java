package com.lutton.service.impl;

import com.lutton.domain.Student;
import com.lutton.mapper01.StuMapper;
import com.lutton.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：StuServiceImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */
@Service("stuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public void update(Student stu) {
        stuMapper.updateById(stu);
    }

    @Override
    public List<Student> getList() {
        return stuMapper.selectList(null);
    }

    @Override
    public void add(Student stu) {
        stuMapper.insert(stu);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {
        stuMapper.deleteById(id);
    }


    @Override
    public void delete() {

    }

    @Override
    public Student selByID(int id) {
        return stuMapper.selectById(id);
    }
}
