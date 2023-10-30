package com.lutton.factory;

import com.lutton.dao.StuDao;
import com.lutton.dao.impl.StuDaoimpl;

/**
 * @ClassName：MyFactory
 * @Description： TODO       工厂模式的 工厂类
 * @Author： Lut_Ton@GitHub
 */

public class MyFactory {
//    工厂静态方法
    public static StuDao getStuDao(){
        return new StuDaoimpl();
    }

//    工厂的普通方法
    public StuDao getStuDao0bj(){
        return new StuDaoimpl();
    }

}
