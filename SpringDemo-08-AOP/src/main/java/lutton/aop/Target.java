package com.lutton.aop;

/**
 * @ClassName：Target
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

public class Target implements TargetInterface{
    @Override
    public void test() {
        System.out.println("test is running! ...");
    }
}
