package com.lutton.service.impl;

import com.lutton.dao.StuDao;
import com.lutton.domain.Stu;
import com.lutton.service.StuService;

import java.util.List;

/**
 * @ClassName：StuServiceImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

//在web层用的是注解的形式,在这边就使用 手动添加配置文件的形式

public class StuServiceImpl implements StuService {
//    在这个类中一定会使用到 Dao 层的对象
    private StuDao stuDao;

    public StuDao getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    public List<Stu> getList() {
//        通过 Dao 层的查询方法, 获取到对应的数据
        List<Stu> stuList = stuDao.selAll();

//        一般在 Service 层可能还会对一些数据进行一些二次加工，由于本案例较为简单，忽略

        return stuList;
    }

    /**
     *  通过 id 获取要修改的学生信息
     * @param id
     * @return  要修改的学生的信息
     */
    @Override
    public Stu getEditStuById(int id) {
        Stu stu = stuDao.getStuById(id);
        return stu;
    }


    /**
     *  修改学生信息
     * @return
     */
    @Override
    public Boolean editStu(Stu stu) {
        return stuDao.editStu(stu);
    }

    @Override
    public int addStu(Stu stu) {
        return stuDao.addStu(stu);
    }

    @Override
    public boolean delById(int id) {
        return stuDao.delById(id);
    }
}
