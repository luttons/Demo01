package com.lutton.Test;

import com.lutton.aop.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName：AopTest
 * @Description： TODO
 * @Author： Lut_Ton@GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class AopTest {

    @Autowired
    public TargetInterface target;

    @Test
    public void test01(){
        target.test();
    }

}
