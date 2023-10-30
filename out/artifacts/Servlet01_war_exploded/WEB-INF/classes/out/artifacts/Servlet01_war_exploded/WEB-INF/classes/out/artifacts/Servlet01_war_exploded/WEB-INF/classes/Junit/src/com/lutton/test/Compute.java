package com.lutton.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName：Compute
 * @Description： TODO    Junit 的简单使用
 * @Author： Lut_Ton@GitHub
 */

public class Compute {
    @Before
    public void init(){
        System.out.println("初始化完成");
    }

    @After
    public void close(){
        System.out.println("程序运行完毕！");
    }




    ////////////////////////////////////////////////////////////////////////
    public int add(int a, int b){
        return a + b + 9 ;
    }


    @Test   // 用这个注解修饰的都可以 独自运行
    public void printRes(){
//        System.out.println(add(3, 4));
        int res = add(3, 4);

//        断言的使用
        Assert.assertEquals(7, res);  // 此时会显示红色，并且还会显示 期待的结果与实际的结果的不同
        System.out.println("res = " + res);
    }
}

