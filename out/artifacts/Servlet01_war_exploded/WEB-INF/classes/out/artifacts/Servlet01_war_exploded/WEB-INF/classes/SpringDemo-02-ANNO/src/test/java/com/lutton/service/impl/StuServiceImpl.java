package com.lutton.service.impl;

import com.lutton.dao.StuDao;
import com.lutton.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName：StuServiceImpl
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Component("stuService")
//@Service("stuService")   // 同样可以替换上面一行
public class StuServiceImpl implements StuService {

    // 自动装配依赖。它告诉Spring框架要自动将一个合适的bean注入到该字段中。
    @Autowired
    // 指定具体的依赖注入的bean名称。它告诉Spring框架要注入名为 "stuDao" 的bean。
    // 表示把 StuDaoimpl 侧所定义的 stuDao 传给 下面紫色的 stuDao
    @Qualifier("stuDao")
//    @Resource(name = "stuDao")  // 可以替换上面两行
    private StuDao stuDao;   // 接收依赖注入的bean。它将接收名为 "stuDao" 的bean。

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
