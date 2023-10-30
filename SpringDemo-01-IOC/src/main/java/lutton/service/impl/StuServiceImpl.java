package com.lutton.service.impl;

import com.lutton.dao.StuDao;
import com.lutton.dao.impl.StuDaoimpl;
import com.lutton.service.StuService;

/**
 * @ClassName：StuServiceImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class StuServiceImpl implements StuService {
    private StuDao stuDao;

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }


    public StuServiceImpl(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    public StuServiceImpl() {
    }

    @Override
    public void serviceStuShow() {
        stuDao.show();
        System.out.println("serviceStuShow() is running! ...");
    }
}
