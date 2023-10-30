package com.lutton.aopByanno;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName：MyAspect
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Component("myAspect")
@Aspect
public class MyAspect {

//    @Before("execution(public void com.lutton.aopByanno.*.*(..))")
//    public void before(){
//        System.out.println("before is running!");
//    }
//
//    @After("execution(public void com.lutton.aopByanno.*.*(..))")
//    public void after(){
//        System.out.println("after is running!");
//    }

    @Before("pointcut()")    //  这两种方式都行
    public void before(){
        System.out.println("before is running!");
    }

    @After("MyAspect.pointcut()")  //  这两种方式都行
    public void after(){
        System.out.println("after is running!");
    }

//    切点表达式的抽取
    @Pointcut("execution(public void com.lutton.aopByanno.*.*(..))")
    public void pointcut(){}
}
