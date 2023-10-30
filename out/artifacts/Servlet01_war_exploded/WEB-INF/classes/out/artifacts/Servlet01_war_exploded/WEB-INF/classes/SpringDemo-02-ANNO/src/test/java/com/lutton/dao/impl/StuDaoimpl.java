package com.lutton.dao.impl;

import com.lutton.dao.StuDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName：StuDaoimpl
 * @Description： TODO      接口的实现类
 * @Author： Lut_Ton@GitHub
 */


// 可以直接写一个 @Component。 此写法表示给当前的 bean 标签起一个 stuDao 的名字
@Component("stuDao")
//@Repository("stuDao") // 可以替换上面一行
//@Scope("prototype")    // 设置当前类的作用域，用在方法上就是设置方法的作用域，可以覆盖类的作用域
public class StuDaoimpl implements StuDao {

    @PostConstruct  // 设置 bean在初始化完成后执行的方法
    public void initMethod(){
        System.out.println("StuDaoImpl  对象初始化 ...");
    }

    @PreDestroy  // 设置 bean 被销毁的方法
    public void destroyMethod(){
        System.out.println("StuDaoImpl  对象销毁 ...");
    }

    @Value("小肆")    // 普通值的植入
    private String name;
    @Value("20")
    private int age;
    @Value("99.9")
    private float score;

    public StuDaoimpl(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 当前 Spring为单例模式，即使没有调用到 此类相关的内容，
//    但只要 Spring 加载就会自动创建一个 此类的对象， 等待我们去调用
    public StuDaoimpl() {
        System.out.println("StuDaoImpl 对象被创建了");
    }

    @Override
    public void show() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("score = " + score );
        System.out.println("=========================================");
    }
}
