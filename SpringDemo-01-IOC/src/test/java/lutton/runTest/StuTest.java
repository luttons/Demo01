package com.lutton.runTest;

import com.lutton.dao.StuDao;
import com.lutton.dao.impl.StuDaoimpl;
import com.lutton.service.StuService;
import com.lutton.service.impl.StuServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName：StuTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class StuTest {
    @Test
    public void test01(){
//            StuDaoimpl stuDao = new StuDaoimpl();
//            stuDao.show();

//==========================================================================================

//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        Object stuDao = app.getBean("stuDao"); //默认返回的是 Object类型的，需要强制类型转换
//        StuDao stuDao = (StuDao) app.getBean("stuDao");
//        stuDao.show();


//==========================================================================================


        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        StuDao stuDao1 = (StuDao) app.getBean("stuDao");
//        StuDao stuDao2 = (StuDao) app.getBean("stuDao");

//        System.out.println(stuDao1);  // 单例模式下，这俩地址相同
//        System.out.println(stuDao2);  // 多例模式下，这俩地址不相同

        stuDao1.show();

        /**
         *  单例模式下： 对象在指定容器对象（地址）的时候就已经被创建了
         *  多例模式下： 对象在调用 getBean 方法的时候才被创建
         */
//        释放容器对象
        app.close();
    }


    @Test
//        传统写法
    public void test02(){
        StuDaoimpl stuDao = new StuDaoimpl();
        StuServiceImpl stuService = new StuServiceImpl();
        stuService.setStuDao(stuDao);
        stuService.serviceStuShow();
    }

    /**
     *   工厂方法（set）注入
     *   带参构造方法 注入
     */
    @Test
    public void test03(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        如果 StuService 类型的 bean 对象在核心配置文件中存在多个，那就得使用 id 来获取
//        StuService stuService1 = (StuService) app.getBean("stuService");

//        StuServiceImpl 类型的 bean 对象在核心配置文件中只存在一个，可以用此方法来获取
        StuServiceImpl stuService = app.getBean(StuServiceImpl.class);
        stuService.serviceStuShow();

        app.close();
    }




}
