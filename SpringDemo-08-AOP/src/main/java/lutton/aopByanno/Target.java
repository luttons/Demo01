package com.lutton.aopByanno;

import org.springframework.stereotype.Component;

/**
 * @ClassName：Target
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@Component("target")
public class Target implements TargetInterface {
    @Override
    public void test() {
        System.out.println("test is running! ...");
    }
}
